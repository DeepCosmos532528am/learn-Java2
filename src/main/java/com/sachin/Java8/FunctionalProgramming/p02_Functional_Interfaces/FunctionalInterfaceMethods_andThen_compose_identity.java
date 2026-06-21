package com.sachin.Java8.FunctionalProgramming.p02_Functional_Interfaces;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <h1>Topic: Java 8 Functional Interfaces Core Methods</h1>
 *
 * <p>This class serves as an interview preparation guide for understanding 
 * how to use, chain, and compose Java 8 Functional Interfaces.</p>
 *
 * <h3>Key Interview Takeaways:</h3>
 * <ul>
 *   <li><b>Consumer&lt;T&gt;:</b> Represents an operation that accepts a single input argument and returns no result (void). Its abstract method is {@code accept(T t)}.</li>
 *   <li><b>Function&lt;T, R&gt;:</b> Represents a function that accepts one argument and produces a result. Its abstract method is {@code apply(T t)}.</li>
 *   <li><b>Chaining:</b> {@code andThen()} runs left-to-right, while {@code compose()} runs right-to-left.</li>
 * </ul>
 *
 * @author Sachin
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 */
public class FunctionalInterfaceMethods_andThen_compose_identity {
    /**
     * Execution point demonstrating Consumer chaining, Function composition,
     * and the Identity function.
     */
    static void main() {

        // ==========================================
        // 1. CONSUMER INTERFACE & .andThen()
        // ==========================================

        Consumer<Integer> func = System.out::println;
        Consumer<Integer> func2 = (a) -> System.out.println(a);

        // .andThen() with Consumer: Executes the first consumer,
        // then forwards the EXACT SAME raw input value to the next consumer.
        // Execution Flow: func.accept(2) [Prints 2] -> func2.accept(2) [Prints 2]
        func.andThen(func2).accept(2);


        // ==========================================
        // 2. FUNCTION INTERFACE: .andThen() vs .compose()
        // ==========================================

        Function<Integer, Integer> func3 = (a) -> {
            return 3 * a; // Step: Multiply by 3
        };

        Function<Integer, Integer> func4 = (a) -> {
            return a + 10; // Step: Add 10
        };

        // .andThen() operates Left-to-Right: Current function executes first,
        // its output is passed as input to the next function.
        // Execution: func3 runs (3*3 = 9) -> 9 goes to func4 (9+10 = 19)
        System.out.println(func3.andThen(func4).apply(3));

        // Execution: func4 runs (4+10 = 14) -> 14 goes to func3 (14*3 = 42)
        System.out.println(func4.andThen(func3).apply(4));

        // .compose() operates Right-to-Left: The parameter function executes first,
        // its output is passed as input to the calling function.
        // Execution: Argument func4 runs first (5+10 = 15) -> 15 goes to caller func3 (15*3 = 45)
        System.out.println(func3.compose(func4).apply(5));


        // ==========================================
        // 3. IDENTITY FUNCTION
        // ==========================================

        // Function.identity() always returns its exact input argument unmodified (f(x) = x).
        // It acts as a clean replacement for the manual lambda expression: x -> x
        // Real-world use: Used in Streams (Collectors.toMap() / groupingBy()) to map an element to itself.
        System.out.println(Function.identity().apply(6)); // Input 6 -> Output 6

        Consumer<String> func5 = (a) -> Function.identity().apply(a);

    }

}