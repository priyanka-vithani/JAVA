package AdvanceJava;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		Calculator add = (a, b) -> a + b;
		Calculator multiply = (a, b) -> a * b;

		System.out.println("Sum: " + add.operate(10, 20)); // 30
		System.out.println("Multiply : " + multiply.operate(10, 20)); // 200

		Adder adder = new Adder();
		System.out.println(adder.operate(50, 200));
	}

	@FunctionalInterface
	interface Calculator {
		int operate(int a, int b);
	}

	public void beforeJava8() {
//		Calculator add = (a, b) -> a + b;

		// First way
		Calculator add = new Calculator() {
			public int operate(int a, int b) {
				return a + b;
			}
		};
	}

	// Second Way
	private static class Adder implements Calculator {

		@Override
		public int operate(int a, int b) {
			return a + b;
		}

	}
}