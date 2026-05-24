package com.sachin.FunctionalProgramming;

//interface A { //This is not a functional interface because it has two abstract methods.
//    void sum();
//    void minus();
//}

@FunctionalInterface //The interfaces which just have exact only one abstract method are called functional interface
interface B {
    void greet();
}

@FunctionalInterface
interface B_param{   // Functional interface with the parameterized method.
    void goodMorning(String your_name);
}

//let's see one more parameterized functional interface method
//Annotation is not mandatory
interface Sum{
    int sumTwoNumber(int a, int b);
}

public class Main {
    static void main(String[] args) {
        //We cannot instantiate Interface, below obj creation may look like the object creation of interface, but it's not!
        //Here 'A a' is the reference type of the interface and the new 'A(){...}' is the object creation of the anonymous class that is declared with the help of {...} right below!
        // You may wonder, that no interface implements keyword used, yes it happens implicitly.

//           A a = new A(){ //This is an anonymous class //new A(){...} is nameless, used once, short code class declaration way which is equivalent to creating any separate class, class AImpl implements A{...} which has name, Reusability, more boilerplate
//               @Override
//               public  void sum(){}
//               public void minus(){}
//           };

        B b = () -> { //<- lambda expression, can only be used with the Functional Interface.
            System.out.println("Sachin");
        };
       b.greet();

       B_param bParam =(String yourName) -> System.out.printf("Good Morning %s\n", yourName); //This is how we can use parameterized lambda expression, for parameterized method in functional interface.
        //See it may create some confusion in understanding lambda for the very first time, but let me give you a way to think for it. see the syntax is nothing but the fat arrow function of the JS. And when declaring the lambda expression,  remember it is nothing but the extended Anonymous class declaration for functional interface, nothing else
        //Above written "(String yourName) -> System.out.printf("Good Morning %s", yourName);", simply visualize that this is an overridden method, declared in an anonymous class implicitly

       bParam.goodMorning("Sachin");

       Sum s = (int num1, int num2 ) -> {
           return num2+num1;
       };

       System.out.println(s.sumTwoNumber(1,2));




    }
}


