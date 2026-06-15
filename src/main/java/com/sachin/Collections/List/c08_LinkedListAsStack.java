package com.sachin.Collections.List;

import java.util.ArrayList;
import java.util.LinkedList;

public class c08_LinkedListAsStack {
    static void main() {

        //See the collection Framework ia a Concept first then later they are the implementation
        //All the rules for any Collection, like ArrayList, LinkedList etc... are made to make those concept real;

        //Hence we have methods to turn the behavior of the LinkedList into the Stack;

        //Let's see how??

        LinkedList<String> list =  new LinkedList<>();

        //Behaves like .push();
         list.addLast("Sachin"); //push()
         list.addLast("Rohan"); //push()
         list.addLast("Ram"); //push()
         list.addLast("Krishna"); //push()
         list.addLast("Krishna"); //push()

        //Behaves like .peek();
        list.getLast();
        System.out.println(list.getLast()); //peek

        //Behaves like .pop();

        list.removeLast(); //pop
        list.removeLast(); //pop

   //We can use ArrayList too as a Stack, but still we don't have inbuilt methods as Stack and LinkedList, so arrays are generally not considered okay for stack implementation
//        ArrayList → not optimized for frequent end operations (resizing cost)
        ArrayList<Integer>  list2 = new ArrayList<>();

//        behaves as push by adding every next element at the end of list
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);

//        behaves as pop by removing the element from the last
         list2.removeLast();

//         behaves as peek by giving the last most value
        System.out.println(list2.getLast());


        /*
        * Ye methods originally ArrayList ke nahi the.

Ye aaye hain Java 21 ke baad, jab List interface ko upgrade kiya gaya.

👉 List me naye default methods add hue:

getFirst()
getLast()
removeFirst()
removeLast()
🧠 Internally kya ho raha hai (important)

Even now, ArrayList internally still same hi hai:

getLast() → get(size() - 1)
removeLast() → remove(size() - 1)

👉 Matlab koi magic nahi hai
👉 Bas syntactic sugar (shortcut methods)
        * */
    }
}

