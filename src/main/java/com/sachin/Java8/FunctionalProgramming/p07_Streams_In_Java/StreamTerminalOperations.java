package com.sachin.Java8.FunctionalProgramming.p07_Streams_In_Java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Terminal operations consume the stream, trigger execution of the pipeline, and produce a non-stream result.
 *
 * <h2>1. Collecting Results</h2>
 * <ul>
 *   <li>{@code toList()} — Collects stream elements into an unmodifiable {@link java.util.List} (Java 16+).<br>
 *       {@code List<String> list = stream.toList();}</li>
 *   <li>{@code collect(Collector)} — Performs a mutable reduction using a {@link java.util.stream.Collector}.<br>
 *       {@code List<String> list = stream.collect(Collectors.toList());}</li>
 * </ul>
 *
 * <h2>2. Reducing</h2>
 * <ul>
 *   <li>{@code reduce(BinaryOperator)} — Reduces elements to a single value using an associative accumulation function.<br>
 *       {@code Optional<Integer> sum = stream.reduce((a, b) -> a + b);}</li>
 *   <li>{@code sum()} — Calculates the arithmetic sum in specialized primitive streams ({@code IntStream}, {@code LongStream}, {@code DoubleStream}).<br>
 *       {@code int total = intStream.sum();}</li>
 *   <li>{@code max(Comparator)} — Finds the maximum element according to the specified comparator.<br>
 *       {@code Optional<T> max = stream.max(Comparator.naturalOrder());}</li>
 *   <li>{@code min(Comparator)} — Finds the minimum element according to the specified comparator.<br>
 *       {@code Optional<T> min = stream.min(Comparator.naturalOrder());}</li>
 *   <li>{@code average()} — Calculates the arithmetic mean in primitive streams, returning an {@link java.util.OptionalDouble}.<br>
 *       {@code OptionalDouble avg = intStream.average();}</li>
 *   <li>{@code count()} — Returns the total count of elements as a {@code long}.<br>
 *       {@code long total = stream.count();}</li>
 * </ul>
 *
 * <h2>3. Searching / Matching</h2>
 * <ul>
 *   <li>{@code findFirst()} — Returns an {@link java.util.Optional} containing the first element, respecting encounter order.<br>
 *       {@code Optional<T> first = stream.findFirst();}</li>
 *   <li>{@code findAny()} — Returns an {@link java.util.Optional} containing any element (optimized for parallel streams).<br>
 *       {@code Optional<T> any = stream.findAny();}</li>
 *   <li>{@code anyMatch(Predicate)} — Checks if at least one element satisfies the predicate (short-circuiting).<br>
 *       {@code boolean match = stream.anyMatch(e -> e.isValid());}</li>
 *   <li>{@code allMatch(Predicate)} — Checks if all elements satisfy the predicate (short-circuiting).<br>
 *       {@code boolean match = stream.allMatch(e -> e.isValid());}</li>
 *   <li>{@code noneMatch(Predicate)} — Checks if no elements satisfy the predicate (short-circuiting).<br>
 *       {@code boolean match = stream.noneMatch(e -> e.isEmpty());}</li>
 * </ul>
 *
 * <h2>4. Iterations</h2>
 * <ul>
 *   <li>{@code forEach(Consumer)} — Performs an action for each element (order non-deterministic in parallel streams).<br>
 *       {@code stream.forEach(System.out::println);}</li>
 *   <li>{@code forEachOrdered(Consumer)} — Performs an action for each element strictly preserving encounter order.<br>
 *       {@code stream.parallel().forEachOrdered(System.out::println);}</li>
 * </ul>
 *
 * @see java.util.stream.Stream
 */

public class StreamTerminalOperations {
public static void main(String[] args) {
	
	DemoOfForEach("1. Demo of ForEach terminal operation to loop on collection quickly", null);
	
	DemoOftoList("2. Demo of toList operation", null);
	
	DemoOfCollect("3. Demo of collect", null);
	
	DemoOfReduce("4. Demo of reduce operation", null);
	
	DemoOfCount("5. Demo of count operation", null);
	
	DemoOfFindFirst("6. Demo of findFirst operation", null);
	
	DemoOfAnyMatch("7. Demo of anyMatch operation", null);
	
	DemoOfAllMatch("8. Demo of allMatch operation", null);
	
	DemoOfNoneMatch("9. Demo of noneMatch operation", null);
	
	DemoOfSum("10. Demo of Sum operation", "Specifically can only be performed on the primitive streams but not on regular stream");
	
	DemoOfMax("9. Demo of Max operation", "Similarly this also can only be performed on the primitive streams but not on regular stream");
	
	DemoOfAverage("9. Demo of Average operation", "Same for this");
	
	
}


static void DemoOfForEach(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 4, 9, 15, 11, 28, 36, 13, 34));
	
	list.stream()
			.map(n -> n + 1)
			.forEach(System.out::println);
