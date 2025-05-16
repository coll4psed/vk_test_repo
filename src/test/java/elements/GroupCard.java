package elements;

import abstractions.IGroupCard;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class GroupCard implements IGroupCard {
    private final SelenideElement root;
    private final By subscribeButton =
            By.xpath(".//*[contains(@class, 'groups-join')]");
    private final By openLink =
            By.xpath(".//*[@class='similar-group-holder']/a");

    public GroupCard(SelenideElement rootElement) {
        this.root = rootElement;
    }

    private SelenideElement getSubscribeButton() {
        return root.$(subscribeButton)
                .shouldBe(visible.because("Кнопка подписки не найдена"));
    }

    private SelenideElement getOpenLink() {
        return root.$(openLink)
                .shouldBe(visible.because("Кнопка открыть не найдена"));
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
