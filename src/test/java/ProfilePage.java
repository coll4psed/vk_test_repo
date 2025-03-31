import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement profileBlock = $(By.xpath(
            ".//div[contains(@class, 'profile-cover')]"));

    public void waitForPageToLoad(){
        profileBlock.shouldBe(visible);
    }

    public boolean isProfilePageOpened(){
        return profileBlock.exists();
    }
}
