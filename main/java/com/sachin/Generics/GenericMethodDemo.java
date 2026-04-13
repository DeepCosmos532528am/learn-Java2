package com.sachin.Generics;
//Interview Answer (One-Liner): > "Generic methods allow us to define an algorithm independently of the specific types it operates on,
// ensuring type-safety at compile-time without duplicating code."

/*
*  Ab tak aapne seekha ki Class aur Interface level generics poore "Ghar" (Object) ka niyam (Rule) set karte hain.
*  Lekin Generic Methods thode alag hote hain—ye wo "Special Tools" hain jo bina poori class ko generic banaye, kisi bhi datatype par kaam kar sakte hain.
*  Humare purane logic ke hisaab se: Generic Method ka kaam hota hai Right Side (Value/Action) par dynamic rehna.
*/


//1. Generic Method Ka Structure
//Generic method pehchanne ka sabse bada nishaan ye hai ki uska Return Type se pehle <T> likha hota hai

//basic template
/*
public <T> void show(T data) {
    System.out.println(data);
}
*/


public class GenericMethodDemo {
    static void main() {
     GenericContainer1.displayGenericMethod(2,"");
//     GenericContainer1.displayBoundedMethod("", 2); not allowed now, due to bounded generic type
//     GenericContainer1.displayBoundedMethod(3,4); //not allowed
        GenericContainer1.displayBoundedMethod("Sachin","Sharma");
    }
}
// <T> yahan "Type Parameter" hai jo method ko generic banata hai
class GenericContainer1 {

    public <T> void printArray(T[] elements) {
        for (T element : elements) {
            System.out.println(element);
        }

    }


//Isme "Left vs Right" Kaise Kaam Karta Hai?
//Definition (Left-ish): Jab aap method define karte ho, toh <T> bata raha hai ki "ArrayList kisi bhi type ka data lene ko taiyaar hoon."
//
//Invocation (Right-ish): Jab aap method ko call karte ho (e.g., printArray(stringArray)), toh Java automatically samajh jata hai ki T yahan String hai. Isse Type Inference kehte hain.


//2. Kyun Chahiye Generic Method? (The Problem)
//Maano aapko ek method chahiye jo do cheezon ko swap (badal) de. Agar aap generics use nahi karoge, toh aapko int, String, Double sabke liye alag-alag methods likhne padenge.
//
//Generic Method se ek hi method sabka kaam kar dega:

    public static <T> void displayGenericMethod(T a, T b) {//See the reusability of the generic method, avoiding redundancy of logic and implementing DRY principle,
        // here we can pass any type value, the logic would be same, if generic method would not exist then we would have to create multiple same
        // overloaded methods with exact same logic but diff parameter type, i.e. INTEGER, STRING, DOUBLE etc. , depending on requirement.
        //See the generic type is same that <T>, but we can pass displayGenericMethod("Sachin", 2); see two diff type values, in this case T ki value common wali use karleneg jo dono ko suit kare
        // that is Object type. ise technical language me Type Inference kehte h.

        //The Catch: "Lekin isse Generics ka asli fayda (Type Safety) thoda kam ho jata hai kyunki T ab Object ban chuka hai.
        // Agar humein sakhti (strictness) chahiye, toh humein Bounded Generics use karni chahiye."

        T avalue = a;
        T bvalue = b;

        System.out.println(avalue.getClass() + " " + a);
        System.out.println(bvalue.getClass() + " " + b);
    }

// Diff in class and method level Generics
// Class Level Generic
// -->Poori class ke andar har jagah T use ho sakta hai.
// -->Object banate waqt type batana padta hai (new Box<String>()).
// -->Static methods class-level T ko use nahi kar sakte.

//Method Level Generic
//-->Sirf us specific method ke andar T valid hai.
//-->Method call karte waqt type batane ki zaroorat nahi hoti, automatic detect ho jata hai.
//-->Static methods ko apna alag <T> define karna padta hai.


//4. Static Generic Methods (VVIP Point)
//Aapne notice kiya hoga ki static methods mein hum class ka generic type use nahi kar sakte. Kyun? Kyunki static methods bina object ke chalte hain, aur class-level generic tabhi zinda hota hai jab object banta hai.
//
//Isliye, Static methods ko humesha apna independent Generic Type <T> chahiye hota hai.

    public static <T extends String> void displayBoundedMethod(T data, T data1 ) { //ab dekho yaha bhi same generic type h lekin yaha pe diff type of value nahi kar sakte pass reason is, we are using bounded type generic with String type
        System.out.println(data +" "+ data1);
    }

}

//Three main reasons behind generic methods.

//A. Avoiding Code Duplication (DRY Principle)
//Agar generic method nahi hota, toh aapko printIntArray(int[] a), printStringArray(String[] s), etc. likhna padta. Generic method se ek hi kaam ho gaya.
//
//B. Compile-Time Type Safety
//Object class use karke bhi hum sab kuch pass kar sakte hain, lekin wahan Runtime par ClassCastException aane ka dar rehta hai. Generic method Compile-time par hi error pakad leta hai agar type mismatch ho.
//
//C. Type Inference (The "Right Side" Magic)
//Class-level generics mein humein new Box<String>() likhna padta hai. Lekin Method generics mein humein type batane ki zaroorat nahi padti. Java ka compiler khud hi detect kar leta hai (Inference).

//Agar interviewer puche: "Class Generic aur Method Generic mein asli farq kya hai?"
//Class Generic: "State" (Variables) ko generic banane ke liye hota hai. (Example: Ek Box jo String hold kare).
//Method Generic: "Behavior" (Action) ko generic banane ke liye hota hai. (Example: Ek Utility jo kisi bhi cheez ko sort kare).