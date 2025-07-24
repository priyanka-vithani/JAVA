package AdvanceJava;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> tej = (num) -> num % 2 == 0;
		System.out.println(tej.test(20)); // true
		System.out.println(tej.test(51)); // false

		Predicate<Long> odd = (num) -> num % 2l != 0;
		System.out.println(odd.test(51l)); // true
		System.out.println(odd.test(20l)); // false
	}
	
	public boolean param(Integer number) {
		return number % 2 == 0;
	}
}