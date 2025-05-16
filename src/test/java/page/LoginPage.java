package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import utils.UserCredentials;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.xpath(
            "//*[@id=\"field_email\"]"));
    private final SelenideElement passwordInput = $(By.xpath(
            "//*[@id=\"field_password\"]"));

    public void Login(){
        loginInput
                .shouldBe(visible.because("Окно ввода логина отсутствует"))
                .setValue(UserCredentials.login);
        passwordInput
                .shouldBe(visible.because("Окно ввода пароля отсутствует"))
                .setValue(UserCredentials.password)
                .pressEnter();
    }
}
