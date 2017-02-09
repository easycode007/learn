package mylibrary;

/**
 * Created by Razvan on 06.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        loadDB();
        Client eu = new Client("Razvan chiar el");
        eu.printName();
    }

    private static void loadDB() {
        Book book1 = new Literature("Amintiri din copilarie","Ion Creanga");
        Book book2 = new Magazine("Click", 1);
        BookRepo.getRepo().addBook(book1);
        BookRepo.getRepo().addBook(book2);
        BookRepo.getRepo().printBooks();
    }
}
