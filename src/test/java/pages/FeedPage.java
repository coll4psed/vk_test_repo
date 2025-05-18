package pages;

import abstractions.PageWithCommonComponents;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeedPage extends PageWithCommonComponents {
    private final SelenideElement feedBlock = $(By.xpath(
            ".//*[contains(@class, 'feed-list')]"));

    public FeedPage(){
        checkPage();
    }

    @Override
    public void checkPage() {
        feedBlock
                .shouldBe(visible.because("Страница не загрузилась. Список новостей не найден"));
    }
}
