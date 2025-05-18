package tests;

import com.codeborne.selenide.Selenide;
import elements.Toolbar;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
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
    public static void backToBaseState(){
        Selenide.open(baseUrl);
        unlikePhoto();
        switchThemeBack();
        unSubscribeFromSpecificGroup();
    }

    private static void unlikePhoto(){
        FeedPage feedPage = new FeedPage();
        feedPage.getSidebar().clickNavItem("Фото");
        AlbumPage albumsPage = new AlbumPage();
        Selenide.sleep(1000);
        albumsPage.takeFirstAlbum()
                .openAlbum();
        PhotoPage photoPage = new PhotoPage();
        photoPage.takeFirstImage()
                .rateImage();
    }

    private static void switchThemeBack(){
        Toolbar toolbar = new Toolbar();
        toolbar.switchToLightTheme();
    }

    private static void unSubscribeFromSpecificGroup(){
        SpecificGroupPage specificGroupPage = Navigation.openTamTamPage();
        specificGroupPage.unSubscribeSpecificGroup();
    }
}
