package pages;

import abstractions.LoadablePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends LoadablePage {
    private final SelenideElement profileBlock = $(By.xpath(
            ".//*[contains(@class, 'profile-cover')]"));

    public ProfilePage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        profileBlock
                .shouldBe(visible.because("Блок профиля отсутствует на странице"));
    }

    public boolean isProfilePageOpened(){
        return profileBlock.isDisplayed();
    }
}
