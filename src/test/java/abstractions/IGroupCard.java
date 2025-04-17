package abstractions;

public interface IGroupCard {
    IGroupCard subscribe();
    boolean isSubscribed();
    IGroupCard waitPageToUpdate();
}
