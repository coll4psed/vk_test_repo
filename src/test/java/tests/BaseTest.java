package tests;

import com.codeborne.selenide.Selenide;
import elements.Toolbar;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import test.AuthorizationInfo;

public class BaseTest {
    private static final String baseUrl = "https://ok.ru";

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
        Toolbar toolbar = new Toolbar();
        toolbar.logout();
    }
}
