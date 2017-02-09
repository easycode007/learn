package mylibrary;

/**
 * Created by Razvan on 07.02.2017.
 */
public class Literature implements Book {
    private String name;
    private String author;
    private static final String TYPE = "Literature";

    public Literature(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return name + ", " + author;
    }
}
