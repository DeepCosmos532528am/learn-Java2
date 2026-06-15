package com.sachin.Collections.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c02_Arraylist2 {
    static void main() {

        ArrayList<Integer> list1 = new ArrayList<>(1000); //See here by fixing its capacity manually we are avoiding over-head of resizing it multiple times,
//        see yaar as its growth factor is x1.5 of it's last capacity, now if we already know about how many items are going to be stored in the ArrayList, then why not
//        reducing the overhead of resizing multiple times.
//        remember its capacity not size, size depends on the no.of element's stored while capacity is internal capability to store items without resizing
//
//        See as the capacity exceeds, new array is being created, with 1.5x size of last capacity, and all the values from the old to new array are copied, and ref starts pointing to the new ref (new ArrayList object)

//        we can create arraylist in one more way (on the fly creation)
//        Arrays.asList() creates a fixed-size list backed by an array, where you can read and modify elements but cannot change the size (no add/remove). To get a real dynamic list, wrap it inside an ArrayList.

        List<String> list2 = Arrays.asList("Mango", "Apple", "Grapes");
        System.out.println(list2.get(2));
//        list2.add("Orange"); //Not supported on Arrays.asList(...)

                 /*OR*/

        String []usernames = {"Rohan", "Mohan", "Aditya", "Shiva", "Sachin", "Krishna"};
        List<String> list3 = Arrays.asList(usernames);
        //Cannot give the reference of the ArrayList<String> here at the place of List<String>, because even if the .asList returns the ArrayList object, the issue lies in the return type of the .asList() method, its List<>, so How can the List<> (Parent type) be assigned to the ArrayList<>(Child Type)

        /*
          ArrayList<String> list = Arrays.asList(usernames);
          The compiler blocks this because:

          The Method Signature: The formal return type of Arrays.asList() is List<T>. In Java, you cannot assign a parent interface (List) to a specific child implementation (ArrayList) without an explicit cast.

          The "Imposter" Class: Even if you tried to cast it, it would fail at runtime with a ClassCastException. This is because Arrays.asList() returns java.util.Arrays$ArrayList (a private inner class), which is a "sibling" to java.util.ArrayList, not the same class.

          It’s like two people named "John Smith"—they have the same name, but they aren't the same person and they don't live in the same house!

          */




//        wait, lets see the source of these classes
        System.out.println(list1.getClass().getName());
        System.out.println(list2.getClass().getName());
        System.out.println(list3.getClass().getName());

//        Note: If you are using Java 9 or later, List.of(a, b, c) is often preferred over Arrays.asList() for creating small, immutable lists, as it is even more memory-efficient and truly immutable.

//See
/*
* 🔹 1. ArrayList
✔ Type:
Fully dynamic list
✔ Features:
✅ Add elements
✅ Remove elements
✅ Modify elements
✅ Grows automatically
*
* 🔑 Summary:

Best for real-world programming where data changes.*/

        /*
        * 🔹 2. Arrays.asList()
✔ Type:
Fixed-size list backed by array
✔ Features:
❌ Cannot add/remove
✔ Can update elements (set)
✔ Backed by original array
*
* 🔑 Key point:

Size is fixed because underlying structure is an array.*/

        /*🔹 3. List of() (Java 9+)
✔ Type:
Immutable list
✔ Features:
❌ Cannot add
❌ Cannot remove
❌ Cannot modify
✔ Read-only access

🔑 Key point:

Strictly read-only, safest for constant data.*/

    }
}
