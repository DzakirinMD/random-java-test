package questions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * HashmapVsHashset
 <pre>
 | HashMap                                      |    HashSet Statement                                        |
 |------------------------------------------------|--------------------------------------------------------------|
 | there must not be duplicate keys, but it may have duplicate values. | there must be no duplicate elements |
 | implementation of map (MAP interface)        | implementation of set (Set interface) |
 | use put() to insert value             | use add() to input value                          |
 | used when SQL query is to be executed only once | used when SQL query is to be executed multiple times.        |
 </pre>
 *
 */
public class HashmapVsHashset {
    public static void main(String[] args) {

        // This is how to declare HashMap
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        // Adding elements to HashMap*/
        hm.put(12, "geeks");
        hm.put(2, "practice");
        hm.put(7, "contribute");
        System.out.println("HashMap object output: " + hm);

        HashSet<String> hs = new HashSet<String>();
        // Adding elements to the HashSet
        hs.add("set1");
        hs.add("practice");
        hs.add("testing");
        System.out.println("HashSet object output: " + hs);
    }
}
