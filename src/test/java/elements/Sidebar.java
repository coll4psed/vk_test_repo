package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class Sidebar {
    private final ElementsCollection navItems = $$(By.xpath(
            ".//*[contains(@class, 'nav-side')]/a"));

    public void clickNavItem(String itemText){
        String errorString = "Элемент с названием " + itemText + " не найден";
        SelenideElement itemToClick = navItems.findBy(text(itemText))
                .shouldBe(visible.because(errorString));
        itemToClick.click();
    }
}
