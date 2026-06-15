package com.sachin.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

//
//🧠 LinkedHashMap kya hota hai?
//👉 It is HashMap + ordering
// default: insertion order maintain karta hai
public class c03_LinkedHashMapDemo {
    static void main() {
//  can also do LinkedHashMap<String, Integer> map= new LinkedHashMap<>(10, 2, true); initial capacity, load factor, and 👉 last parameter = accessOrder


//        🔥Types of order:
//        1️⃣Insertion Order (default)
//        new LinkedHashMap<>(); //In this case the access order is by def false, means  (LRU style cache) is false
//        ✔ Order same as insertion

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(); //by def access order is false here
        // Same as Hashmap just maintains the insertion order
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println(map);//A=1, B=2, C=3


        //2️⃣ Access Order (LRU style cache)

        //new LinkedHashMap <>(16, 0.75f, true);
        //👉 last parameter = accessOrder
        //✔ true → recently accessed entries, end me chale jate hain

        LinkedHashMap<String, Integer> map2 =
                new LinkedHashMap<>(16, 0.75f, true);

        map2.put("A", 1);
        map2.put("B", 2);
        map2.put("C", 3);

        map2.get("A"); // A moves to end

        System.out.println(map2);//B, C, A

        //✔ true → recently accessed entries end me chale jate hain

        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "Sachin");
        LinkedHashMap<Integer, String>  map3 = new LinkedHashMap<>(hashmap); // In this way we can copy the element to LinkedHashmap in order to convert the hashmap to LinkedHashmap
        map3.put(2, "Naman");

        System.out.println("checking content equality of hashmap and map3 "+hashmap.equals(map3));//returns true if content is same
        System.out.println("checking reference equality of hashmap and map3 "+ (hashmap == map3));

        System.out.println(map3);
        System.out.println(hashmap);

        hashmap.putIfAbsent(1, "sachin"); // if the key is not already present then adds the new record in the condition if not present
        System.out.println(hashmap.getOrDefault(100, "could not find"));// if the key is not found then no value returned right!!, so instead of value it returns the def value we give here

        System.out.println(hashmap);


        //🎯 Interview line:
        //“LinkedHashMap is a HashMap with a doubly linked list that
        // maintains insertion order or access order depending on configuration.”
    }
}