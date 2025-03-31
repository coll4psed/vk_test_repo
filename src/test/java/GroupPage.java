import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final SelenideElement subscribeButton = $(By.xpath(
            ".//button[contains(@class, 'groups-join')]"));

    private final SelenideElement openLink = $(By.xpath(
            ".//div[contains(@class, 'similar-group-holder')]"));

    public void subscribe() {
        subscribeButton.click();
    }

    public void waitForPageToLoad() {
        openLink.shouldBe(visible);
    }

    public boolean isSubscribed() {
        return openLink.exists();
    }
}
