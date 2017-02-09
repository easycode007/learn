package generics;

/**
 * Created by Razvan on 14.01.2017.
 */
public class GenericClass<T> implements GenericInterface<T> {
    private T t;
    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return t;
    }
}
