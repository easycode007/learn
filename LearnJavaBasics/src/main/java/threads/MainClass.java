package threads;

/**
 * Created by Razvan on 15.01.2017.
 */
public class MainClass {
    private static void callThreadsClasses() {
        new Thread(new HelloRunnable()).start();

        new HelloThread().start();
    }

    public static void doSomething() {
        AfisareNumere fir1 , fir2 ;
        fir1 = new AfisareNumere (0, 100 , 5);
        // Numara de la 0 la 100 cu pasul 5
        fir2 = new AfisareNumere (100 , 200 , 10);
        fir1.start();
        fir2.start();
    }

    public static void prodCons() {
        Buffer b = new Buffer ();
        Producator p1 = new Producator (b);
        Consumator c1 = new Consumator (b);
        p1.start ();
        c1.start ();
    }

    public static void main(String[] args) {
        prodCons();
    }
}
