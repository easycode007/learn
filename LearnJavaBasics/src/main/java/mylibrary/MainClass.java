package mylibrary;

/**
 * Created by Razvan on 06.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        BookRepo bookRepo = createDB();
        LibraryHR hr = new LibraryHR(bookRepo);
        Client eu = new Client(1, "Razvan chiar el");
        Client eu2 = new Client(2, "Razvan chiar el");
        hr.register(eu);
        hr.register(eu2);
        hr.printAllClients();
    }

    private static BookRepo createDB() {
        BookRepo bookRepo = new BookRepo();
        Book book1 = new Literature("Amintiri din copilarie","Ion Creanga");
        Book book2 = new Magazine("Click", 1);
        Book book3 = new Literature("Steve Jobs", "Walter Isaacson");
        Book book4 = new Magazine("Mirror", 41);
        bookRepo.add(book1);
        bookRepo.add(book2);
        bookRepo.add(book3);
        bookRepo.add(book4);
        return bookRepo;
    }
}
