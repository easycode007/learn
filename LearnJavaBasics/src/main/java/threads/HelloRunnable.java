package threads;

/**
 * Created by Razvan on 15.01.2017.
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Run Hello Runnable");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("HelloRunnable: " + i + " ");
//        }
    }
}
