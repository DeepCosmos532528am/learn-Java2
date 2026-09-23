package com.sachin.Java8.FunctionalProgramming.p07_Streams_In_Java;
//Mostly used intermediate function

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 filter()
 map()
 mapToInt()
 mapToDouble()
 flatMap()
 sorted()[Stateful]
 limit()
 skip()
 distinct()[Stateful]
 peek()
 */
public class StreamIntermediateOperations {
static void main() {
	
	DemoOfFilterAndMap("See the Demo of Filter and Map", null);
	
	DemoOfFlatMap("See the Demo of FlatMap", null);
	
	DemoOfSorted("See the Demo of Sorted", null);
	
	DemoOfDistinct("See the Demo of Distinct", null);
	
	DemoOfLimit("See the Demo of Limit", """
			This method is useful when we want limit the stream processing upto certain limit.
			for e.g. I want to limit the inifinite stream for upto 10 times only.""");
	
	DemoOfSkip("See the Demo of Skip", """
			Skip is basically the opposite of limit()""");
	
	DemoOfPeek("See the Demo of the peek method", """
			For Debugging purpose/TO look inside the Stream pipeline to see the status of value at specific point of operation.""");
	
}

static void DemoOfFilterAndMap(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	List<Integer> list = new ArrayList<>(List.of(1,2,4,9,15,11, 28,36,13,34));
	
	list.stream()
			.filter(n->n>10)
			.filter(n->n%4==0)
			.map(n->n*n)
			.forEach(System.out::println);
}

static void DemoOfFlatMap(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	//List of List of String(Fruit)
	List<List<String>> fruits = new ArrayList<>(
			List.of(
					List.of("Apple", "Cherry", "Strawberry"),
					List.of("Orange", "Mango","Banana"),
					List.of("Guava", "Pears", "Grapes"))
        	);

	fruits.stream().map(s->s.stream()).forEach(System.out::println); //This way might look like right way! but its not. Would throw exception, because this is not the right way
//	to traverse the elements in the list of lists.
	
	fruits.stream().flatMap(s->s.stream()).map(s->s.toUpperCase()).forEach(System.out::println); //Right way, it flats the nested elements
	
    }

static void DemoOfSorted(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	List<Integer> list = new ArrayList<>(List.of(1,2,4,9,15,11, 28,36,13,34));
	
	list.stream()
			.filter(n->n>10)
			.map(n->n*n)
			.sorted((x,y)->y-x) //It's stateful as it needs all the elements first then only sorting can be applied, sorting any single element is not logical
			.forEach(System.out::println);
	//[By default sorted have ascending behaviour]
}

static void DemoOfDistinct(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	List<Integer> list = new ArrayList<>(List.of(1,2,4,13,9,1,15,11,1,28,9,36,13,36,34));
	
	list.stream()
			.filter(n->n>10)
//			.map(n->n*n)
			.distinct() //It's also stateful as sorted it needs all the elements first then only distinct can be applied, just having data of any single element cannot determine if its distinct or same.
			.forEach(System.out::println);  //Output: 13 15 11 28 36 34
	//[By default sorted have ascending behaviour]
}

static void DemoOfLimit(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	
	Stream.iterate(1,a->a+1)
			.limit(10)
			.forEach(System.out::println);
	
	
	
}

static void DemoOfSkip(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	
	Stream.iterate(1,a->a+1)
			.skip(10)
			.limit(10)
			.forEach(System.out::println);
	
//	OR
	
		Stream.iterate(1,a->a+1)
			.limit(10)
			.skip(10)
			.forEach(System.out::println);
	
	
	
}

static void DemoOfPeek(final String whatItIs,final String description){
	System.out.println(description == null?whatItIs:whatItIs+"\n"+description);
	
	//peek is generally used for debugging only, otherwise at production no any use.
	
	Stream.iterate(1,a->a+1)
			.peek(n->System.out.println(n))
			.skip(10)
			.limit(10)
			.forEach(System.out::println);
	
//	OR
	
		Stream.iterate(1,a->a+1)
			.peek(System.out::println)
			.limit(10)
			.skip(2)
			.forEach(System.out::println);
		
}

public static void mapToIntOrDoubleOrLong(final String whatItIs, final String description) {
	// Keeps your exact header printing logic intact
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = List.of(1, 2, 3, 4, 5);
	// peek is generally used for debugging only, otherwise at production no any use.
	
	System.out.println("--- 1. Fixed List Stream Example ---");
	// FIXED: Using mapToInt() correctly to unbox elements into primitive math functions
	int sumOfList = list.stream()
			                .mapToInt(x -> x) // Converts to IntStream instance
			                .sum();           // Evaluates the primitive array
	System.out.println("Sum of your original list elements: " + sumOfList);
	
	System.out.println("\n--- 2. Standalone IntStream Example ---");
	// This runs independently, skipping 10 values, tracking up to 20, and outputting 11-20
	IntStream.iterate(1, a -> a + 1)
			.peek(n -> System.out.println("Generated: " + n))
			.skip(10)
			.limit(10)
			.forEach(n -> System.out.println("Reached Terminal: " + n));
	
	System.out.println("\n--- 3. OR Object Stream Example ---");
	// Generates 10 numbers, discards the first 2, and prints the survivors (3-10)
	Stream.iterate(1, a -> a + 1)
			.peek(n -> System.out.println("Generated Obj: " + n))
			.limit(10)
			.skip(2)
			.forEach(n -> System.out.println("Reached Terminal Obj: " + n));
}

public static void main(String[] args) {
	// Quick test runner to execute your method structure
	mapToIntOrDoubleOrLong("Java Primitive Streams Demo", "Comparing object pipelines with primitive creation patterns.");
}

}
