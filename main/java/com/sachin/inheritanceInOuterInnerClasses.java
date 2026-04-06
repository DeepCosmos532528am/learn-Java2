package com.sachin;

// File: inheritanceInOuterInnerClasses.java

/**
 * Interface with exactly one abstract method.
 * This qualifies it as a Functional Interface, allowing Lambda use.
 */
interface A {
    int ameth(int a, int b);
}

class Demo {
    void demo() {
        System.out.println("Hello From Demo");
    }

    void demo2() {
        System.out.println("Hello From Demo2");
    }

    void outerClass() {
        System.out.println("Sachin Outer");
    }

    /**
     * 1. INNER CLASS WITH INHERITANCE
     * This class is inside Demo AND it extends Demo.
     * It has access to 'outerClass()' because it inherits it from its parent.
     */
    class InnerClass extends Demo {
        void innerClassMeth() {
            System.out.println("This is inner class");
        }

        // If you uncommented this, it would override the parent's method
        // void outerClass(){
        //     System.out.println("Sachin inner");
        // }
    }

    /**
     * 2. REGULAR INNER CLASS
     * Does not extend Demo, but can still call Demo's methods
     * because it exists within the scope of an instance of Demo.
     */
    class InnerClass2 {
        void innerClass2() {
            demo2(); // Accessing outer class method directly
        }
    }
}

public class inheritanceInOuterInnerClasses {
    public static void main(String[] args) {
        System.out.println("Exploring Java Concepts...");

        /**
         * 3. ANONYMOUS INNER CLASS
         * Here we create a "nameless" subclass of Demo on the fly.
         * We are overriding demo() and demo2() for this specific instance 'd' only.
         */
        Demo d = new Demo() {
            @Override
            void demo() {
                System.out.println("Hello from Anonymous Class");
            }

            @Override
            void demo2() {
                System.out.println("Hello From Anonymous Class 2");
            }
        };

        d.demo();
        d.demo2();

        /**
         * 4. LAMBDA EXPRESSION
         * A concise way to implement the Functional Interface 'A'.
         * (parameters) -> { body }
         */
        A a = (int c, int b) -> {
            return c + b;
        };
        System.out.println("Lambda Result (2+3): " + a.ameth(2, 3));

        /**
         * 5. INSTANTIATING AN INNER CLASS
         * Because InnerClass is non-static, it needs an instance of the
         * Outer class (d) to exist. Use: outerInstance.new InnerClass()
         */
        Demo.InnerClass di = d.new InnerClass();
        di.innerClassMeth();

        // This works because InnerClass EXTENDS Demo.
        // It's calling the inherited version of outerClass().
        di.outerClass();

        System.out.println("---");
        d.outerClass(); // Calling it from the original object 'd'

        /**
         * 6. POLYMORPHISM WITH INNER CLASSES
         * Since InnerClass extends Demo, a Demo reference can point to an
         * InnerClass object.
         */
        Demo dd = d.new InnerClass();
        dd.outerClass(); // Prints "Sachin Outer" from the parent Demo class
    }
}