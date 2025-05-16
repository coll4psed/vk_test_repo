package test;

import org.junit.jupiter.api.Test;

import page.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest extends BaseTest {
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
        GroupPage groupPage = Navigation.navigateToGroupPage();
        groupPage.subscribe();
        groupPage.waitForPageToLoad();
        assertTrue(groupPage.isSubscribed());
    }
}
