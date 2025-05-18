package pages;

import abstractions.LoadablePage;
import com.codeborne.selenide.CollectionCondition;
import elements.AlbumWrapper;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class AlbumPage implements LoadablePage {
    private final By albumComponent = By.xpath(
            ".//*[contains(@class, 'photo-album-card')]/a");

    public AlbumPage(){
        checkPage();
    }

    public List<AlbumWrapper> getAlbums(){
        return $$(albumComponent).stream()
                .map(AlbumWrapper::new)
                .collect(Collectors.toList());
    }

    public AlbumWrapper takeFirstAlbum(){
        return getAlbums().getFirst();
    }

    @Override
    public void checkPage() {
        $$(albumComponent)
                .shouldBe(CollectionCondition
                        .sizeGreaterThan(0)
                        .because("Компонент с альбомами не найден"));
    }
}
