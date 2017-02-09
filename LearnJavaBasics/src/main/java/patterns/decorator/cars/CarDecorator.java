package patterns.decorator.cars;

/**
 * Created by Razvan on 26.01.2017.
 */
public class CarDecorator implements Car {
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
