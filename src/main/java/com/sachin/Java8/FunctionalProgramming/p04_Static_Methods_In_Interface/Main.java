package com.sachin.Java8.FunctionalProgramming.p04_Static_Methods_In_Interface;

/** See this file does not demstrate java 8 static behavior, although it should according to the package name, but here some other nuances related to inner class and inner interfaces have been seen.
 *  
 *  So with the context to Java 8 you can ignore this file */


/**
========================================================
1. INTERFACES WITH SAME DEFAULT METHOD (CONFLICT CASE)
========================================================
*/

interface A {
    default void show() {
        System.out.println("A show");
    }
}

interface B {
    default void show() {
        System.out.println("B show");
    }
}

/**
========================================================
2. CLASS IMPLEMENTING BOTH INTERFACES
   -> MUST OVERRIDE show()
========================================================
*/

class C implements A, B {

    @Override
    public void show() {
        // we must resolve conflict manually
        System.out.println("C show (resolved conflict)");

        // we can also explicitly choose:
        A.super.show(); // call A's version
        B.super.show(); // call B's version
    }
}

/**
========================================================
3. INNER INTERFACE INSIDE OUTER INTERFACE
   (NO INHERITANCE, ONLY NAMESPACING + LEXICAL SCOPE)
========================================================
*/

interface Outer {

    int X = 10; // public static final

    static void staticMethod() {
        System.out.println("Outer static method");
    }

    default void defaultMethod() {
        System.out.println("Outer default method");
    }

    interface Inner {

        default void test() {

            // lexical scope allows access to static members
            System.out.println(X);          // OK (constant)
            Outer.staticMethod();           // OK (static method)

            // defaultMethod(); ❌ NOT allowed
            // (no inheritance between Outer and Inner)
        }
    }
}

/**
========================================================
4. INNER CLASS (HAS OUTER OBJECT REFERENCE)
========================================================
*/

class OuterClass {

    int x = 10;        // instance variable
    static int y = 20; // static variable

    void outerMethod() {
        System.out.println("Outer method");
    }

    class InnerClass {

        void test() {

            // INNER CLASS CAN ACCESS EVERYTHING OF OUTER
            System.out.println(x);     // instance field (via Outer.this)
            System.out.println(y);     // static field

            outerMethod();             // instance method allowed

            // lexical + implicit Outer object reference
        }
    }
}

/**
========================================================
5. SHADOWING, HIDING, OVERRIDING DEMO
========================================================
*/

class Parent {

    int x = 100; // instance variable

    static void staticShow() {
        System.out.println("Parent static");
    }

    void instanceShow() {
        System.out.println("Parent instance");
    }
}

class Child extends Parent {

    int x = 200; // SHADOWING (instance variable)

    static void staticShow() {
        System.out.println("Child static"); // HIDING
    }

    @Override
    void instanceShow() {
        System.out.println("Child instance"); // OVERRIDING
    }
}

/**
========================================================
6. MAIN METHOD (FINAL BEHAVIOUR TEST)
========================================================
*/

public class Main {
    public static void main(String[] args) {

        // ===== INTERFACE DEFAULT CONFLICT =====
        C obj1 = new C();
        obj1.show(); 
        /**
        Output:
        C show (resolved conflict)
        A show
        B show
        */

        // ===== OVERRIDING VS SHADOWING VS HIDING =====
        Parent obj = new Child();

        System.out.println(obj.x);
        // 100 → SHADOWING (reference type decides)

        obj.staticShow();
        // Parent static → HIDING (compile-time)

        obj.instanceShow();
        // Child instance → OVERRIDING (runtime polymorphism)

        // ===== INNER CLASS =====
        OuterClass.InnerClass inner =
                new OuterClass().new InnerClass();

        inner.test();
    }
}

/**
========================================================
FINAL CORE SUMMARY (VERY IMPORTANT)
========================================================

1. Inner Interface:
   -> NO inheritance from outer
   -> ONLY lexical access to static members

2. Inner Class:
   -> HAS implicit Outer.this reference
   -> Can access instance + static members

3. Default method conflict:
   -> Must override in implementing class

4. Shadowing:
   -> instance variables → compile-time (reference type)

5. Hiding:
   -> static methods → compile-time

6. Overriding:
   -> instance methods → runtime (dynamic dispatch)

========================================================
*/