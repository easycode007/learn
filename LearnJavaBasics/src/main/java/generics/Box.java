package generics;

import java.util.LinkedList;

/**
 * Created by Razvan on 14.01.2017.
 */
public class Box <T> {
    private LinkedList<T> t;
    private int contor;

    public Box() {
        contor = 0;
        t = new LinkedList<>();
    }

    public void add(T t) {
        this.t.add(t);
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
