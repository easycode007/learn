package patterns.singleton;

/**
 * Created by Razvan on 24.12.2016.
 */
public enum SingletonEnum {
    INSTANCE;

    private SingletonEnum() {
        System.out.println("Constructor");
    }

    public void doSomething(String message) {
        System.out.println(message + " say that I have to do something");
    }
}
