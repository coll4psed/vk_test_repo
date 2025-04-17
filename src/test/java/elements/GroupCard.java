package elements;

import abstractions.IGroupCard;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class GroupCard implements IGroupCard {
    private final SelenideElement root;

    public GroupCard(SelenideElement rootElement) {
        this.root = rootElement;
    }

    public SelenideElement getSubscribeButton() {
        return root.$(By.xpath(".//*[contains(@class, 'groups-join')]"));
    }

    public SelenideElement getOpenLink() {
        return root.$(By.xpath(".//*[@class='similar-group-holder']/a"));
    }

    public GroupCard subscribe() {
        getSubscribeButton()
                .click();

        return this;
    }

    public boolean isSubscribed() {
        return getOpenLink()
                .isDisplayed();
    }

    public GroupCard waitPageToUpdate() {
        getOpenLink()
                .shouldBe(visible.because("Кнопка открыть отсутствует на странице"));

        return this;
    }
}
