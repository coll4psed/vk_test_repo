package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotoWrapper {
    private final SelenideElement root;
    private final By rateComponent = By.xpath(
            ".//*[contains(@aria-label, 'класс')]");

    public PhotoWrapper(SelenideElement rootElement) {
        this.root = rootElement;
    }

    public PhotoWrapper openImage() {
        Selenide.sleep(1000);
        root.click();

        return this;
    }

    public PhotoWrapper rateImage(){
        $(rateComponent)
                .shouldBe(visible.because("Кнопка \"класс\" не найдена"))
                .click();

        return this;
    }

    public void isRated(){
        root.$(rateComponent)
                .shouldHave(cssClass("__active")
                .because("Фотография не была оценена"));

    }
}
