package pages;

import abstractions.PageWithCommonComponents;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import valueObjects.GroupData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SpecificGroupPage extends PageWithCommonComponents {
    private final SelenideElement groupTitle =
            $(By.xpath(".//*[contains(@class, 'group-name_h')]"));
    private final SelenideElement subscribeGroupButton =
            $(By.xpath(".//*[contains(@class, 'join-button')]"));
    private final SelenideElement unSubscribeGroupButton =
            $(By.xpath(".//*[contains(@class, 'leave-menu-item')]"));
    private final SelenideElement additionalUnSubscribeGroupButton =
            $(By.xpath(".//*[text() = 'Отписаться']"));
    private final SelenideElement feedList =
            $(By.xpath(".//*[contains(@class, 'feed-list')]"));
    private final SelenideElement descriptionField =
            $(By.xpath(".//*[contains(@class, 'group-info_desc')]"));

    public boolean isSubscribed() {
        return subscribeGroupButton
                .shouldHave(text("Подписаны"))
                .getText().contains("Подписаны");
    }

    public boolean isSpecificGroupSubscribed(String groupTitleText, String groupDescSubstring) {
        GroupData expected = new GroupData(groupTitleText, true, true);
        GroupData actual = new GroupData(groupTitle.getText(),
                isDescriptionContainsText(groupDescSubstring),
                isSubscribed());
        return expected.equals(actual);
    }

    private boolean isDescriptionContainsText(String descSubstring) {
        return descriptionField.getText().contains(descSubstring);
    }

    public SpecificGroupPage subscribeSpecificGroup() {
        subscribeGroupButton
                .shouldBe(visible.because("Кнопка \"Подписаться\" не найдена"))
                .click();

        return this;
    }

    public void unSubscribeSpecificGroup() {
        subscribeGroupButton
                .shouldBe(visible.because("Кнопка \"Подписаться\" не найдена"))
                .click();
        unSubscribeGroupButton
                .shouldBe(visible.because("Кнопка \"Отписаться\" не найдена"))
                .click();
        additionalUnSubscribeGroupButton
                .shouldHave(text("Отписаться"))
                .click();
    }

    @Override
    public void checkPage() {
        feedList
                .shouldBe(visible.because("Блок с новостями не найден"));
        descriptionField
                .shouldBe(visible.because("Блок с описанием группы не найден"));
    }
}
