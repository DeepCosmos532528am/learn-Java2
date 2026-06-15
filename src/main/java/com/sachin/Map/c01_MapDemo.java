package com.sachin.Map;

import java.util.*;

public class c01_MapDemo {
    /**
     * Demonstrates HashMap operations: insertion, search, iteration, modification, removal
     */
    static void main(String[] args) {

        /*
        ===================== 🧠 HASHMAP BASICS =====================
        - Stores data in KEY-VALUE pairs
        - Keys are UNIQUE
        - Values can be duplicate
        - Order is NOT guaranteed
        - Not thread-safe
        ============================================================
        */

        HashMap<Integer, String> map = new HashMap<>();
//       HashMap<Integer, String> map = new HashMap<>(10, 2); //we can give our custom initial capacity and load factor too

        // ===================== INSERTION =====================
        map.put(2, "Sachin");
        map.put(0, "Anushka");
        map.put(3, "Krishna");
        map.put(4, "Krish");
        map.put(5, "Radhav");

        System.out.println(map); // Prints map (order not guaranteed)

        // ===================== SEARCH OPERATIONS =====================
        System.out.println(map.containsKey(3));        // true → checks key existence
        System.out.println(map.containsValue("Krish")); // true → checks value existence

        // ===================== GET VALUE =====================
        String s = map.get(5); // returns "Radhav"
        System.out.println(s);

        String s1 = map.get(2); // returns "Sachin"
        System.out.println(s1);

        /*
        ===================== ITERATION METHODS =====================

        1. keySet() → iterate over keys
        2. entrySet() → iterate over key-value pairs (BEST PERFORMANCE)

        =============================================================
        */

        // Iterating using keySet (less efficient, because get() is called again)
        for (int key : map.keySet()) {
            System.out.println(map.get(key));
        }

        // ===================== ENTRY SET (BEST WAY) =====================
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            // Modifying values (convert to uppercase)
            entry.setValue(entry.getValue().toUpperCase());

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        /*
        NOTE:
        - entrySet() is preferred because:
          ✔ Direct access to key and value
          ✔ Better performance than keySet() + get()
        */

        // ===================== REMOVE OPERATIONS =====================

        // remove(key) → removes entry and returns value
        System.out.println(map.remove(2)); // returns removed value

        // remove(key, value) → removes ONLY if both match
        Boolean remove = map.remove(3, "KRISHNA"); // true
        Boolean remove1 = map.remove(4, "RADHAV"); // false (value mismatch)

        System.out.println(remove);
        System.out.println(remove1);

        // ===================== FINAL MAP =====================
        System.out.println(map);
    }
}

//Read this first note on 'Hashmap' then only visit to the note next to this one, see the things are written repeatedly in various structuring but the means of all is the same. Don't get scared of this long note.


/*
====================================================================================================
🚀 HASHMAP INTERNALS (SIMPLIFIED HINGLISH)
====================================================================================================

📌 1. BUCKET KYA HAI?
HashMap ek array use karta hai. Is array ke har slot ko hum "Bucket" bolte hain.
By default 16 buckets bante hain (0 to 15 index).



📌 2. PUT() KAISE KAAM KARTA HAI? (Step-by-Step)
Jab aap `map.put(key, value)` karte ho, toh ye 3 bade kaam hote hain:

A. Hash Code nikalna:
   Sabse pehle Java `key.hashCode()` call karta hai. Maan lo code aaya 12345.

B. Bucket Index nikalna:
   Ab is code ko array size ke andar fit karne ke liye formula lagta hai:
   Index = hashCode % 16. Maan lo index aaya '4'.

C. Entry Save karna:
   - Agar Bucket 4 khali hai: Toh wahan ek "Node" (Key, Value, Next) store ho jayega.
   - Agar Bucket 4 bhar chuka hai (Collision):
     1. Java us bucket ki Linked List mein check karega `key.equals()` use karke.
     2. Agar `equals()` TRUE hai: Toh purani value ko update kar dega (No duplicate key).
     3. Agar `equals()` FALSE hai: Toh list ke niche naya Node latak jayega.

📌 3. GET() KAISE KAAM KARTA HAI? (Retrieval)
- Java firse `key.hashCode()` nikalega aur Index (Bucket) tak pahunchega.
- Us bucket mein jitne bhi log hain, sabse ek-ek karke `equals()` check karega.
- Jiske liye `equals()` true hoga, uski value return kar dega.

📌 4. JAVA 8 KA JALWA (TREEIFY)
- Agar ek hi bucket mein bheed (collision) bahut badh jaye (8 se zyada nodes),
  toh Linked List ko "Red-Black Tree" bana diya jata hai.
- Isse search speed fast ho jati hai (Complexity O(1) se O(log n) max tak hi rehti h, na ki O(n) ho jaati h).

📌 5. RESIZING (Badi mehnat wala kaam)
- Jab HashMap 75% bhar jata hai (Load Factor = 0.75), toh ye apna size double (16 se 32) kar leta hai.
- Is time saare elements ka 'Re-hashing' hota hai, yaani sabko naye ghar (buckets) diye jaate hain.



📌 6. INTERVIEW KE LIYE SHORT SUMMARY:
- Insertion: hashCode() -> index -> equals() check -> store.
- Collision: Handle via Linked List or Tree (Java 8+).
- Custom Objects: Hamesha `hashCode()` aur `equals()` override karo, warna Map confuse ho jayega.
- Time Complexity: Average O(1), Worst Case $O(\log n)$ (Java 8).

====================================================================================================
*/

