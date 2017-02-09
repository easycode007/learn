package mylibrary;

/**
 * Created by Razvan on 09.02.2017.
 */
public class Librarian implements Person {
    private String name;
    private String address;
    private String numericID;

    public Librarian(String name, String address, String numericId) {
        this.name = name;
        this.address = address;
        this.numericID = numericId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getNumericId() {
        return numericID;
    }
}
