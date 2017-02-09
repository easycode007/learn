package threads;

/**
 * Created by Razvan on 15.01.2017.
 */
public class Buffer {
    private int number;
    private boolean available;

    public synchronized void put(int nr) {
        while (available) {
            try {
                wait ();
                // Asteapta consumatorul sa preia valoarea
            } catch ( InterruptedException e) {
                e. printStackTrace ();
            }
        }
        this.number = nr;
        available = true;
        notifyAll();
    }

    public synchronized int get() {
        while (! available ) {
            try {
                wait ();
                // Asteapta producatorul sa puna o valoare
            } catch ( InterruptedException e) {
                e. printStackTrace ();
            }
        }
        available = false;
        notifyAll();
        return this.number;
    }
}
