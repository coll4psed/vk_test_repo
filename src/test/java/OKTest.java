import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest {

    private static final String baseUrl = "https://ok.ru";

    @BeforeAll
    public static void loginOK(){
        Selenide.open(baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.login("technopol45", "technopolisPassword");
    }

    @BeforeEach
    public void setUp(){
        Selenide.open(baseUrl);
    }

    @DisplayName("User accessing his profile")
    @Test
    public void userCanAccessProfileUsingToolbar() {
        FeedPage feedPage = new FeedPage();
        ProfilePage profilePage = feedPage.openProfilePage();
        profilePage.waitForPageToLoad();
        assertTrue(profilePage.isProfilePageOpened());
    }

    // Предусловие, изначально должна быть светлая тема
    @DisplayName("User switching to dark theme")
    @Test
    public void userCanSwitchToDarkTheme(){
        FeedPage feedPage = new FeedPage();
        feedPage.switchToDarkTheme();
        assertTrue(feedPage.isDarkThemeEnabled());
    }

    @DisplayName("User subscribes to a group")
    @Test
    public void userCanSubscribeGroup(){
        FeedPage feedPage = new FeedPage();
        GroupPage groupPage = feedPage.openGroupPage();
        groupPage.subscribe();
        groupPage.waitForPageToLoad();
        assertTrue(groupPage.isSubscribed());
    }

    @Disabled
    @Test
    public void disabledTest(){
        assertTrue(true);
    }

    @AfterAll
    public static void logout(){
        FeedPage feedPage = new FeedPage();
        feedPage.logout();
    }
}
