import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.xpath(
            ".//input[@id='field_email']"));
    private final SelenideElement passwordInput = $(By.xpath(
            ".//input[@id='field_password']"));

    public final SelenideElement errorMessage = $(By.xpath(
            ".//div[contains(@class, login_error)]"));

    public void login(String login, String password){
        loginInput.setValue(login);
        passwordInput.setValue(password).pressEnter();
    }
}
