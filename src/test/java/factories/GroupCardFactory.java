package factories;

import abstractions.IGroupCard;
import com.codeborne.selenide.SelenideElement;
import elements.GroupCard;
import elements.LoggingGroupCard;

public class GroupCardFactory {
    public static IGroupCard createNewInstance(SelenideElement element, boolean enableLogging){
        IGroupCard card = new GroupCard(element);
        return enableLogging ? new LoggingGroupCard(card) : card;
    }
}
