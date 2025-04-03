package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final SelenideElement subscribeButton = $(By.xpath(
            ".//button[contains(@class, 'groups-join')]"));

    private final SelenideElement openLink = $(By.xpath(
            ".//div[@class='similar-group-holder']/a"));

    public void subscribe() {
        subscribeButton
                .shouldBe(visible.because("Кнопка подписаться отсутствует на странице"))
                .click();
    }

    public void waitForPageToLoad() {
        openLink
                .shouldBe(visible.because("Кнопка открыть отсутствует на странице"));
    }

    public boolean isSubscribed() {
        return openLink
                .isDisplayed();
    }
}
