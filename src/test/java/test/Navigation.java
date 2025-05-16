package test;

import com.codeborne.selenide.Selenide;
import page.GroupPage;

public class Navigation {
    public static GroupPage navigateToGroupPage(){
        Selenide.open("https://ok.ru/groups");
        return new GroupPage();
    }
}
