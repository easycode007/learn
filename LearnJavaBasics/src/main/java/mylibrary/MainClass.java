package mylibrary;

/**
 * Created by Razvan on 06.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        LibraryHR hr = new LibraryHR();
        Client eu = new Client(1, "Razvan chiar el");
        Client eu2 = new Client(2, "Razvan chiar el");
        hr.register(eu);
        hr.register(eu2);
        hr.printAllClients();
    }
}
