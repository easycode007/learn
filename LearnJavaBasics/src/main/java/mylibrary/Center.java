package mylibrary;

/**
 * Created by Razvan on 09.02.2017.
 */
public interface Center {
    public void register(Client p);
    public int getNumberOfClients();
    public boolean searchFor(Client p);
}
