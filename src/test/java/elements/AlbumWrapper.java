package elements;

import com.codeborne.selenide.SelenideElement;

public class AlbumWrapper {
    private final SelenideElement root;

    public AlbumWrapper(SelenideElement rootElement){
        this.root = rootElement;
    }

    public void openAlbum(){
        root.click();
    }
}
