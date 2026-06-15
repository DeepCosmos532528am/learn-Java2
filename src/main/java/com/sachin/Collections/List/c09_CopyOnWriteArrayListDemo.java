package com.sachin.Collections.List;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c09_CopyOnWriteArrayListDemo {

    /*
    ===================== 🧠 COPY ON WRITE - CORE CONCEPT =====================

    CopyOnWrite means:
    - Whenever a write operation happens (add/remove/update),
      instead of modifying the existing list,
      a NEW COPY of the underlying array is created.
    - The modification is applied on that new copy.
    - The reference is then updated to point to this new list.

    This ensures:
    - Other threads reading the list are NOT affected
    - No ConcurrentModificationException occurs

    ==========================================================================


    ===================== ⚡ READ vs WRITE =====================

    ✔ Read Operations:
    - Very FAST
    - No locking required
    - Always read from a stable (snapshot) version of the list

    ❌ Write Operations:
    - COSTLY
    - New copy of entire array is created every time
    - Not efficient if writes are frequent

    ==========================================================================


    ===================== 🔥 VERY IMPORTANT (INTERVIEW POINT) =====================

    Iterator Behavior:
    - Iterator works on a SNAPSHOT (old copy of list)
    - Any modification (add/remove) creates a NEW copy
    - Iterator DOES NOT see these changes during iteration

    👉 That’s why:
       No ConcurrentModificationException occurs

    ==========================================================================


    ===================== ⚠️ WHEN TO USE =====================

    ✔ Best for:
    - Read-heavy applications (more reads, fewer writes)
    - Multi-threaded environments
    - Example: caching, configuration data, listeners list

    ❌ Not suitable for:
    - Write-heavy applications (because copying is expensive)

    ==========================================================================


    ===================== ❌ WHY NOT ARRAYLIST / VECTOR =====================

    ArrayList:
    - Not thread-safe
    - Throws ConcurrentModificationException during concurrent modification

    Vector:
    - Thread-safe (synchronized)
    - But slow due to locking overhead on every operation

    CopyOnWriteArrayList:
    - No locking for reads
    - Safe + better performance in read-heavy cases

    ==========================================================================


    ===================== 🧪 EXAMPLE =====================
    */

    public static void main(String[] args) {

        // List<String> list = new ArrayList<>();
        // ❌ Not safe in concurrent modification scenario
        // Will throw ConcurrentModificationException

//        Instead recommended is -> new CopyOnWriteArrayList<>()

        List<String> list = new CopyOnWriteArrayList<>();
        // ✅ Thread-safe and safe for concurrent modification

        list.add("Milk");
        list.add("Water");
        list.add("Apple");
        list.add("Orange");
        list.add("Bhindi");

        // Iteration uses SNAPSHOT of list
        for (String obj : list) {
            System.out.println(obj); // Read operation

            // These are WRITE operations:
            // Each will create a NEW COPY of the underlying array

            list.add("Banana");
            list.add("CupCake");

            list.remove("Apple");
        }

        /*
        ===================== 🧠 IMPORTANT OBSERVATION =====================

        - The loop will NOT reflect new changes
        - Because iterator is working on OLD SNAPSHOT

        - All modifications are applied on NEW COPIES
        - Final list will include all updates AFTER loop ends

        ==================================================================
        */

        System.out.println(list);
    }
}