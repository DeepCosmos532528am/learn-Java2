package com.sachin.Java8.FunctionalProgramming.p07_Streams_In_Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class demonstrates various Java 8 Stream Collectors.
 *
 * <h3>Collectors Overview:</h3>
 * <ul>
 *   <li><b>toList():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you want to collect stream elements into a List.</li>
 *       <li><b>Why:</b> It is the most common way to get results back from a stream in an ordered collection.</li>
 *     </ul>
 *   </li>
 *   <li><b>toSet():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you want to collect elements into a Set to remove duplicates.</li>
 *       <li><b>Why:</b> Useful when the order doesn't matter and you want unique elements.</li>
 *     </ul>
 *   </li>
 *   <li><b>toMap():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you want to convert stream elements into a Map with specific keys and values.</li>
 *       <li><b>Why:</b> Great for creating lookups or transforming lists into key-value pairs.</li>
 *     </ul>
 *   </li>
 *   <li><b>groupingBy():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you need to classify elements into groups based on a property (like length or category).</li>
 *       <li><b>Why:</b> It automatically creates a Map where the key is the property and the value is a List of matching items.</li>
 *     </ul>
 *   </li>
 *   <li><b>mapping():</b>
 *     <ul>
 *       <li><b>When to use:</b> When used inside another collector (like groupingBy) to transform the elements before collecting them.</li>
 *       <li><b>Why:</b> Allows you to change the type or format of values within your groups (e.g., converting strings to uppercase).</li>
 *     </ul>
 *   </li>
 *   <li><b>partitioningBy():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you want to split elements into exactly two groups: those that match a condition (true) and those that don't (false).</li>
 *       <li><b>Why:</b> Faster and simpler than groupingBy when you only have a true/false condition.</li>
 *     </ul>
 *   </li>
 *   <li><b>joining():</b>
 *     <ul>
 *       <li><b>When to use:</b> When you want to combine stream elements (usually strings) into a single String.</li>
 *       <li><b>Why:</b> Excellent for creating comma-separated strings or formatted output from a list.</li>
 *     </ul>
 *   </li>
 * </ul>
 */
public class StreamCollectorDemo {

static void main() {
	
	List<String> string = List.of("aaaa", "bbb", "cc", "ddddd", "e");
	
	//---------------------------------.toList()-----------------------------------------------------------------------
	List<String> stringsList = string.stream()
			.collect(Collectors.toList());
	System.out.println(stringsList);

	//---------------------------------.toSet()-----------------------------------------------------------------------
	Set<String> stringSet = string.stream()
			.collect(Collectors.toSet());
	
	System.out.println(stringSet);
	
	
	//---------------------------------.toMap()-----------------------------------------------------------------------
	Map<Integer, String> stringMap = string.stream()
			                               .collect(
												   Collectors.toMap(
														   x->x.length(),
														   x->x)
			                               );
	
	System.out.println(stringMap);
	
	
	//---------------------------------.groupingBy()-----------------------------------------------------------------------
	List<String> stringForGrouping = List.of("aaaa", "bbb","tttt", "cc", "ddddd", "ddddd", "e");
	
	Map<Integer, List<String>> stringMapWithGrouping = stringForGrouping.stream()
			                               .collect(
												   Collectors.groupingBy(x->x.length())
			                               );
	
	System.out.println(stringMapWithGrouping);
	
	
	//---------------------------------.groupingBy() With .mapping()-----------------------------------------------------------------------
	
	Map<Integer, List<String>> stringMapWithGroupingAndMapping = stringForGrouping.stream()
			                                                   .collect(
					                                                   Collectors.groupingBy(
																					   x->x.length()
							                                                   ,Collectors.mapping(y->y.toUpperCase(), Collectors.toList()))
			                                                   );
	
	System.out.println(stringMapWithGroupingAndMapping);
	
	//---------------------------------.partitioning()-----------------------------------------------------------------------
	
	Map<Boolean, List<String>> stringMapWithPartitioning = string.stream()
			                               .collect(
												   Collectors.partitioningBy(x->x.length()>3)
			                               );
	
	System.out.println(stringMapWithPartitioning);
	
	//---------------------------------.joining()-----------------------------------------------------------------------
	
	String join = string.stream()
			              .collect(Collectors.joining("-"));
	System.out.println(join);
	
	//OR
	
	String join2 = string.stream()
			              .collect(Collectors.mapping(x->x.toUpperCase(),Collectors.joining( "-")));
	System.out.println(join2);
	
	
	
}

}