//			.forEachOrdered(System.out::println); //It would also work same as the .forEach(), .forEachOrdered() seems useful when using parallel-stream
}

static void DemoOftoList(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 4, 9, 15, 11, 28, 36, 13, 34));
	list.add(10);
	List<Integer> listt = list.stream()
			                      .map(n -> n + 1)
			                      .toList();
	System.out.println(listt);

//	but this list become immutable now
//	listt.add(100); //No compiler time error, but at runtime it would not work
}

static void DemoOfCollect(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 4, 9, 15, 11, 28, 36, 13, 34));
	
	Set<Integer> listt = list.stream()
			                     .map(n -> n + 1)
			                     .collect(Collectors.toSet());
	System.out.println(listt);
	
	//OR
	
	String[] sa = new String[]{"Apple", "Mango", "Banana", "Grapes"};
	
	List<String> fruits = Stream.of(sa)
			                      .collect(Collectors.toList());
	
	System.out.println(fruits);
	
}

static void DemoOfReduce(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
	
	Optional<Integer> reducedNumber = list.stream()
			                                  .reduce((a, b) -> a + b);

//	Alternative to the Optional type, we can simply use a primitive type but it may result in null pointer exception when no any single values there. so identity is given to ensure a non null value is always there.
	
	int listt = list.stream()
			            .reduce(0, (a, b) -> a + b); //Simply put the identity here, it becomes the first value represented by a
//			            .reduce(1,(a,b)->a*b); //Similarly if its multiplication then put 1 as 0 will make whole expression 0
	
	System.out.println(reducedNumber.get());
	
	
}

static void DemoOfCount(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
	
	Long countedNumber = list.stream()
			                     .count();
	
	System.out.println(countedNumber);
	
	
}

static void DemoOfFindFirst(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 8));
	
	Optional<Integer> firstElementSatisfyingFilterCondition = list.stream()
			                                                          .filter(x -> x > 7)
			                                                          .findFirst();
//	                             .findAny(); //behaves similar to the findFirst here, but real use case can be seen in parallel streams
	System.out.println(firstElementSatisfyingFilterCondition.get());
	
}

static void DemoOfAnyMatch(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
	
	boolean doesAnyElementSatisfyTheCondition = list.stream()
			                                            .anyMatch(x -> x > 7);
	
	System.out.println(doesAnyElementSatisfyTheCondition);
	
}

static void DemoOfAllMatch(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(8, 9, 11, 10));
	
	boolean doesAllElementSatisfyTheCondition = list.stream()
			                                            .allMatch(x -> x > 7);
	
	System.out.println(doesAllElementSatisfyTheCondition);
	
}

static void DemoOfNoneMatch(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(8, 5, 1, 4));
	
	boolean doesNoElementSatisfyTheCondition = list.stream()
			                                           .noneMatch(x -> x > 7);
	
	System.out.println(doesNoElementSatisfyTheCondition);
	
}

static void DemoOfSum(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(8, 5, 1, 4));
	
	int sum = list.stream()
			          .filter(x -> x > 4)
			          .mapToInt(x -> x)
			          .sum();
	
	System.out.println(sum);
	
}

static void DemoOfMax(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(8, 5, 1, 4));
	
	OptionalInt maximum = list.stream() // OptionalInt is a container object which may or may not contain an int value. 
	                                    // It is used here instead of a simple 'int' because the stream might be empty, and 'int' cannot represent a 'null' or 'absent' value.
	                                    // It is preferred over 'Optional<Integer>' to avoid the performance overhead of boxing (converting int to Integer).
			                      .mapToInt(x -> x)
			                      .max();
	
	System.out.println(maximum);
	
}

static void DemoOfAverage(final String whatItIs, final String description) {
	System.out.println(description == null ? whatItIs : whatItIs + "\n" + description);
	
	List<Integer> list = new ArrayList<>(List.of(8, 5, 1, 4));
	
	OptionalDouble average= list.stream() // OptionalDouble is a container object which may or may not contain a double value.
	                                      // It is used here because an average cannot be calculated for an empty stream.
	                                      // Like OptionalInt, it avoids the boxing overhead of 'Optional<Double>'.
			                      .mapToInt(x -> x)
			                      .average();
	
	System.out.println(average);
	

}
}
