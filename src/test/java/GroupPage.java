import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final SelenideElement subcribeButton = $(By.xpath(
            "//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]" +
                    "/div[1]/div[1]/div[1]/div[2]/div[3]/groups-join-component/button"));

    private final SelenideElement openLink = $(By.xpath(
            "//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]" +
                    "/div[1]/div[1]/div[1]/div[2]/div[3]/groups-join-component/div/a/span/span[1]"));

    public void subcribe(){
        subcribeButton.click();
    }

    public void waitForPageToLoad(){
        openLink.shouldBe(visible);
    }

    public boolean isSubscribed(){
        return openLink.has(text("Перейти"));
    }
}
