package factories;

import abstractions.IGroupCard;
import com.codeborne.selenide.SelenideElement;
import elements.GroupCard;
import elements.LoggingGroupCard;

public class GroupCardFactory {
    public static IGroupCard createNewInstance(boolean enableLogging, SelenideElement element){
        return new GroupCard(enableLogging, element);
    }
}
