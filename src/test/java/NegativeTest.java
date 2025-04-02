import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.empty;

public class NegativeTest {

    private static final String baseUrl = "https://ok.ru";

    @Disabled("Пока не рабочий")
    @ParameterizedTest
    @MethodSource("invalidLoginData")
    public void loginWithInvalidCredentials(String login, String password){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        loginPage.errorMessage.shouldNotHave(empty);
    }

    static Stream<Arguments> invalidLoginData(){
        return Stream.of(
                Arguments.of("technopool44", "technopolisPassword"),
                Arguments.of("technopol45", "technopolisInvalidPassword"),
                Arguments.of("technopol46", "technopolisInvalidPassword")
        );
    }
}