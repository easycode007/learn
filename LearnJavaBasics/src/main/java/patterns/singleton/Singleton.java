package patterns.singleton;

/**
 * Created by Razvan on 23.12.2016.
 */
public class Singleton {
    private static Singleton thisObject;

    private Singleton() {
        System.out.println("[Constructor] A()");
    }

    public static synchronized Singleton getObject() {
        if (thisObject == null) {
            System.out.println("[Creating] A()");
            return thisObject = new Singleton();
        }
        System.out.println("[Return] A()");
        return thisObject;
    }

    public void doSomething() {
        System.out.println("doSomething()");
    }
}
