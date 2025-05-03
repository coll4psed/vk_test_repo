package pages;

import abstractions.LoadablePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import valueObjects.GroupData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ExistingGroupPage extends LoadablePage {
    private final SelenideElement groupTitle =
            $(By.xpath(".//*[contains(@class, 'group-name_h')]"));
    private final SelenideElement subscribeButton =
            $(By.xpath(".//*[contains(@class, 'groups-join-button')]"));
    private final SelenideElement unSubscribeButton =
            $(By.xpath(".//*[contains(@class, 'leave-menu-item')]"));
    private final SelenideElement feedList =
            $(By.xpath(".//*[contains(@class, 'feed-list')]"));
    private final SelenideElement descriptionField =
            $(By.xpath(".//*[contains(@class, 'group-info_desc')]"));

    public void subscribe() {
        subscribeButton
                .shouldBe(visible.because("Кнопка подписаться не найдена"))
                .click();
    }

    public boolean isSubscribed() {
        subscribeButton
                .shouldBe()
                .click();
        return unSubscribeButton
                .shouldBe(visible.because("Кнопка отписаться не найдена"))
                .isDisplayed();
    }

    public boolean isTamTamPage() {
        GroupData expected = new GroupData("ТамТам",
                "Официальная группа о приложении ТамТам! " +
                        "Установить наше приложение можно по ссылкам: " +
                        "Android: " +
                        "iOS:",
                true);
        String description = descriptionField.getText();
        GroupData actual = new GroupData(groupTitle.getText(), description, isSubscribed());
        return expected.equals(actual);
    }

    @Override
    public void checkPage() {
        feedList
                .shouldBe(visible.because("Блок с новостями не найден"));
        descriptionField
                .shouldBe(visible.because("Блок с описанием группы не найден"));
    }
}
