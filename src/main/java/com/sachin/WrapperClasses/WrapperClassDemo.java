package com.sachin.WrapperClasses;

public class WrapperClassDemo {
    static void main() {
        /*
         * 1️⃣ What is a Wrapper Class?
         * A Wrapper Class is a class that wraps a primitive data type into an object.
         * Java provides wrapper classes because primitive types are not objects, but many APIs (like collections) work only with objects.
         */

        //Every Primitive dataType have its corresponding Wrapper class followed by first letter Capital letter,
        // like Integer,
        // Byte,
        // Short,
        // Character,
        // Long,
        // Double,
        // Float,
        // Boolean.

        int x = 10;        // primitive
        Integer y = 10;    // wrapper object

      /*  2️⃣Why Wrapper Classes Are Needed
          Some Java features require objects, not primitives.
          Example with Java Collections Framework:
          ❌Not allowed:
          ArrayList<int> list = new ArrayList<>();
          ✔ Allowed:
          ArrayList<Integer> list = new ArrayList<>();

          Because collections store objects only.
       */


        /*
          3️⃣ Autoboxing and Unboxing (Very Important)
          Since Java 5, Java automatically converts between primitive and wrapper.
        */

        //Autoboxing (primitive → object)
        int a = 10;
        Integer b = a;

        //Unboxing (object → primitive)
        Integer a2 = 20;
        int b2 = a;

        //Java internally converts them.

        /*
         4️⃣ == vs .equals() (Classic Interview Trap)
        == Compares reference (memory address).
        .equals() Compares actual value.
         */

        //Example:
        Integer a3 = 200;
        Integer b3 = 200;

        System.out.println(a3 == b3);       // false
        System.out.println(a3.equals(b3));  // true

        //Reason: two different objects in memory.

        /*
        5️⃣ Integer Cache (Most Asked Interview Question)
        Java caches Integer objects from -128 to 127.
        */

        //Example:

        Integer a4 = 100;
        Integer b4 = 100;

        System.out.println(a4 == b4);

        //✔ Output true
        // Because both variables refer to the same cached object.
        //But:

        Integer o = 200;
        Integer q = 200;

        System.out.println(o == q);

        //✔ Output false
        //Because new objects are created.

        /*
        6️⃣ Integer.parseInt() vs Integer.valueOf()
          Method       Return Type
        parseInt()	  primitive int
         valueOf()	  Integer object
        */

        //Example:

        int a5 = Integer.parseInt("10");
        Integer b5 = Integer.valueOf("10");

        /*7️⃣ new Integer() vs Integer.valueOf() (Another Trap)
        Integer a = new Integer(10);
        Integer b = new Integer(10);

        System.out.println(a == b);

       //✔ Output false
       //Because new always creates a new object.
       //But:
        Integer a = Integer.valueOf(10);
        Integer b = Integer.valueOf(10);

       //✔ Output: true
       //Because it uses the cache.
         */

       /* 8️⃣ NullPointerException with Unboxing
          Another interview trick:

        Integer a = null;
        int b = a;

         //❌ Runtime error: NullPointerException
         //Because Java tries to unbox null to int.
        */

        /*
        9️⃣ Wrapper Classes Are Immutable
        Example:

        Integer a = 10;
        a = 20;

        //Java does not change the object.
        //Instead, it creates a new object.

      //🔑 Perfect Interview Summary

        //You can say this:
        Wrapper classes in Java convert primitive data types into objects so they can be used in APIs like collections.
         Java provides automatic conversion through autoboxing and unboxing.
          Wrapper objects are immutable, and comparisons using == check references while
           .equals() checks values. Integer objects between -128 and 127 are cached,
            which can cause == to sometimes return true for wrapper objects.
         */

        Integer i = 23;                        // Autoboxing
        Integer i2 = Integer.valueOf("3");  // String to Integer conversion
        Integer i3 = Integer.valueOf(3);     // Manual boxing

        System.out.println(i2 + i3);         // Auto-unboxing during arithmetic

        int t = i2;                          // Unboxing
        int p = i3;                          // Unboxing

        /*
         * When a String is passed to the Integer wrapper class constructor or methods like Integer.
         * valueOf(), Java attempts to convert the string into a numeric value.
         * If the string is not a valid integer, a NumberFormatException is thrown.
         * */

        /*
         * In Java, Integer objects between -128 and 127 are cached,
         * so Integer a = 100; Integer b = 100; a == b returns true,
         * but for values outside this range like 200, a == b returns
         * false because different objects are created.
         * */

        // The equals() method in Java is defined in the Object class, and since every class implicitly extends Object,
        // all classes inherit this method. When we use .equals() on any class object then it uses
        // by default version of .equals() defined in the Object class.
        // By default, equals() compares object references similar
        // to the == operator. However, many classes like String and wrapper classes override
        // equals() to provide logical comparison based on the actual content of the objects.
        // Primitive types cannot use equals() because they are not objects and do not inherit from
        // the Object class.

        /*
        In default Object class the .equals looks like this:
         public boolean equals(Object obj) {
            return this == obj;
        }

        for an example if we do:
        class Student{...}
        Student s1 = new Student("A");
        Student s2 = new Student("A");

           s1.equals(s2)   // false

           s1 -> this
           s2 -> obj
           so in the default implementation defined in the Object class it becomes
           s1 == s2, and it results in false, because '==' compares references of two objects
        */

        /*
        Integer a = 2;
        Yeh Autoboxing hai.Yahan Java piche se apne aap Integer.valueOf(2) ko call kar deta hai.
        isme Integer a  = "2"; Strings not allowed

        Integer a = Integer.parseInt("2");
        Yahan pehle parseInt String ko primitive int banata hai, aur fir Java us int ko Autobox karke Integer object
        mein daal deta hai.

        Integer a = new Integer(2) ya new Integer("2")
        Yeh purana tarika hai jo ab Deprecated(Java 9se) ho chuka hai kyunki yeh zabardasti naya object banata hai
        aur memory waste karta hai.

        Integer a = Integer.valueOf(2)
        Yeh Manual Boxing hai.Yeh direct primitive int leta hai aur Integer Cache ka use karke object return karta hai.

        Integer a = Integer.valueOf("2")
        Yeh valueOf ka Overloaded version hai.Yeh pehle parseInt use karke String ko number banata hai, fir valueOf( int)
        ko call karke object deta hai.

        int a = Integer.parseInt("2")
        Yeh sirf ek Conversion tool hai.Iska kaam bas String se primitive int nikaalna hai, koi object banana nahi.

        //Integer.valueOf() caching ka feature deta h from -128 to 127, koi new object create nahi hoga itne range me, toh iss tareeke se obj banane jesa kaam and then cleanup se boht hadd tak chhutkara milta h
        agar iss rangese out hota h toh hi new object banega
         */


        //we can increase the size of the caching range -128 to 127;
        //No float and Double have caching mechanism,

    }
}
