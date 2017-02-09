package patterns.factory;

/**
 * Created by Razvan on 23.12.2016.
 */
public class BookFactory {
    public static Book getBook(String category) {
        if(category.equals("PD")) {
            return new ThinkAndGrowRich();
        } else if (category.equals("LT")) {
            return new Huliganii();
        }
        return null;
    }
}
