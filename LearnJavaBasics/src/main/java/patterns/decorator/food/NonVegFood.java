package patterns.decorator.food;

/**
 * Created by Razvan on 26.01.2017.
 */
public class NonVegFood extends FoodDecorator {
    public NonVegFood(Food newFood) {
        super(newFood);
    }

    public String prepareFood(){
        return super.prepareFood() +" With Roasted Chiken and Chiken Curry  ";
    }

    public double foodPrice()   {
        return super.foodPrice()+150.0;
    }

}
