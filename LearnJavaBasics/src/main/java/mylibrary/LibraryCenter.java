package mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 09.02.2017.
 */
public class LibraryCenter implements Center {
    private List<Client> clients;
    private BookRepo bookRepo;

    public LibraryCenter( BookRepo bookRepo) {
        clients = new ArrayList<>();
        this.bookRepo = bookRepo;
    }

    @Override
    public void register(Client client) {
        if(!clients.contains(client)) {
            clients.add(client);
            System.out.println("Registered successfully");
        } else {
            System.out.println("You are already register in our DB!!!");
        }
    }

    @Override
    public int getNumberOfClients() {
        return clients.size();
    }

    @Override
    public boolean searchFor(Client p) {
        return false;
    }
}
