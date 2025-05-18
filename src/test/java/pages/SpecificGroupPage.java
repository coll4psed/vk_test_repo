package pages;

import abstractions.LoadablePage;
import abstractions.PageWithCommonComponents;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import valueObjects.GroupData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SpecificGroupPage extends PageWithCommonComponents {
    private final SelenideElement groupTitle =
            $(By.xpath(".//*[contains(@class, 'group-name_h')]"));
    private final SelenideElement subscribedGroupButton =
            $(By.xpath(".//*[contains(@class, 'group-join-button')]"));
    private final SelenideElement feedList =
            $(By.xpath(".//*[contains(@class, 'feed-list')]"));
    private final SelenideElement descriptionField =
            $(By.xpath(".//*[contains(@class, 'group-info_desc')]"));

    public boolean isSubscribed() {
        return subscribedGroupButton.getText().contains("Подписаны");
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

    @Override
    public void checkPage() {
        feedList
                .shouldBe(visible.because("Блок с новостями не найден"));
        descriptionField
                .shouldBe(visible.because("Блок с описанием группы не найден"));
    }
}
