package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseTest {
    private static final String baseUrl = "https://ok.ru";

    private static final SelenideElement toolbarButton = $(By.xpath(
            ".//*[contains(@class, 'toolbar_ucard')]"));
    private static final SelenideElement logoutButton = $(By.xpath(
            ".//*[contains(@data-l, 'logout')]"));
    private static final SelenideElement additionalLogoutButton = $(By.xpath(
            ".//*[contains(@data-l, 'logout') and @type='submit']"));

    @BeforeAll
    public static void loginOK(){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.login(AuthorizationInfo.USERNAME, AuthorizationInfo.PASSWORD);
    }

    @BeforeEach
    public void setUp(){
        Selenide.open(baseUrl);
    }

    @AfterAll
    public static void logout(){
        toolbarButton
                .shouldBe(visible.because("Кнопка тулбара не найдена на странице"))
                .click();
        logoutButton
                .shouldBe(visible.because("Кнопка \"Выйти\" не найдена"))
                .click();
        sleep(1500);
        if (additionalLogoutButton.isDisplayed()){
            additionalLogoutButton.click();
        }
    }
}
