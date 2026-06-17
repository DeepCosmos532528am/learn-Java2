package com.sachin.Map.legacy;

import javax.xml.transform.Source;
import java.util.*;

public class c01_HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer , String> username = new Hashtable<Integer, String>();
           username.put(1, "John");
           username.put(1, "Bob");
           username.put(2, "Alex");
           username.put(8, "Rehman");
           username.put(4, "Diara");

        HashMap<Integer, String> users = new HashMap<>();
        username.put(7, "John");
        username.put(6, "Nargis");
        username.put(2, "Armour");
        username.put(21, "Henry");
        username.put(0, "Peter");

        username.putAll(users);

        System.out.println(users.entrySet());
        System.out.println(username.entrySet());

        username.remove(99);
        System.out.println(username.entrySet());


    }
}

/**
 * Hashtable is Synchronized,
 * no null key and value allowed,
 * Legacy class,
 * slower than hashmap due to Synchronization overhead,
 * Same internal working as HashMap, but you may remember that the Hashmap in the case of collisions uses linked list and if its capcity (8) gets exceed then it switched to red-black binary search tree
 * but in the case of Hashtable it only uses LinkedList no concept of the redblack tree there.
 *
 * */
