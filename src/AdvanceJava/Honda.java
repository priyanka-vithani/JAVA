package AdvanceJava;

public class Honda implements Vehicle {

	@Override
	public int getNumberOfWheels() {
		return 4; // 1 spare wheel extra
	}

	@Override
	public String getColor() {
		return "Black";
	}

	@Override
	public int getCC() {
		return 1200;
	}
}