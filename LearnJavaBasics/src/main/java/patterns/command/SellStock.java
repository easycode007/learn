package patterns.command;

/**
 * Created by Razvan on 29.01.2017.
 */
public class SellStock implements Order {
    private Stock sellStock;

    public SellStock(Stock stock) {
        this.sellStock = stock;
    }

    @Override
    public void execute() {
        sellStock.sell();
    }
}
