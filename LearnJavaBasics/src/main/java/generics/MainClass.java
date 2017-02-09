package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 14.01.2017.
 */
public class MainClass {
    private static void myOwnGenericMethod() {
        Box<Integer> bInteger = new Box<>();
        bInteger.add(1);
        bInteger.add(2);
        System.out.println(bInteger);

        Box<String> bString = new Box<>();
        bString.add("1 oaie");
        bString.add("2 oi");
        System.out.println(bString);
    }

    public static void main(String[] args) {
        GenericClass<String> gc = new GenericClass<>();
        gc.set("something");
        System.out.println(gc.get());
        GenericClass<Integer> gcI = new GenericClass<>();
        gcI.set(12223);
        System.out.println(gcI.get());
    }

    public  static  <E> boolean something(E ee) {
        return true;
    }

    public <E> void dd(E ea) {

    }

    public static < E > void printArray( E[] inputArray ) {
        // Main Method

        //        Integer[] intArray = { 1, 2, 3, 4, 5 };
//        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
//
//        System.out.println("Array integerArray contains:");
//        printArray(intArray);   // pass an Integer array
//
//        System.out.println("\nArray doubleArray contains:");
//        printArray(doubleArray);   // pass a Double array
//
//        System.out.println("\nArray characterArray contains:");
//        printArray(charArray);   // pass a Character array

        // -----------

        // Display array elements
//        for(E element : inputArray) {
//            System.out.printf("%s ", element);
//        }
//        System.out.println();
        List<Object> ls = new ArrayList<>(); //
        ArrayList<String> list = new ArrayList<>();
    }
}
