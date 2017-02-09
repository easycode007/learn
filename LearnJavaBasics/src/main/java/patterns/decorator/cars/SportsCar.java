package patterns.decorator.cars;

/**
 * Created by Razvan on 26.01.2017.
 */
public class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println(" Adding features of Sports Car.");
    }
}
