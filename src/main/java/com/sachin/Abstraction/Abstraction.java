package com.sachin.Abstraction;

interface Animal{
    int speed = 20; //by default public + static + final in interfaces
//    void Animal(); //cannot have constructor in the interfaces

    void makeSound();
    void color();

    //    default void makeSound(){
//
//    }


}
class check{
     final int a = 20;
     void method1(){
         System.out.println("");
     }
}

abstract class AbstractClass{
    private final int a ;

    AbstractClass(){
        this.a = 2;
    }

    abstract void meth1();

}


public class Abstraction extends check implements Animal{
   static int avar;

    public Abstraction(int avar) { // The final fields are mandatory to be initialized before the constructor ends.
        // Either we can initialize with declaration, or we can initialize some value through constructor as we have done here.
        // Remember the main purpose of the constructor was always to initialize states of the class and hence prepare the class for execution.
        //One more nuance concept, that as we cannot use Constructor in Interfaces because there is no need of the instance creation, so no constructor needed,
        //and interface always have there fields public static final declared by default, therefore, now in this situation, we initalize at the same inline with state declaration in interfaces.
        this.avar = avar; //Here the 'this' means the Object at runtime, but the variable avar cannot be there in the object because
        // its already declared static means the variable will not live in the object, basically its ambiguity full.
        // But the catch is, compiler lets it pass, because it checks that, 'this' indirectly is of type className(Abstraction) here so it understands our intent. So that is why
        //it let us pass with a warning. As the standard practice for 'statics' is using the ClassName.state or ClassName.method();
    }

   void staticMethod(){
        System.out.println(this.avar);
        avar = 2;
    }



    void printParentStates(){
//        System.out.println(a++); //not allowed due to final

    }

    @Override
    public void makeSound(){
        System.out.println(speed);
    }

    @Override
    public void color(){



    }



    static void main(String [] args) {
        Abstraction a = new Abstraction(2);
                a.makeSound();

    }

}


//Interface:
/*
* Interface mein state (variables) aur behavior (methods) ke rules logic ke saath samjhte hain (Hinglish style mein):

1. Interface State Rules (The Variables)
Interface ke andar variables hamesha public static final hote hain, chahe aap likho ya na likho.

Rule: Inhe declare karte hi initialize karna compulsory hai.

Reason: Kyunki interface ka Constructor nahi hota. Agar aap initialize nahi karoge, toh final keyword ki wajah se wo default value (0 ya null) par freeze ho jayega, jo bilkul bekar hai.

Access Rule: Hamesha public hote hain taaki "Stranger" classes (Client Code) bhi values dekh sakein. protected nahi ho sakta kyunki interface "Family Business" nahi, "Public Service" hai.

2. Interface Behavior Rules (The Methods)
Methods ke saath Java ne version-wise rules change kiye hain:

Abstract Methods (Default): Hamesha public abstract hote hain. Inka kaam sirf ye batana hai ki "Kya karna hai" (What to do), par "Kaise karna hai" (How to do) ye Child Class decide karegi.

Default Methods (Java 8+): Inme aap body { ... } likh sakte ho. Ye isliye laye gaye taaki purane interfaces mein naye features add sakein bina saari implementation classes ko break kiye.

Static Methods (Java 8+): Ye utility functions ki tarah hote hain. Inhe call karne ke liye object ki zaroorat nahi padti.

Private Methods (Java 9+): Ye sirf interface ke andar ki default methods ki help karne ke liye hote hain. Bahar wala koi inhe nahi dekh sakta.

3. Core Reasoning Checklist (Why Interface?)
4. Real-Life Example (JFS Context)
Jab aap Spring Boot padhoge, tab aap Repository interfaces use karoge:

Final Summary in one line:

Interface ek Public User Manual hai jisme rules (final) aur instructions (abstract methods) sabke liye open (public) hote hain.*/