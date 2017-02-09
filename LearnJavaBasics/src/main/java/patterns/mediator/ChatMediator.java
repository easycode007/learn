package patterns.mediator;

/**
 * Created by Razvan on 24.01.2017.
 */
public interface ChatMediator {
    public void sendMessage(String msg, User user);

    void addUser(User user);
}
