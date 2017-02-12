package mylibrary;

/**
 * Created by Razvan on 06.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        InterfaceApplication myApp = new InterfaceApplication();
        Client c1 = new Client(1, "Razvan chiar el");
        Client c2 = new Client(2, "Razvan chiar el");
        myApp.register(c1);
        myApp.loan(c1,"Click");
        myApp.loan(c1, "Steve Jobs");
        myApp.displayAllBooksFor(c1);
        myApp.register(c2);
        myApp.loan(c2, "Mirror");
        myApp.displayAllBooksFor(c2);
    }
}
