package tests;

import abstractions.IGroupCard;
import org.junit.jupiter.api.*;
import pages.FeedPage;
import pages.GroupPage;
import pages.ProfilePage;
import pages.ExistingGroupPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest extends BaseTest {
    @DisplayName("User accessing his profile")
    @Tag("PositiveTest")
    @Test
    public void userCanAccessProfileUsingToolbar() {
        FeedPage feedPage = new FeedPage();
        ProfilePage profilePage = feedPage.openProfilePage();
        assertTrue(profilePage.isProfilePageOpened(),
                "Не удалось перейти в профиль пользователя");
    }

    // Предусловие, изначально должна быть светлая тема
    @DisplayName("User switching to dark theme")
    @Tag("PositiveTest")
    @Test
    public void userCanSwitchToDarkTheme() {
        FeedPage feedPage = new FeedPage();
        feedPage.switchToDarkTheme();
        assertTrue(feedPage.isDarkThemeEnabled(),
                "Тема не тёмная, или не удалось её сменить");
    }

    @DisplayName("User subscribes to a group")
    @Tag("PositiveTest")
    @Test
    public void userCanSubscribeGroup() {
        GroupPage groupPage = Navigation.openGroupPage();

        IGroupCard groupCard = groupPage.takeFirstGroup(true);
        assertTrue(groupCard
                        .subscribe()
                        .waitPageToUpdate()
                        .isSubscribed(),
                "Не удалось подписаться на группу");
    }

    @Disabled("Необходимо исправить проверку подписки")
    @DisplayName("User can subscribe from specific group page")
    @Tag("PositiveTest")
    @Test
    public void userCanSubscribeFromSpecificGroupPage() {
        ExistingGroupPage existingGroupPage = Navigation.openTamTamPage();
        if (existingGroupPage.isTamTamPage()) {
            existingGroupPage.subscribe();
            assertTrue(existingGroupPage.isSubscribed());
        }
    }
}
