import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest {

    private static final String baseUrl = "https://ok.ru";

    @BeforeAll
    public static void loginOK(){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
    }

    @BeforeEach
    public void setUp(){
        Selenide.open(baseUrl);
    }

    @Test
    public void userCanAccessProfileUsingToolbar() {
        FeedPage feedPage = new FeedPage();
        ProfilePage profilePage = feedPage.openProfilePage();
        profilePage.waitForPageToLoad();
        assertTrue(profilePage.isProfilePageOpened());
    }

    // Предусловие, изначально должна быть светлая тема
    @Test
    public void userCanSwitchToDarkTheme(){
        FeedPage feedPage = new FeedPage();
        feedPage.SwitchToDarkTheme();
        assertTrue(feedPage.isDarkThemeEnabled());
    }

    @Test
    public void userCanSubscribeGroup(){
        FeedPage feedPage = new FeedPage();
        GroupPage groupPage = feedPage.openGroupPage();
        groupPage.subcribe();
        groupPage.waitForPageToLoad();
        assertTrue(groupPage.isSubscribed());
    }
}
