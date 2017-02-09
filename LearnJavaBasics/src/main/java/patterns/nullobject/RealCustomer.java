package patterns.nullobject;

/**
 * Created by Razvan on 29.01.2017.
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNill() {
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
