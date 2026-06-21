package com.sachin.Java8.FunctionalProgramming.p03_Default_Methods_In_Interface;

public class DefaultMethodsInInterface {
    static void main() {



        Abstract1 a1 = new AbstractsImpl();
        a1.show();
        Abstract2 a2 = new AbstractsImpl();
        a1.show();

        AbstractsImpl a3 = new AbstractsImpl();
        a3.show();
        a3.display();



    }
}

interface Abstract1{

    default void show()                       // This default method in java is available since java 8, but with java not only default, but static also available in since java 8. And from java 9 private can also be declared.
                                             //    Let's get a bit off-track to private methods from the default methods understanding in this file, private are used to define the helper logic in the private to interface only. To which the interface's default and static method can use to avoid bulky default logic and redundancy to write them again and again. by defining
                                             //    the common logic private to the interface to which the default and static methods can use
                                             // as 'default' methods can be overridden specific to instance(class), and later can be accessed on the instance or obj only by 'obj.methodName()' so they kind of shows instance level behavior. That is why in the case of defaults we use non-static private helper methods
                                             // due to the opposite behavior with the static implementation instead of default in the interface we use private static there as no non static methods or fields can be referenced from the static context.
                                             // But remember private is a Java 9 onwards feature
    {
        System.out.println("show");
    }

}

interface Abstract2{
    default void show(){
        System.out.println("Don't show");
    }
}

class AbstractsImpl implements Abstract1, Abstract2{ //Identify this, this is Multiple Inheritance. Now here in this case, an ambiguity comes,that is which show() version to call

    public void display() {
        Abstract2.super.show(); // to call Abstract2 interface version
//        or
        Abstract1.super.show(); // to call Abstract1 interface version

    }

    @Override
    public void show(){
        System.out.println("showing...");
    }


}