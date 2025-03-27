import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.xpath(
            "//*[@id=\"field_email\"]"));
    private final SelenideElement passwordInput = $(By.xpath(
            "//*[@id=\"field_password\"]"));

    public void Login(){
        loginInput.setValue(UserCredentials.login);
        passwordInput.setValue(UserCredentials.password).pressEnter();
    }
}
