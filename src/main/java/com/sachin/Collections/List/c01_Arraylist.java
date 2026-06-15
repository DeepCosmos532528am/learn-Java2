package com.sachin.Collections.List;

import java.util.ArrayList;

import java.util.Collections;

public class c01_Arraylist {
    static void main(String[] args) {

        // Creating ArrayList (default capacity = 10)
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<String>  fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Guava");
        fruits.add("Banana");
        fruits.add("Papaya");


        // ------------------- ADDING ELEMENTS -------------------
        list1.add(2);              // adds element at end
        list1.add(3);
        list1.add(1, 10);          // insert at index 1 → shifts elements

        // ------------------- ACCESSING ELEMENTS -------------------
        int val = list1.get(0);    // get element at index

        // ------------------- UPDATING ELEMENT -------------------
        list1.set(0, 100);         // replaces element at index 0

        // ------------------- REMOVING ELEMENTS -------------------
        list1.remove(1);           // removes element at index
        list1.remove(Integer.valueOf(3)); // removes specific object, here the Integer.valueOf() is used in the case of 'int' datatype values, because it becomes almost impossible to decide whether the asked value to be removed is the index value or the exact value that is to be removed.
//        so this is made like, if Integer.valueOf(anyValue) be given means its the actual value to ve removed, if any integer directly passed to the .rmove then that means it's the index on/of which the value to be removed.

//        but

        fruits.remove("Apple");//Direct value passing, as index are integers not Strings, so no issue of confusion

        // ------------------- SIZE -------------------
        int size = list1.size();   // number of elements currently present

        // ------------------- CHECKING -------------------
        boolean exists = list1.contains(2); // checks if element exists
        boolean empty = list1.isEmpty();    // checks if list is empty

        // ------------------- LOOPING -------------------
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i)); // index-based loop
        }

        for (Integer num : list1) {
            System.out.println(num); // for-each loop
        }

        // ------------------- SORTING -------------------
        Collections.sort(list1); //Old way, implicitly calls the same list.sort() method only
//       directly using the list.sort()
        list1.sort(null);

        // ------------------- CLEAR -------------------
        list1.clear();              // removes all elements

        // ------------------- OTHER USEFUL METHODS -------------------
        list1.addAll(list2);        // adds all elements of list2 to list1
        list1.indexOf(2);           // returns first occurrence index
        list1.lastIndexOf(2);       // last occurrence index

        // ============================================================
        // 🔹 IMPORTANT CONCEPTS: SIZE vs CAPACITY vs GROWTH
        // ============================================================

        ArrayList<Integer> demo = new ArrayList<>();

        // SIZE:
        // Number of elements actually stored
        // demo.size() → 0 initially

        // CAPACITY:
        // Internal array size (how many elements it can hold without resizing)
        // Default capacity = 10 (when first element is added)

        // GROWTH FACTOR:
        // When capacity is full, ArrayList grows automatically:
        // new capacity = old capacity + (old capacity / 2)
        // Example:
        // 10 → 15 → 22 → 33 → ...

        for (int i = 0; i < 20; i++) {
            demo.add(i); // triggers resizing internally
        }

        // NOTE:
        // Capacity is NOT directly visible by any method, but affects performance

        // ------------------- INITIAL CAPACITY (CUSTOM) -------------------
        ArrayList<Integer> custom = new ArrayList<>(50);
        // sets initial capacity to 50 (avoids resizing if you know size in advance)

    }
}
