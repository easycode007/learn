package patterns.decorator.cars;

/**
 * Created by Razvan on 26.01.2017.
 */
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}
