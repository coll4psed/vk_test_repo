package test;

import org.junit.jupiter.api.*;
import page.FeedPage;
import page.GroupPage;
import page.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest extends BaseTest {
    @DisplayName("User accessing his profile")
    @Tag("PositiveTest")
    @Test
    public void userCanAccessProfileUsingToolbar() {
        FeedPage feedPage = new FeedPage();
        ProfilePage profilePage = feedPage.openProfilePage();
        profilePage.waitForPageToLoad();
        assertTrue(profilePage.isProfilePageOpened());
    }

    // Предусловие, изначально должна быть светлая тема
    @DisplayName("User switching to dark theme")
    @Tag("PositiveTest")
    @Test
    public void userCanSwitchToDarkTheme(){
        FeedPage feedPage = new FeedPage();
        feedPage.switchToDarkTheme();
        assertTrue(feedPage.isDarkThemeEnabled());
    }

    @Timeout(5)
    @DisplayName("User subscribes to a group")
    @Tag("PositiveTest")
    @Test
    public void userCanSubscribeGroup(){
        GroupPage groupPage = Navigation.openGroupPage();
        groupPage.subscribe();
        groupPage.waitForPageToLoad();
        assertTrue(groupPage.isSubscribed());
    }
}
