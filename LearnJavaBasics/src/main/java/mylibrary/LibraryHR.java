package mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 09.02.2017.
 */
public class LibraryHR implements HR {
    private List<Client> clientsDB;

    public LibraryHR() {
        clientsDB = new ArrayList<>();
    }

    @Override
    public void register(Client client) {
        if(clientsDB.isEmpty()) {
            clientsDB.add(client);
            System.out.println("<" + client.getName() + "> with id <" + client.getId() +
                    "> registered successfully!!!");
        } else {
            if(checkIfUserExists(client)) {
                System.out.println("<" + client.getName() + "> with id <" + client.getId() +
                        "> you are already register in our DB!!!");
            } else {
                clientsDB.add(client);
                System.out.println("<" + client.getName() + "> with id <" + client.getId() +
                        "> registered successfully!!!");
            }
        }
    }

    public boolean checkIfUserExists(Client other) {
        for(Client client: clientsDB) {
            if(client.equals(other)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getNumberOfClients() {
        return clientsDB.size();
    }

    @Override
    public void printAllClients() {
        for(Client client: clientsDB) {
            System.out.println(client);
        }
    }

    @Override
    public boolean searchFor(Client p) {
        return checkIfUserExists(p);
    }
}
