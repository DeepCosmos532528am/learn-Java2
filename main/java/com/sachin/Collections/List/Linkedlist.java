package com.sachin.Collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Linkedlist {
    static void main() {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);//Time complexity O(1)
        list.add(2);//Time complexity O(1)
        list.add(3);//Time complexity O(1)
        list.get(2); //Time complexity O(n)
        list.set(2, 9);
        list.add(2, 11);
        list.addLast(5);//Time complexity O(1) //Ye methods ko dekh lena recent update me kucch badal gya h bhai inme in getlast, first walon me
        list.addFirst(0);//Time complexity O(1)
        list.getFirst();//Time complexity O(1)
        list.getLast();//Time complexity O(n)
        System.out.println(list);

        list.removeIf((e) -> (e % 2) == 0); //accepts Predicate object, so used lambda here, for anonymous class obj passing the lambda function be directly executed
//                .removeIf() actually removes the corresponding value from the linked list, if the condition returned form the predicate be met (true)
        System.out.println(list);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));

        animals.removeAll(animalsToRemove); //it expects suitable Collection to be passed, containing the values to be removed form the other Corresponding same time of the collection.
    /*removeAll() removes ALL matching elements
It uses equals() internally
Time complexity usually O(n × m)*/
        System.out.println(animals);
        List<Integer> list2 = List.of(1, 2, 3);
       String  s = "sacihin";
       s.toUpperCase();
        System.out.println(s);
        System.out.println(list2);
    }
}
 /*

# JAVA LINKED LIST (INTERVIEW NOTES)

Package:
java.util.LinkedList

Implements:

* List
* Deque
* Queue

---

1. BASIC IDEA

---

* LinkedList is based on DOUBLY LINKED LIST

* Each node contains:
  [prev | data | next]

* Not stored in contiguous memory (unlike ArrayList)

* Elements are connected via pointers (references)

---

2. INTERNAL STRUCTURE (IMPORTANT)

---

class Node<E> {
E item;
Node<E> next;
Node<E> prev;
}

* Maintains:
  Node<E> first;
  Node<E> last;
  int size;

---

3. CONSTRUCTORS

---

LinkedList()
→ Empty list

LinkedList(Collection<? extends E> c)
→ Copies all elements

---

4. TIME COMPLEXITY (VERY IMPORTANT)

---

## Operation            Time Complexity

get(index)           O(n)
add(element)         O(1) (at end)
add(index, element)  O(n)
remove()             O(1) (head/tail)
remove(index)        O(n)
contains()           O(n)

⚠️ No random access (unlike ArrayList)

---

5. KEY METHODS

---

add(E e)
→ Adds at end

addFirst(E e)
addLast(E e)

getFirst()
getLast()

removeFirst()
removeLast()

offer(E e)       // Queue
poll()           // Queue
peek()

push(E e)        // Stack
pop()

---

6. LINKEDLIST AS:

---

(A) LIST
→ ordered collection

(B) QUEUE (FIFO)
→ offer(), poll()

(C) DEQUE (double ended)
→ addFirst(), addLast()

(D) STACK (LIFO)
→ push(), pop()

---

7. ARRAYLIST vs LINKEDLIST

---

ArrayList:

* Fast random access O(1)
* Slow insert/delete (shifting)

LinkedList:

* Slow access O(n)
* Fast insert/delete (no shifting)

---

8. WHEN TO USE LINKEDLIST?

---

✔ Frequent insertion/deletion
✔ Unknown size
✔ Working with queue/deque

❌ Avoid when:

* Frequent get(index)
* Need fast random access

---

9. MEMORY

---

* More memory than ArrayList
* Stores extra prev & next references

---

10. INTERVIEW TRAPS

---

1. get(index) is slow → O(n)
2. Not synchronized
3. Allows null elements
4. Better for add/remove, worse for search

---

11. ITERATION

---

Iterator<E> it = list.iterator();

ListIterator<E> lit = list.listIterator();

* Can traverse both directions (ListIterator)

---

12. FAIL-FAST BEHAVIOR

---

* Throws ConcurrentModificationException
* If modified during iteration

---

13. EXAMPLE

---

LinkedList<Integer> list = new LinkedList<>();

list.add(10);
list.addFirst(5);
list.addLast(20);

System.out.println(list); // [5, 10, 20]

---

## END OF NOTES

*/
