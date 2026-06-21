package com.sachin.Java8.FunctionalProgramming;

import java.awt.*;
import java.util.function.*;

public class MethodReferenceOperator {
    static void main() {
//Lets think of a challenge to understand this. we have to find the total 'length of the first name and the last name'

// Old way(through lambdas) -->   FullNameLength in the old way
        BiFunction<String, String, Integer> fullNameLength = (name, name2) -> name.concat(name2).length(); //BiFunction is nothing but it takes 'two input' and produces 'one output'
        /**BiFunction<String, String, Integer> fullNameLength2 = String::concat::length; <-- {@illegalAttempt as discussed above} */

// New way -->

        /**{
            @Remember Before we continue to solve it out. Know that through method references we cannot chain methods like 'String::concat:length'. It would not work out.
            Rather a proper approach is using {@chainingMethods .andThen().apply()} to chain two operations in a specific sequence
         }*/


//        Now finally lets see through method reference:
        BiFunction<String, String, String> concatName = String::concat;
        Function<String,Integer> concatedNameLength = String::length;

        int nameLength = concatName.andThen(concatedNameLength).apply("Sachin", "Sharma");
        System.out.println(nameLength);


/** {@listen No doubt the below program also works. But ignore this code, it got designed in flow by me.., But you dont have to. You kindly refer to the above proper way.}
 *
 {@code

 int nameLength = concatName.andThen(concatedNameLength).andThen((l) -> {
 System.out.println(l);
 return 0;
 }).apply("Sachin", "Sharma");}

 */

        //--------------------------------------------------------------------------------------------------------------


//1. can use it to refer to the static methods of any class just by the syntax : 'ClassName::MethodName'

//        you have seen the println method of System class, its static method. Now Let's see it how to use that method in old way to print string on console through consumer Functional Interface which just take an input but not return anything.
//        Consumer <String> printOnConsole = (s) -> System.out.println(s);

//        But through method reference.
        Consumer <String> printOnConsole2 = System.out::println; //simple as that

        //--------------------------------------------------------------------------------------------------------------


// 2. Method references to instance methods

// First way: Bound instance method reference
// An existing object is already available, and the method will be invoked on that object.

        String s = new String("Hello");

        Supplier<Integer> lengthSupplier = s::length;

// Equivalent lambda:
// () -> s.length()

// -------------------------------------------------------------

// Second way: Unbound instance method reference
// Use ClassName::instanceMethod.
// The first argument of the functional interface becomes the object
// on which the instance method is invoked.

        Function<String, Integer> lengthFunction = String::length;

// Equivalent lambda:
// str -> str.length()
//  means in this way the method is getting called on the input obj itself, but not essentially the method is static

        //--------------------------------------------------------------------------------------------------------------

// 3. Constructor references

// First way (without method reference)
// Create objects using a lambda.

        Supplier<String> stringCreator = () -> new String();

// Equivalent result:
        String str = stringCreator.get();


// -------------------------------------------------------------

// Second way: Constructor reference
// Use ClassName::new.
// Java will invoke the constructor whose signature matches
// the abstract method of the target functional interface.

        Supplier<String> stringCreator2 = String::new;

// Equivalent lambda:
// () -> new String()

        String str2 = stringCreator2.get();


// -------------------------------------------------------------

// Constructor with parameters

        Function<String, StringBuilder> sbCreator = StringBuilder::new;

// Equivalent lambda:
// text -> new StringBuilder(text)

        StringBuilder sb = sbCreator.apply("Hello");


// -------------------------------------------------------------

// Multiple constructor parameters

        BiFunction<Integer, Integer, Rectangle> rectangleCreator = Rectangle::new;

// Equivalent lambda:
// (width, height) -> new Rectangle(width, height)

        Rectangle rect = rectangleCreator.apply(100, 50);



/**
 * {@Remember all these cases
 * // Static method reference
 * ClassName::staticMethod
 *
 * // Bound instance method reference
 * instance::instanceMethod
 *
 * // Unbound instance method reference
 * ClassName::instanceMethod
 *
 * // Constructor reference
 * ClassName::new}*/
    }
}
