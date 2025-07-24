package AdvanceJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApisExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Param", "Yakin", "Dharmishtha", "Rutika", "Priyanka", "Tej");

		// I want to filter this names to another list where first character is P
		// After that I want to sort this name
		// I want to print this name
//
//		List<String> filteredNames = new ArrayList<>();
//		for (String name : names) {
//			if (name.startsWith("P")) {
//				filteredNames.add(name);
//			}
//		}
//		System.out.println("Filtered Names: " + filteredNames);
//		Collections.sort(filteredNames);
//		for (String name : filteredNames) {
//			System.out.println(name);
//		}

		// I want to filter this names to another list where first character is P ->
		// filter
		// After that I want to sort this name -> sorted
		// I want to print this name -> forEach -> System.out.println
//		names.stream().filter(name -> name.startsWith("P")).sorted().forEach(name -> System.out.println(name));

		// New Requirement -> Printed all the names should be in lower case -> map
//		List<String> filteredNames = names.stream().filter(name -> name.startsWith("P")).sorted()
//				.collect(Collectors.toList());
//		System.out.println(filteredNames);

		// I want to change my one stream to another stream but model structure would be
		// changed
//		System.out.println(filteredNames.stream().map(name -> name.toLowerCase()).toList());

		/*
		 * List<Integer> list = Arrays.asList(5, 10, 15, 20, 5, 21, 15, 17, 19, 34, 47,
		 * 10, 22, 11); 1 -> Filter Unique Number's from the list 2 -> Filter Even
		 * Number's from this Unique Number List 3 -> Print the Sum and Number of
		 * Elements which is returning from the Above Operations
		 */

		List<Integer> list = Arrays.asList(5, 10, 15, 20, 5, 21, 15, 17, 19, 34, 47, 10, 22, 11);

		List<Integer> distinctNumbers = list.stream().distinct().collect(Collectors.toList());
		System.out.println("Original Numbers: " + list);
		System.out.println("Distinct Numbers: " + distinctNumbers);// [5, 10, 15, 20, 21, 17, 19, 34, 47, 22, 11]

		List<Integer> evenNumbers = distinctNumbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		// Even Number Operation -> [10, 20, 34, 22]
		System.out.println("Even Numbers: " + evenNumbers);

		// Sum: 86
		// Count: 4
		System.out.println("Sum: " + evenNumbers.stream().mapToInt(Integer::intValue).sum());
		System.out.println("Count: " + evenNumbers.stream().count());
	}
}