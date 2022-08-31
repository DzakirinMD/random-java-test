package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * A Java Collection is a predefined architecture capable of storing a group of elements
 * and behaving like a single unit such as an object or a group.
 * It is a Collections FrameWork - provides various interfaces(methods).
 * These interfaces include several methods to perform different operations on collections.
 * The Collection framework provides various data structures and algorithms that can be used directly.
 * The Collection interface (java.util.Collection) and Map interface (java.util.Map) are the two main “root” interfaces of Java collection classes.
 * All collection methods can be check here: <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html">Collections Framework</a>
 */

public class JavaCollectionsFramework {

    public static void main(String[] args) {

        hashMapTest();
        System.out.println("\n");
        arrayListTest();
    }

    /**
     * A Collection HashMap store items in "key/value" pairs.
     */
    public static void hashMapTest(){

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(1, "Malaysia");
        hashMap.put(2, "Thailand");
        hashMap.put(3, "Singapore");

        // Finding the value for a key
        System.out.println("Value for 1 is " + hashMap.get(1));

        // Traversing through the HashMap using java 8 lambda
        hashMap.forEach((key, value) -> System.out.println("Key => " + key + " Value => " + value));
//        for (Map.Entry<Integer, String> e : hashMap.entrySet())
//            System.out.println(e.getKey() + " " + e.getValue());

        hashMap.clear();
        System.out.println("HashMap => " + hashMap + " isEmpty ? => " +hashMap.isEmpty());
    }

    /**
     * Arrays store items as an ordered collection
     * The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one).
     */
    public static void arrayListTest() {

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Xena");
        cars.add("Mazda");

        Collections.sort(cars);
        System.out.println("ArrayList => " + cars);
    }
}
