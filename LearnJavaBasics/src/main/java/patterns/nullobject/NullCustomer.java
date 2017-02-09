package patterns.nullobject;

/**
 * Created by Razvan on 29.01.2017.
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNill() {
        return true;
    }

    @Override
    public String getName() {
        return "Null Customer";
    }
}
