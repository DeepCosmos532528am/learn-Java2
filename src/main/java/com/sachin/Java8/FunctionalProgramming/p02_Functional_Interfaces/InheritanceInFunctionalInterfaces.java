package com.sachin.Java8.FunctionalProgramming.p02_Functional_Interfaces;

/**
 * <a style="font-size:10px; border-radius: 10px; padding-right: 2px; " href="package-summary.html">functional interface</a> remains valid if:
 * @1 Exactly 1 abstract method after inheritance
 * @2 Default/static methods are ignored
 * @3 Object methods like .toString() .equals() .hashCode() are ignored in counting
 * @4 Same-signature duplicates collapse into one
 * @5 Method can come from parent class inheritance also*/

public class InheritanceInFunctionalInterfaces {
    static void main() {
        // CASE 9: Lambda
        LambdaExample l = () -> System.out.println("Lambda executed");
        l.execute();

        // CASE 8: indirect implementation via inheritance
        I obj = new Child();
        obj.display();

        // CASE 1-2-4: functional interface basic usage
        B b = () -> System.out.println("B show");
        b.show();

        C c = () -> System.out.println("C show");
        c.show();
        c.test();

        E e = () -> System.out.println("E show");
        e.show();

        // CASE 5: multiple inheritance same method
        F f = () -> System.out.println("F show");
        f.show();

        // CASE 7: Object methods still callable
        H h = () -> System.out.println("H run");
        h.run();
        System.out.println(h.toString());
    }
}

// ===============================
// FUNCTIONAL INTERFACE COMPLETE CASES
// ===============================

@FunctionalInterface
interface A {
    void show();
}

/*
CASE 1:
Functional interface extends another functional interface
-> still functional (only 1 abstract method)
*/
@FunctionalInterface
interface B extends A {
}

/*
CASE 2:
Extends functional interface + adds default method
-> still functional (default methods don't count)
*/
@FunctionalInterface
interface C extends A {
    default void test() {
        System.out.println("default method");
    }
}

/*
CASE 3:
Extends functional interface + adds NEW abstract method
-> NOT functional (2 abstract methods)
*/
// @FunctionalInterface
// interface D extends A {
//     void print(); // ERROR: not functional
// }

/*
CASE 4:
Same method redeclared (still 1 abstract method)
*/
@FunctionalInterface
interface E extends A {
    void show(); // same signature → still 1 abstract method
}

/*
CASE 5:
Multiple interfaces with SAME method signature
-> still functional
*/
interface X {
    void show();
}

interface Y {
    void show();
}

@FunctionalInterface
interface F extends X, Y {
}

/*
CASE 6:
Multiple interfaces with DIFFERENT methods
-> NOT functional
*/
// interface P {
//     void show();
// }
//
// interface Q {
//     void print();
// }
//
// @FunctionalInterface
// interface G extends P, Q {
// } // ERROR

/*
CASE 7:
Object methods in functional interface
-> NOT counted as abstract methods
*/
@FunctionalInterface
interface H {
    void run();

    // These are ignored for functional interface counting
    boolean equals(Object obj);
    String toString();
    int hashCode();
}

/*
CASE 8:
Parent class provides implementation (indirect implementation)
*/
interface I {
    void display();
}

class Parent {
    public void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent implements I {
    // No need to implement display()
}

/*
CASE 9:
Lambda usage
*/
@FunctionalInterface
interface LambdaExample {
    void execute();
}
