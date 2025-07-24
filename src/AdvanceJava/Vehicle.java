package AdvanceJava;

public interface Vehicle {

	public static void main(String[] args) {
		
	}
	int getNumberOfWheels();

	String getColor();

	int getCC();

	default boolean supportGPS() {
		return false;
	}

	static String getMyName() {
		return "Hello Param";
	}
}