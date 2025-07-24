package AdvanceJava;

import java.util.function.Function;

public class FunctionInterfaceExample {
	public static void main(String[] args) {
		Function<Integer, Integer> square = (num) -> {
			int sq = num * num;
			System.out.println("Square of " + num + " is : " + sq);
			return sq;
		};
		System.out.println(square.apply(10)); // 100 -> Square of 10 is : 100
	}
}