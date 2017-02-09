package patterns.command;

/**
 * Created by Razvan on 29.01.2017.
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Stock() {}

    public void buy() {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
