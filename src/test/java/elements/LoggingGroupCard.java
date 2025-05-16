package elements;

import abstractions.IGroupCard;

public class LoggingGroupCard implements IGroupCard {
    private final IGroupCard decorated;

    public LoggingGroupCard(IGroupCard decorated) {
        this.decorated = decorated;
    }

    @Override
    public IGroupCard subscribe() {
        System.out.println("Попытка подписаться на группу");
        decorated.subscribe();
        System.out.println("Подписка успешна");

        return this;
    }

    @Override
    public boolean isSubscribed() {
        System.out.println("Статус подписки: " + decorated.isSubscribed());
        return decorated.isSubscribed();
    }

    @Override
    public IGroupCard waitPageToUpdate() {
        decorated.waitPageToUpdate();

        return this;
    }
}
