package com.sachin.FunctionalProgramming.inbuilts;

import java.util.function.*;

public class FunctionInterfaceDemo {
    static void main() {
        //Function: Represents a function that accepts one argument and produces a result.
        Function<Integer, Integer> sum = (a) -> 2+a;
        System.out.println(sum.apply(3)); //apply() is the method of this Functional Interface

        //Predicate: Represents a predicate (boolean-valued function) of one argument.

        Predicate<Integer> isEven = num -> num%2 == 0;

        System.out.println(isEven.test(2));
        System.out.println(isEven.test(5));
        //Consumer: Represents an operation that accepts a single input argument and returns no result.
        Consumer<String> printer = System.out::println; //could write normally , name -> System.out.println(name) but, its the shorthand for such cases in Functional interface where the parameter is single is only printed using sout();
        printer.accept("Sachin");

        //Supplier: Represents a supplier of results, taking no arguments but producing a value.
        Supplier<Double> randomSupplier = () -> Math.random(); //Could write Math::random();
        System.out.println(randomSupplier.get());
        //BiFunction: Represents a function that accepts two arguments and produces a result.
        BiFunction<String, Integer, String> bifunction = (name, age) -> "name: "+name+"\nage: "+ age;
        System.out.println(bifunction.apply("Sachin", 21));

        //BiPredicate: Represents a predicate (boolean-valued function) of two arguments.
        BiPredicate<String, Integer> longerThan = (name, len) -> name.length() > len;
        System.out.println(longerThan.test("Sachin", 6));

        //BiConsumer: Represents an operation that accepts two input arguments and returns no result.
        BiConsumer<String, Integer> printDetails = (name, age) ->
                System.out.println(name + " is " + age + " years old.");
        printDetails.accept("Sachin", 20);
    }
}

