package mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 09.02.2017.
 */
public class LibraryCenter implements Center {
    private List<Client> clients;
    private Librarian librarian;
    private BookRepo bookRepo;

    public LibraryCenter(Librarian librarian, BookRepo bookRepo) {
        clients = new ArrayList<>();
        this.bookRepo = bookRepo;
    }

    @Override
    public void register(Client client) {
        clients.add(client);
    }

    @Override
    public int getNumberOfClients() {
        return clients.size();
    }

    @Override
    public boolean searchFor(Client p) {
        if(clients.contains(p)) {
            return true;
        }
        return false;
    }
}