/*
===================== 🧠 HASHMAP IN JAVA (INTERVIEW NOTES) =====================

📌 What is HashMap?
- HashMap is a data structure that stores data in KEY-VALUE pairs
- Part of java.util package
- Implements Map interface
- Keys are UNIQUE, values can be duplicate
- Order is NOT guaranteed (insertion order not maintained)

===============================================================================

📌 Internal Working (IMPORTANT)
- Uses Hashing
- Data stored in buckets (array of nodes)
- Each key → hashCode() → determines bucket index
- If collision occurs → handled using:
    ✔ Linked List (before Java 8)
    ✔ Balanced Tree (after Java 8, if bucket size > threshold)

===============================================================================

📌 Time Complexity
- put()    → O(1) average, O(n) worst
- get()    → O(1) average, O(n) worst
- remove() → O(1) average

===============================================================================

📌 Basic Operations
- put(key, value)     → insert/update
- get(key)            → retrieve value
- remove(key)         → delete entry
- containsKey(key)    → check key existence
- containsValue(val)  → check value existence
- size()              → number of entries
- isEmpty()           → check empty

===============================================================================

📌 Important Characteristics
- Allows ONE null key
- Allows multiple null values
- Not thread-safe (not synchronized)
- Faster than HashTable

===============================================================================

📌 Load Factor & Capacity (INTERVIEW FAVORITE)
- Default capacity = 16
- Load factor = 0.75
- When size > capacity * loadFactor → resizing happens
- Resizing = rehashing (expensive operation)

===============================================================================

📌 Collision Handling
- Two keys can map to same bucket (collision)
- Java handles using chaining (LinkedList / Tree)
- Good hashCode() reduces collisions

===============================================================================

📌 Equals & hashCode (VERY IMPORTANT)
- Used to identify keys uniquely
- If two keys are equal → hashCode must be equal
- Override both methods when using custom objects as keys

===============================================================================

📌 Iteration Methods
- keySet()        → iterate keys
- values()        → iterate values
- entrySet()      → iterate key-value pairs (BEST PERFORMANCE)

===============================================================================

📌 When NOT to use HashMap
- When ordering is required → use LinkedHashMap
- When sorting is required → use TreeMap
- When thread safety is required → use ConcurrentHashMap

===============================================================================

📌 Common Interview Questions
- How HashMap works internally?
- What is collision?
- Difference between HashMap vs HashTable?
- Why equals() and hashCode() important?
- What happens during resizing?

===============================================================================

📌 Quick Summary
- Key-Value data structure
- Fast operations (O(1))
- Uses hashing
- Not thread-safe
- Best for fast lookup

===============================================================================
*/


//Working thorugh digram

/*
===================== 🧠 HASHMAP INTERNAL DIAGRAM =====================

Step 1: Initial Structure (Array of Buckets)

        Index →    0      1      2      3      4      5   ...
                   |      |      |      |      |      |
                   ↓      ↓      ↓      ↓      ↓      ↓
                 null   null   null   null   null   null


=======================================================================

Step 2: Inserting Key-Value Pair

Example:
put("Apple", 10)

👉 hashCode("Apple") → some number
👉 index = hashCode % capacity

        Index →    0      1      2      3      4      5
                   |      |      |      |      |      |
                   ↓      ↓      ↓      ↓      ↓      ↓
                 null   null   [Apple=10]   null   null   null


=======================================================================

Step 3: Collision Handling

put("Ape", 20)

👉 If "Ape" maps to SAME index as "Apple"

        Index →    0      1      2      3      4      5
                   |      |      |      |      |      |
                   ↓      ↓      ↓      ↓      ↓      ↓
                 null   null   [Apple=10] → [Ape=20]   null   null

👉 This is called CHAINING (Linked List)


=======================================================================

Step 4: Java 8 Optimization (Tree Conversion)

If too many elements in same bucket:

        [Apple=10]
             ↓
        [Ape=20]
             ↓
        [Ant=30]
             ↓
        [Another=40]

👉 Converted into Balanced Tree (Red-Black Tree)

        [Ape=20]
         /     \
 [Apple=10]  [Ant=30]
                 \
              [Another=40]


=======================================================================

Step 5: Retrieval (get operation)

get("Apple")

👉 hashCode → index → go to bucket
👉 traverse list/tree → find key using equals()

Time:
- O(1) average
- O(log n) if tree
- O(n) worst case


=======================================================================

Step 6: Resizing (Rehashing)

Default:
- Capacity = 16
- Load Factor = 0.75

When:
size > 16 * 0.75 = 12

👉 Resize happens → new capacity = 32
👉 All elements REHASHED (re-distributed)

⚠️ Expensive operation


=======================================================================

🧠 FINAL FLOW (ONE LINE)

Key → hashCode() → index → bucket → (list/tree) → equals() → value

=======================================================================
*/

/*👉 “HashMap uses an array of buckets where each key is hashed to an index.
 If multiple keys map to the same index, collisions are handled using a linked
 list or a balanced tree (after Java 8). Retrieval involves hashing the key,
  locating the bucket, and then searching within it using equals().”*/



