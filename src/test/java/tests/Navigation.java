package tests;

import com.codeborne.selenide.Selenide;
import pages.GroupPage;
import pages.SpecificGroupPage;

public class Navigation {
    public static GroupPage openGroupPage(){
        Selenide.open("https://ok.ru/groups");
        return new GroupPage();
    }

    // По большей части это костыль, т.к. по неизвестной мне причиние
    // Поиск по названиию группы у меня не работает
    public static SpecificGroupPage openTamTamPage(){
        Selenide.open("https://ok.ru/tamtam.official");
        return new SpecificGroupPage();
    }
}
