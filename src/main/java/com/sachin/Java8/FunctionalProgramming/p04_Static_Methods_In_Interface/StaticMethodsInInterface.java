package com.sachin.Java8.FunctionalProgramming.p04_Static_Methods_In_Interface;

public class StaticMethodsInInterface {
    static void main() {
        AbstractsImpl2 a = new AbstractsImpl2();
        AbstractsImpl2 a2 = new AbstractsImpl2();

        a.display();
        a2.display();

    // AbstractsImpl2.show();  // Not allowed if show() is declared in an interface,
    // the implementing child class or interface do not have right to call on its name to any static parent interface method.
    // But in the below case this is possible in between the classes.

      AbstractsImpl2.sendMessage();
    // In classes also, while static fields or methods are not truly inherited—they belong to the class and are accessed using the class name.
    // But can also be accessed using child class name, which implicitly calls the Parentclass.staticMethod()

    }
}


interface Abstract3 {

    static void show() {
        System.out.println("show");
    }

}

interface Abstract4 {
    static void show() {
        System.out.println("Don't show");
    }
}

class Message {
    static void sendMessage() {
        System.out.println("Hey what is up there?");
    }
}

class AbstractsImpl2 extends Message implements Abstract3, Abstract4 { //Identify this, this is Multiple Inheritance. Now here in this case, an ambiguity comes,that is which show() version to call
    
    public void display() {
        Abstract3.show(); // to call Abstract2 interface version
//        or
        Abstract4.show(); // to call Abstract1 interface version

    }

}

