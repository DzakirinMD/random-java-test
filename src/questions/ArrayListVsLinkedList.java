package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Both ArrayList and LinkedList are implementation of List interface in Java. Both classes are non-synchronized.
 * ArrayList internally uses a dynamic array to store the elements. LinkedList internally uses a doubly linked list to store the elements.
 * ArrayList is faster in storing and accessing data.  LinkedList is faster in manipulation of data.
 * ArrayList use less memory footprint as the element grow.  LinkedList use more memory footprint as the element grow.
 *
 * To be precise, an ArrayList is a resizable array.
 * LinkedList implements the doubly linked list of the list interface.
 *
 * Mainly people use ArrayList instead of LinkedList due to performance.
 */

public class ArrayListVsLinkedList {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        System.out.println(arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println(linkedList);
    }
}
