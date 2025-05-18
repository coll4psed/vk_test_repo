package tests;

import com.codeborne.selenide.Selenide;
import pages.GroupPage;
import pages.SpecificGroupPage;

public class Navigation {
    public static GroupPage openGroupPage(){
        Selenide.open("https://ok.ru/groups");
        return new GroupPage();
    }

    public static SpecificGroupPage openTamTamPage(){
        Selenide.open("https://ok.ru/tamtam.official");
        return new SpecificGroupPage();
    }
}
