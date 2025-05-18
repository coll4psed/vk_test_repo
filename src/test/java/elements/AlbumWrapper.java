package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class AlbumWrapper {
    private final SelenideElement root;

    public AlbumWrapper(SelenideElement rootElement){
        this.root = rootElement;
    }

    public void openAlbum(){
        root.shouldBe(visible.because("Альбом не найден"))
                .click();
    }
}
