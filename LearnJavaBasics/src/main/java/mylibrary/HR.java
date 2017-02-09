package mylibrary;

/**
 * Created by Razvan on 09.02.2017.
 */
public interface HR {
    public void register(Client p);
    public int getNumberOfClients();
    public void printAllClients();
    public boolean searchFor(Client p);
}
