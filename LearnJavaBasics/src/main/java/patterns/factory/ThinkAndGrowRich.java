package patterns.factory;

/**
 * Created by Razvan on 23.12.2016.
 */
public class ThinkAndGrowRich implements Book {
    public void printName() {
        System.out.println("ThinkAndGrowRich");
    }

    public void printAuthor() {
        System.out.println("Napoleon Hill");
    }
}
