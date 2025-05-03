package pages;

import abstractions.IGroupCard;
import abstractions.LoadablePage;
import com.codeborne.selenide.SelenideElement;
import factories.GroupCardFactory;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class GroupPage extends LoadablePage {
    private final By groupCardElement = By
            .xpath(".//*[contains(@data-l, 'groupId')]");

    @Override
    public void checkPage() {
        $$(groupCardElement)
                .first()
                .shouldBe(visible.because("Кнопка подписаться отсутствует на странице"));
    }

    public List<IGroupCard> getGroups(Function<SelenideElement, IGroupCard> factory){
        return $$(groupCardElement).stream()
                .map(factory)
                .collect(Collectors.toList());
    }

    public IGroupCard takeFirstGroup(){
        return getGroups(GroupCardFactory.createNewInstance(true)).getFirst();
    }
}
