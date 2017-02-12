package mylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Razvan on 13.02.2017.
 */
public class InterfaceApplication {
    private LibraryHR myHR;
    private BookRepo bookRepo;
    private Map<Client, List<Book>> statistics;

    public InterfaceApplication() {
        myHR = new LibraryHR();
        bookRepo = BookRepo.getDefaultBooks();
        statistics = new HashMap<>();
    }

    public void register(Client c) {
        myHR.register(c);
    }

    public void loan(Client c, String bookName) {
        if(!bookRepo.checkIfBookExists(bookName)) {
            System.out.println("We don't have this book");
        } else {
            List<Book> currentBooks = statistics.get(c);
            Book b = bookRepo.get(bookName);
            if(currentBooks == null || currentBooks.isEmpty()) {
                currentBooks = new ArrayList<Book>();
                currentBooks.add(b);
            } else {
                currentBooks.add(b);
            }
            statistics.put(c,currentBooks);
        }
    }

    public void displayAllBooksFor(Client c) {
        List<Book> books = statistics.get(c);
        if(books == null || books.isEmpty()) {
            System.out.println("No books for " + c);
        } else {
            System.out.println("--- For " + c + ": ");
            for(Book b: books) {
                System.out.println(b);
            }
        }
    }
}
