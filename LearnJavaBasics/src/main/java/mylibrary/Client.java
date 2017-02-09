package mylibrary;

/**
 * Created by Razvan on 09.02.2017.
 */
public class Client implements Person {
    private String name;

    public Client(String name) {
        this.name = name;
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
        return null;
    }

    @Override
    public String getNumericId() {
        return null;
    }
}
