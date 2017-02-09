package mylibrary;

/**
 * Created by Razvan on 07.02.2017.
 */
public class Magazine implements Book {
    private String name;
    private int nr;
    private static final String TYPE = "Magazine";

    public Magazine(String name, int nr) {
        this.name = name;
        this.nr = nr;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return name + ", #" + nr;
    }
}
