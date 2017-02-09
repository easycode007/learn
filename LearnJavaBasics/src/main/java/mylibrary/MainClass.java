package mylibrary;

/**
 * Created by Razvan on 06.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        BookRepo bookRepo = createDB();
        LibraryCenter myLibrary = new LibraryCenter(bookRepo);
        Client eu = new Client(1, "Razvan chiar el");
        Client eu2 = new Client(2, "Razvan chiar el");
        myLibrary.register(eu);
        myLibrary.register(eu2);
        myLibrary.printAllClients();
//        eu.printName();
    }

    private static BookRepo createDB() {
        BookRepo bookRepo = new BookRepo();
        Book book1 = new Literature("Amintiri din copilarie","Ion Creanga");
        Book book2 = new Magazine("Click", 1);
        Book book3 = new Literature("Steve Jobs", "Walter Isaacson");
        Book book4 = new Magazine("Mirror", 41);
        bookRepo.addBook(book1);
        bookRepo.addBook(book2);
        bookRepo.addBook(book3);
        bookRepo.addBook(book4);
        return bookRepo;
    }
}
