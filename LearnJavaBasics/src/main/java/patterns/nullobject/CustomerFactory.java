package patterns.nullobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 29.01.2017.
 */
public class CustomerFactory {
    private List<AbstractCustomer> customers;

    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name){

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }

}
