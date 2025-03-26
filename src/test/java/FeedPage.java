import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {
    private final SelenideElement toolbarButton = $(By.xpath(
            "//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/button"));
    private final SelenideElement userInfoToolbarLink = $(By.xpath(
            "//*[@id=\"user-dropdown-menu\"]/div[1]/div/div[1]/div[1]/a"));
    private final SelenideElement themeButton = $(By.xpath(
            "//*[@id=\"user-dropdown-menu\"]/div[1]/div/div[2]/ul/li[2]/button"));
    private final SelenideElement darkThemeButton = $(By.xpath(
            "//*[@id=\"user-dropdown-menu\"]/div[1]/div/div[2]/ul/li[2]/ul/li[2]/button"));
    private final SelenideElement mainContainer = $(By.xpath(
            "/html"));

    public ProfilePage openProfilePage(){
        toolbarButton.click();
        userInfoToolbarLink.click();
        return new ProfilePage();
    }

    public boolean isDarkThemeEnabled(){
        return mainContainer.has(Condition.cssClass("__ui-theme_dark"));
    }

    public void SwitchTheme(){
        toolbarButton.click();
        themeButton.click();
        darkThemeButton.click();
    }
}
