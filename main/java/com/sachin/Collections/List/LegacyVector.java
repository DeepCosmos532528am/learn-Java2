package com.sachin.Collections;

public class LegacyVector {
    static void main() {

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