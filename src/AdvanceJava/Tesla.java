package AdvanceJava;

public class Tesla implements Vehicle {
	public boolean supportGPS() {
		return true;
	}

	@Override
	public int getNumberOfWheels() {
		return 4;
	}

	@Override
	public String getColor() {
		return "White";
	}

	@Override
	public int getCC() {
		return 2000;
	}
}