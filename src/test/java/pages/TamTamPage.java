package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import valueObjects.GroupProfileData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TamTamPage {
    private final SelenideElement groupTitle =
            $(By.xpath(".//*[contains(@class, 'group-name_h')]"));
    private final SelenideElement subscribeButton =
            $(By.xpath(".//*[contains(@class, 'groups-join-button')]"));
    private final SelenideElement unSubscribeButton =
            $(By.xpath(".//*[contains(@class, 'leave-menu')]"));

    public void subscribe() {
        subscribeButton
                .shouldBe(visible.because("Кнопка подписаться не найдена"))
                .click();
    }

    public boolean isSubscribed() {
        subscribeButton.click();
        unSubscribeButton.shouldBe(visible.because("Кнопка отписаться не найдена"));
        return unSubscribeButton.isDisplayed();
    }

    public boolean isTamTamPage() {
        GroupProfileData expected = new GroupProfileData("ТамТам");
        GroupProfileData actual = new GroupProfileData(groupTitle.getText());

        return expected.equals(actual);
    }
}
