package factories;

import abstractions.IGroupCard;
import com.codeborne.selenide.SelenideElement;
import elements.GroupCard;
import elements.LoggingGroupCard;

public class GroupCardFactory {
    public static IGroupCard create(SelenideElement elem){
        return new GroupCard(elem);
    }

    public static IGroupCard createWithLogging(SelenideElement elem){
        return new LoggingGroupCard(new GroupCard(elem));
    }
}
