package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.LoginPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTest {

    private static final String baseUrl = "https://ok.ru";

    @Disabled("Пока нерабочий")
    @Tag("NegativeTest")
    @ParameterizedTest
    @MethodSource("invalidLoginData")
    public void loginWithInvalidCredentials(String login, String password){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        assertTrue(loginPage.isErrorMessageOnPage());
    }

    static Stream<Arguments> invalidLoginData(){
        return Stream.of(
                Arguments.of("technopool44", "technopolisPassword"),
                Arguments.of("technopol45", "technopolisInvalidPassword")
        );
    }
}