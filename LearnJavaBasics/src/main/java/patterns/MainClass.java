package patterns;

import patterns.singleton.SingletonEnum;

/**
 * Created by Razvan on 23.12.2016.
 */
public class MainClass {

    public static void main(String[] args) {
        SingletonEnum s = SingletonEnum.INSTANCE;
        s.doSomething("S1");
        SingletonEnum s2 = SingletonEnum.INSTANCE;
        s2.doSomething("S2");
    }
}
