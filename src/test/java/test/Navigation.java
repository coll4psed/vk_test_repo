package test;

import com.codeborne.selenide.Selenide;
import page.GroupPage;

public class Navigation {
    public static GroupPage openGroupPage(){
        Selenide.open("https://ok.ru/groups");
        return new GroupPage();
    }
}
