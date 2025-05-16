package pages;

import abstractions.IGroupCard;
import abstractions.LoadablePage;
import factories.GroupCardFactory;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class GroupPage extends LoadablePage {
    private final By groupCardElement = By
            .xpath(".//*[contains(@data-l, 'groupId')]");

    public GroupPage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $$(groupCardElement)
                .first()
                .shouldBe(visible.because("Кнопка подписаться отсутствует на странице"));
    }

    public List<IGroupCard> getGroups(boolean enableLogging){
        return $$(groupCardElement).stream()
                .map(el -> GroupCardFactory.createNewInstance(el, enableLogging))
                .collect(Collectors.toList());
    }

    public IGroupCard takeFirstGroup(boolean enableLogging){
        return getGroups(enableLogging).getFirst();
    }
}
