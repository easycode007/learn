package threads;

/**
 * Created by Razvan on 15.01.2017.
 */
public class Producator extends Thread {
    private Buffer buffer;

    public Producator(Buffer bf) {
        this.buffer = bf;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
            System.out.println("Producatorul a pus :\t" + i);
            try {
                sleep (( int )( Math . random () * 100) );
            } catch ( InterruptedException e) { }
        }
    }
}
