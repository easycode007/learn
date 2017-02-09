package patterns.decorator;

import patterns.decorator.cars.BasicCar;
import patterns.decorator.cars.Car;
import patterns.decorator.cars.LuxuryCar;
import patterns.decorator.cars.SportsCar;
import patterns.decorator.food.ChineeseFood;
import patterns.decorator.food.Food;
import patterns.decorator.food.NonVegFood;
import patterns.decorator.food.VegFood;
import patterns.decorator.window.ScrollableWindow;
import patterns.decorator.window.SimpleWindow;
import patterns.decorator.window.Window;

/**
 * Created by Razvan on 26.01.2017.
 */
public class MainClass {
    public static void foodSample() {
        VegFood vf = new VegFood();
        System.out.println(vf.prepareFood());
        System.out.println( vf.foodPrice());

        Food f1=new NonVegFood(vf);
        System.out.println(f1.prepareFood());
        System.out.println( f1.foodPrice());
//
//        Food f2=new ChineeseFood(new VegFood());
//        System.out.println(f2.prepareFood());
//        System.out.println( f2.foodPrice());

    }

    public static void window() {
        //create a new window

        Window window = new SimpleWindow();

        window.renderWindow();

        // at some point later
        // maybe text size becomes larger than the window
        // thus the scrolling behavior must be added

        // decorate old window
        window = new ScrollableWindow(window);

        //  now window object
        // has additional behavior / state

        window.renderWindow();
    }

    public static void cars() {
//        BasicCar rabla = new BasicCar();
//        rabla.assemble();
//
//        Car lamburghini = new SportsCar(rabla);
//        lamburghini.assemble();
//        System.out.println("\n*****");
////
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

    public static void main(String[] args) {
        cars();
    }
}
