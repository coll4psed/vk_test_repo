package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.xpath(
            ".//*[@id='field_email']"));
    private final SelenideElement passwordInput = $(By.xpath(
            ".//*[@id='field_password']"));
    private final SelenideElement errorMessage = $(By.xpath(
            ".//*[contains(@class, form_i__error)]/" +
                    "*[contains(@class, login_error)]"));

    public void login(String login, String password){
        loginInput
                .shouldBe(visible.because("Окно ввода логина отсутствует"))
                .setValue(login);
        passwordInput
                .shouldBe(visible.because("Окно ввода пароля отсутствует"))
                .setValue(password)
                .pressEnter();
    }

    public boolean isErrorMessageOnPage(){
        return errorMessage.exists() && !errorMessage.getText().isEmpty();
    }
}
