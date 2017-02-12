package mylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Razvan on 07.02.2017.
 */
public class BookRepo {
    private HashMap<String, ArrayList<Book>> myBooks;

    public BookRepo() {
        myBooks = new HashMap<>();
    }

    public void add(Book book) {
        ArrayList<Book> currentBooks = myBooks.get(book.getType());
        if(currentBooks == null || currentBooks.isEmpty()) {
            currentBooks = new ArrayList<Book>();
            currentBooks.add(book);
        } else {
            currentBooks.add(book);
        }
        myBooks.put(book.getType(), currentBooks);
    }

    public Book get(String name) {
        for(String key: myBooks.keySet()) {
            for(Book book: myBooks.get(key)) {
                if(book.getName().equals(name)) {
                    return book;
                }
            }
        }
        return null;
    }

    public Book get(Book b) {
        return get(b.getName());
    }

    public boolean checkIfBookExists(Book b) {
        if(checkIfBookExists(b.getName())) {
            return true;
        }
        return false;
    }

    public boolean checkIfBookExists(String name) {
        if(get(name) == null) {
            return false;
        }
        return true;
    }

    public List<Book> getAllBooks(String type) {
        return myBooks.get(type);
    }

    public void printAllBooks(String type) {
        List<Book> books = getAllBooks(type);
        if(books == null || books.isEmpty()) {
            System.out.println("There are no books in DB!!!");
        } else {
            for(Book b: books) {
                System.out.println(b + ", ");
            }
        }
    }

    public void printBooks() {
        for(String key: myBooks.keySet()) {
            System.out.print(key + ": ");
            for(Book book: myBooks.get(key)) {
                System.out.print(book + ", ");
            }
            System.out.println("");
        }
    }

    public static BookRepo getDefaultBooks() {
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
