package patterns.proxy;

/**
 * Created by Razvan on 29.01.2017.
 */
class MainClass {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}
