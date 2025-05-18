package tests;

import abstractions.IGroupCard;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKTest extends BaseTest {
    @DisplayName("User accessing his profile")
    @Tag("PositiveTest")
    @Test
    public void userCanAccessProfileUsingToolbar() {
        FeedPage feedPage = new FeedPage();
        ProfilePage profilePage = feedPage.getToolbar().openProfilePage();
        assertTrue(profilePage.isProfilePageOpened(),
                "Не удалось перейти в профиль пользователя");
    }

    // Предусловие, изначально должна быть светлая тема
    @DisplayName("User switching to dark theme")
    @Tag("PositiveTest")
    @Test
    public void userCanSwitchToDarkTheme() {
        FeedPage feedPage = new FeedPage();
        assertTrue(feedPage.getToolbar()
                        .switchToDarkTheme()
                        .isDarkThemeEnabled(),
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

    @DisplayName("User can subscribe from specific group page")
    @Tag("PositiveTest")
    @Test
    public void userCanSubscribeFromSpecificGroupPage() {
        SpecificGroupPage specificGroupPage = Navigation.openTamTamPage();
        assertTrue(specificGroupPage.subscribeSpecificGroup()
                .isSpecificGroupSubscribed("ТамТам",
                "Официальная группа о приложении ТамТам!"));
    }

    @DisplayName("User can like personal photo")
    @Tag("PositiveTest")
    @Test
    public void userCanLikePersonalPhoto(){
        FeedPage feedPage = new FeedPage();
        feedPage.getSidebar().clickNavItem("Фото");
        AlbumPage albumsPage = new AlbumPage();
        Selenide.sleep(1000);
        albumsPage.takeFirstAlbum()
                  .openAlbum();
        PhotoPage photoPage = new PhotoPage();
        photoPage.takeFirstImage()
                        .rateImage()
                        .isRated();
    }
}
