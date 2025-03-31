import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {
    private final SelenideElement toolbarButton = $(By.xpath(
            ".//button[contains(@class, 'toolbar_ucard')]"));
    private final SelenideElement userInfoToolbarLink = $(By.xpath(
            ".//div[contains(@class, 'user_name')]"));
    private final SelenideElement themeButton = $(By.xpath(
            ".//button[contains(@class, 'theme-switcher')]"));
    private final SelenideElement darkThemeButton = $(By.xpath(
            ".//li[@data-theme='dark']"));
    private final SelenideElement mainContainer = $(By.xpath(
            "/html"));

    public ProfilePage openProfilePage(){
        toolbarButton.click();
        userInfoToolbarLink.click();
        return new ProfilePage();
    }

    public GroupPage openGroupPage(){
        Selenide.open("https://ok.ru/groups");
        return new GroupPage();
    }

    public boolean isDarkThemeEnabled(){
        return mainContainer.has(Condition.cssClass("__ui-theme_dark"));
    }

    public void SwitchToDarkTheme(){
        toolbarButton.click();
        themeButton.click();
        darkThemeButton.click();
    }
}
