package AdvanceJava;

public class LambdaExpressionExample {
	
	public static void main(String[] args) {
		// Before java 8 launch
//		Runnable r = new Runnable() {
//
//			public void run() {
//				System.out.println("Hello Param");
//			}
//		};

		// After java 8 launch
		Runnable r = () -> System.out.println("Hello Param");
		new Thread(r).start();
	}
}