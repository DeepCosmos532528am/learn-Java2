package com.sachin.polymorphism;

//Compile time poly. ya method overloading inheritance me, yani Parent -Child me ho sakta h.
//aur same class me bhi. Ek method ko parent me aur ek ko child me rakhke overlaod kar sakte h

//Conditions:
/*Same Name: Method ka naam ekdum same hona chahiye.

Different Parameters (Must): Ye sabse zaroori condition hai. Parameters niche diye gaye tareekon se alag hone chahiye:

Sankhya (Number): add(int a) vs add(int a, int b)

Type: print(int a) vs print(String a)

Sequence: map(int a, String b) vs map(String b, int a)

Return Type: Sirf return type badalne se overloading nahi hoti. Agar parameters alag hain, toh return type kuch bhi ho sakta hai.

Access Modifier: Isse koi farq nahi padta, tum public se private bhi kar sakte ho.

Class: Ek hi class mein hota hai (ya inherited class mein)*/


//Polymorphism in OOP allows the same method or operation to behave differently based on the context. It is mainly categorized into compile-time polymorphism and run-time polymorphism, each differing in when the method binding occurs.
//
//        Compile-time polymorphism (also called static binding or early binding) happens when the method call is resolved during compilation. This is typically achieved through method overloading, where multiple methods share the same name but differ in parameter lists. Since the compiler knows exactly which method to call, execution is faster but less flexible.
//
//Example – Compile-time Polymorphism (Method Overloading):
//
//
//class MathOps {
//    static int add(int a, int b) {
//        return a + b;
//    }
//    static double add(double a, double b) {
//        return a + b;
//    }
//    public static void main(String[] args) {
//        System.out.println(add(2, 3)); // Calls int version
//        System.out.println(add(2.5, 3.5)); // Calls double version
//    }
//}
//
//Run-time polymorphism (also called dynamic binding/dynamic method dispatch/late binding) occurs when the method call is resolved during program execution.
// This is achieved through method overriding, where a subclass provides its own implementation of a method defined in its superclass.
// The actual method invoked depends on the object type at runtime, making it more flexible but slightly slower.
//
// method overriding strictly inheritance me hi ho sakta h not in same class.
//Overriding = Strictness.
//
//Conditions for it :
//Iska maqsad hota hai Parent ke purane logic ko Child mein naye logic se replace karna.
//Different Classes: Ye hamesha Parent-Child relationship (Inheritance) mein hi hota hai.
//Exact Same Signature: Naam aur parameters (type, number, order) bilkul wahi hone chahiye jo Parent class mein hain.
//Return Type: Ya toh ekdum same ho, ya phir Covariant (Parent ke return type ki subclass) ho.
//Access Modifier: Child class ka modifier Parent se zyada open hona chahiye, kam nahi.
//Example: Agar Parent mein protected hai, toh Child mein protected ya public ho sakta hai, lekin private nahi.
//Private/Static/Final Methods: Inhe override nahi kiya ja sakta.
//private inherit nahi hote.
//static class-level hote hain (Hiding hoti hai, overriding nahi).
//final ko badalne ki permission nahi hoti.

//        Example – Run-time Polymorphism (Method Overriding):

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Reference type is Animal, object type is Dog
        obj.sound(); // Calls Dog's overridden method
    }
}
//
//Key Differences:
//
//Binding Time: Compile-time polymorphism resolves at compile time; run-time polymorphism resolves at execution time.
//
//Technique: Compile-time uses overloading; run-time uses overriding.
//
//        Performance: Compile-time is faster; run-time is slower due to dynamic resolution.
//
//        Inheritance: Not required for compile-time; required for run-time.
//
//        Flexibility: Compile-time is less flexible; run-time is more adaptable to changes.