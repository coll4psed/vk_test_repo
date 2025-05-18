package pages;

import abstractions.LoadablePage;
import elements.PhotoWrapper;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhotoPage implements LoadablePage {
    private final By photoCard = By.xpath(
            ".//*[contains(@class, photo-card_cnt)]");

    public PhotoPage(){
        checkPage();
    }

    public List<PhotoWrapper> getImages(){
        return $$(photoCard).stream()
                .map(PhotoWrapper::new)
                .collect(Collectors.toList());
    }

    public PhotoWrapper takeFirstImage(){
        return getImages().getFirst();
    }

    @Override
    public void checkPage() {
        $(photoCard)
                .shouldBe(visible.because("Карточка с фото не найдена"));
    }
}
