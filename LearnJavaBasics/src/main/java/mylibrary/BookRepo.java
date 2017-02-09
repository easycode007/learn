package mylibrary;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Razvan on 07.02.2017.
 */
public class BookRepo {
    private HashMap<String, ArrayList<Book>> myBooks;
    private static BookRepo instance;

    public BookRepo() {
        myBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        ArrayList<Book> currentBooks = myBooks.get(book.getType());
        if(currentBooks == null || currentBooks.isEmpty()) {
            currentBooks = new ArrayList<Book>();
            currentBooks.add(book);
        } else {
            currentBooks.add(book);
        }
        myBooks.put(book.getType(), currentBooks);
    }

    public boolean searchForBook(String name) {
        return false;
    }

    public Book getBook(String name) {
        return null;
    }

    public void printBooks() {
        for(String key: myBooks.keySet()) {
            System.out.print(key + ": ");
            for(Book book: myBooks.get(key)) {
                System.out.print(book);
            }
            System.out.println("");
        }
    }
}
