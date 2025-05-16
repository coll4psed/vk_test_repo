package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import page.LoginPage;

public class BaseTest {
    private static final String baseUrl = "https://ok.ru";

    @BeforeAll
    public static void loginOK(){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
        Selenide.sleep(3000);
    }

    @BeforeEach
    public void setUp(){
        Selenide.open(baseUrl);
    }
}
