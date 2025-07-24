package AdvanceJava;

public class DefaultStaticTest {
	public static void main(String[] args) {
		Honda honda = new Honda();
		Tesla tesla = new Tesla();

		System.out.println(honda.supportGPS()); // false
		System.out.println(tesla.supportGPS()); // true

		System.out.println(Vehicle.getMyName()); // Hello Param
	}
}