package patterns.decorator.food;

/**
 * Created by Razvan on 26.01.2017.
 */
public class VegFood implements Food {
    @Override
    public String prepareFood() {
        return "Veg Food";
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}
