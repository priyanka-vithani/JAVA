package AdvanceJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Param", "Yakin", "Dharmishtha", "Rutika", "Priyanka", "Tej");

//		names.forEach(name -> System.out.println(name));

		// I want to use method reference
		// On whichever method you're trying to use method reference should only accept
		// only single argument
		// From wherever you're trying to use method reference, that function should
		// also produce single argument only
//		names.forEach(System.out::println);

		names.stream().map(String::toUpperCase).forEach(System.out::println);

		Function<String, Integer> strToInt = Integer::parseInt; // By using Method Reference
		Function<String, Integer> strToInt2 = num -> Integer.parseInt(num); // By using Lambda Functions
		// Integer::parseInt -> (num) -> Integer.parseInt(num);
		System.out.println(strToInt.apply("100") + strToInt.apply("200")); // Number 100
		// 100 + 200 -> 300 -> Integer
		// 100 + 200 -> 100200 -> String
	}
}