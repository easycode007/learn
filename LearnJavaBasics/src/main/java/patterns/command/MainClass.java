package patterns.command;

/**
 * Created by Razvan on 29.01.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        Stock abcStock = new Stock("My Stock", 10);

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
