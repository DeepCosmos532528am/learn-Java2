package com.sachin.Java8.FunctionalProgramming.p01_Lambda_Expressions;



/**
 * <h2>Difference Between Anonymous Inner Class and Lambda Expressions</h2>
 * * <p>
 * This class demonstrates the behavioral differences between Anonymous Inner Classes
 * and Lambda Expressions in Java 8, specifically focusing on:
 * <ul>
 * <li><b>Variable Scope & Capturing:</b> (Effectively Final concept)</li>
 * <li><b>The 'this' Keyword Behavior:</b> (Lexical scoping vs. Block scoping)</li>
 * <li><b>Compilation Artifacts:</b> (.class files generation)</li>
 * </ul>
 * </p>
 * * @author Sachin
 * @version 1.0
 */
public class AnonymousClassVsLambdaFunction {
    public static void main(String[] args) {
        Mathematics maths = new Mathematics();
        maths.doSomething();
    }
}
/**
 * <h2>Key Differences Breakdown: Anonymous Inner Class vs. Lambda Expression</h2>
 *
 * <h3>1. Effectively Final Concept</h3>
 * <p>
 * <b>Java 8 Legacy:</b> Before Java 8, any local variable accessed inside an inner class
 * had to be explicitly declared as {@code final}.
 * <br>
 * <b>Effectively Final Rule:</b> In Java 8+, if you do not write the {@code final} keyword
 * but never modify the variable's value after declaration, the compiler automatically
 * treats it as <i>Effectively Final</i>.
 * <br>
 * <b>Restriction:</b> Neither Lambdas nor Anonymous Inner Classes can modify outer local
 * variables (e.g., {@code x++} or {@code x = 5} will throw a compilation error).
 * They are strictly read-only.
 * </p>
 *
 * <h3>2. Variable Scoping & The 'this' Keyword</h3>
 * <p>
 * <b>Anonymous Inner Class (Block Scoping):</b> It introduces a completely new scope.
 * Using {@code this} inside an anonymous class refers strictly to the anonymous class
 * instance itself. To access the outer parent class instance, you must use explicit
 * qualification: {@code OuterClass.this.variable}.
 * <br>
 * <b>Lambda Expression (Lexical Scoping):</b> It does not introduce a new scope.
 * A lambda expression is lexically scoped, meaning {@code this} inside a lambda refers
 * directly to the enclosing outer class instance where the lambda is defined.
 * </p>
 *
 * <h3>3. Memory & Performance (Compilation Artifacts)</h3>
 * <p>
 * <b>Anonymous Inner Class:</b> The compiler generates a physical separate bytecode file
 * (e.g., {@code Mathematics$1.class}) for every anonymous class, increasing disk footprint
 * and class-loading overhead.
 * <br>
 * <b>Lambda Expression:</b> No separate {@code .class} file is generated. Instead, Java
 * uses the JVM's {@code invokedynamic} instruction to dynamically bootstrap the lambda
 * at runtime, making it highly memory-efficient and performant.
 * </p>
 *
 * <h3>4. Usage Guidelines (When to use what)</h3>
 * <table border="1" cellpadding="5">
 *   <tr>
 *     <th>Scenario</th>
 *     <th>Recommended Approach</th>
 *     <th>Reasoning / Justification</th>
 *   </tr>
 *   <tr>
 *     <td>Functional Interface (Single Abstract Method)</td>
 *     <td><b>Lambda Expression</b></td>
 *     <td>Provides clean, concise, readable, and highly optimized bytecode.</td>
 *   </tr>
 *   <tr>
 *     <td>Interfaces with multiple abstract methods</td>
 *     <td><b>Anonymous Inner Class</b></td>
 *     <td>Lambdas are syntactically limited to Single Abstract Method (SAM) interfaces.</td>
 *   </tr>
 *   <tr>
 *     <td>Maintaining internal state (Fields/Instance variables)</td>
 *     <td><b>Anonymous Inner Class</b></td>
 *     <td>Lambdas cannot declare their own instance variables or maintain independent state.</td>
 *   </tr>
 *   <tr>
 *     <td>Self-referencing via the {@code this} keyword</td>
 *     <td><b>Anonymous Inner Class</b></td>
 *     <td>Inside a lambda, {@code this} will always point to the parent class, never the lambda itself.</td>
 *   </tr>
 * </table>
 *
 * @author Sachin
 * @since Java 8
 */


class Mathematics {
    // Instance variable: Ispe 'effectively final' ka rule apply nahi hota.
    // Ise dono change bhi kar sakte hain aur access bhi.
    int b = 3;

    public void doSomething() {
        // Local variable: Ispe 'effectively final' ka rule apply hota hai.
        // effectively final matlab: jisko declare karne ke baad value change na ki gayi ho.
        int x = 2;

        // ---------------------------------------------------------------------
        // 1. LAMBDA EXPRESSION APPROACH
        // ---------------------------------------------------------------------
        IMiniOperations lambdaOps = (a) -> { //this interface imported from another file.
            // x = 5; // COMPILER ERROR: Lambda se local variable modify nahi ho sakta.
            b = 10;   // ALLOWED: Instance variables ko modify kiya ja sakta hai.

            // 'this' yahan Mathematics class ko refer kar raha hai (Lexical Scoping).
            System.out.println("Lambda 'this': " + this.getClass().getSimpleName());

            return a + b + x; // x is read-only (effectively final)
        };

        // ---------------------------------------------------------------------
        // 2. ANONYMOUS INNER CLASS APPROACH
        // ---------------------------------------------------------------------
        IMiniOperations anonymousOps = new IMiniOperations() {
            int localInstanceVar = 50;

            @Override
            public int operation(int a) {
                // x++; // COMPILER ERROR: Anonymous class me bhi local variable modify nahi ho sakta (Must be effectively final).
                b = 20;  // ALLOWED: Instance variables are fine.

                // 'this' yahan khud is Anonymous class ko refer kar raha hai, Mathematics ko nahi!
                System.out.println("Anonymous 'this': " + this.getClass().getName());

                return a + b + x + localInstanceVar;
            }
        };

        // execution
        lambdaOps.operation(5);
        anonymousOps.operation(5);
    }

}

