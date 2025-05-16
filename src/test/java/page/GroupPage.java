package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final SelenideElement subscribeButton = $(By.xpath(
            "//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]" +
                    "/div[1]/div[1]/div[1]/div[2]/div[3]/groups-join-component/button"));

    private final SelenideElement openLink = $(By.xpath(
            "//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]" +
                    "/div[1]/div[1]/div[1]/div[2]/div[3]/groups-join-component/div/a/span/span[1]"));

    public void subscribe(){
        subscribeButton
                .shouldBe(visible.because("Кнопка подписаться отсутствует на странице"))
                .click();
    }

    public void waitForPageToLoad(){
        openLink
                .shouldBe(visible.because("Кнопка открыть отсутствует на странице"));
    }

    public boolean isSubscribed(){
        return openLink
                .isDisplayed();
    }
}
