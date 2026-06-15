package com.sachin.Collections.List;

import java.util.Vector;

public class c06_LegacyVector {
    static void main() {
        Vector<Integer> list = new Vector<>(10, 10);
//            Vector<Integer> list = new Vector<>(10, 20); now the auto increment in the capacity would not work as
//            we have manually passed the initialCapacity and the incrementCapacity(Growth factor)

        System.out.println("The initial capacity of vector is: " + list.capacity()); // In vector yes we have .capacity() method to check the initial capacity
        list.add(9);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(23);
        list.add(12);
        list.add(91);
        list.add(96);
        System.out.println("the size after putting exact same no. of elements as its default capacity " + list.size());

        list.add(9);
        System.out.println("the size after putting some elements" + list.size());

        list.add(9);
        list.add(54);
        list.add(12);
        list.add(32);
        list.add(12);
        list.add(0);
        list.add(12);
        list.add(32);
        list.add(93);
        list.add(2);
        list.add(1);
        System.out.println(list);
        System.out.println("Now the capacity  is: " + list.capacity());
        System.out.println("Now the size is: " + list.size());
        System.out.println(list.capacity()); // In vectors the capacity gets double, of last capacity //Will print 40

        list.add(list.size(), 3);
        System.out.println(list.getLast());
        System.out.println(list.getFirst());
        System.out.println(list.getClass());
        System.out.println(list.contains(2));
        System.out.println(list.contains(1000));
        System.out.println(list.isEmpty());
        list.remove(1); // removes the first occurrence of the element specified
        list.remove(1); //removes the element at the specified element
        list.set(3, 10);//replaces at the specified index with new element
        System.out.println(list);

        System.out.println(list.size());

        list.removeIf((e) -> e % 2 != 0);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.clear();
        System.out.println(list); //removes all the elements from the list


//       Now just for one time, lets see how the synchronization in the Vectors works

//        ArrayList<Integer> list2 = new ArrayList<>();//As Arraylist not gives the expected output because it is non-synchronized
       //Actually on the same instant Threads t1 and t2 both are updating the same list, so two threads' update is like only one update, it's what it is showing the non synchronized update
       //But let's check it with the Vector, it will give correct answer as the vector is synchronized.

        Vector<Integer> list2 = new Vector<>();

        Thread t1 = new Thread(() -> { //Thread Constructor Expects Runnable Functional interface
            for (int i = 0; i < 1000; i++) {
                list2.add(i);
            }
        });


        Thread t2= new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list2.add(i);
            }
        });

        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The size of the Arrlist now"+ list2.size());

    }



}

/*
========================================
JAVA VECTOR (INTERVIEW NOTES)
========================================

Package:
java.util.Vector

Implements:
- List
- RandomAccess
- Cloneable
- Serializable

----------------------------------------
1. BASIC IDEA
----------------------------------------
- Vector is a dynamic array
- Grows automatically when capacity exceeds
- Similar to ArrayList but SYNCHRONIZED (thread-safe)

----------------------------------------
2. KEY FEATURES
----------------------------------------

✔ Dynamic Array
- Grows automatically like ArrayList but by (2x) where arraylist by (1.5);

✔ Thread-Safe (Synchronized)
- All methods are synchronized
- Safe in multithreading
- Slower in single-threaded environment

✔ Legacy Class
- Part of early Java versions
- Prefer ArrayList in modern single-threaded apps

✔ Resizing Mechanism
- Capacity increases automatically
- Default: doubles size (or uses increment value if provided)

✔ Random Access
- Supports index-based access (O(1))

----------------------------------------
3. CONSTRUCTORS
----------------------------------------

Vector()
→ Creates vector with default capacity (usually 10)

Vector(int initialCapacity)
→ Creates vector with given capacity

Vector(int initialCapacity, int capacityIncrement)
→ Capacity increases by fixed increment when full

Vector(Collection<? extends E> c)
→ Copies elements from another collection

----------------------------------------
4. METHODS (IMPORTANT)
----------------------------------------

add(E e)
→ Adds element at end

add(int index, E element)
→ Inserts at index

get(int index)
→ Retrieves element

set(int index, E element)
→ Replaces element

remove(Object o)
→ Removes first matching element

remove(int index)
→ Removes element at index

size()
→ Returns number of elements

isEmpty()
→ Checks if vector is empty

contains(Object o)
→ Checks if element exists

clear()
→ Removes all elements

----------------------------------------
5. PERFORMANCE COMPARISON
----------------------------------------

Vector:
- Thread-safe (synchronized)
- Slower due to locking overhead

ArrayList:
- Not synchronized
- Faster in single-threaded environment

----------------------------------------
6. ARRAYLIST vs VECTOR (INTERVIEW)
----------------------------------------

ArrayList:
✔ Not synchronized
✔ Faster
✔ Modern choice

Vector:
✔ Synchronized
✔ Slower
✔ Legacy class

----------------------------------------
7. WHEN TO USE VECTOR?
----------------------------------------

✔ Rare cases where thread safety is needed AND no external synchronization is used

Vector is thread-safe because all methods are synchronized, but it is not preferred
because it synchronizes every operation, causing unnecessary performance overhead.
Modern Java prefers external synchronization or concurrent collections like
CopyOnWriteArrayList for better efficiency and flexibility.

❌ Avoid when:
- Single-threaded apps
- Performance-critical code

Preferred alternative:
- Collections.synchronizedList(new ArrayList<>())

----------------------------------------
8. INTERVIEW TRAPS
----------------------------------------

⚠ Vector is synchronized (NOT ArrayList)
⚠ Both are dynamic arrays
⚠ Both support random access
⚠ Vector grows by doubling capacity (default behavior)
⚠ Legacy class → rarely used in modern Java



----------------------------------------
END OF NOTES
----------------------------------------
*/