package AdvanceJava;

import java.util.Optional;

public class OptionalClassExample {
	public static void main(String[] args) {
		Optional<String> opt = getName();
//		if(opt.isEmpty()) {
//			System.out.println("There is no value in getName return type");
//			return;
//		}
//		
//		if(opt.isPresent()) {
//			System.out.println("Values are present in getName return type");
//		}

//		String str = opt.get(); // NoSuchElementException
//		String str = opt.orElse("Default Value");
//		String str = opt.orElseGet(() -> "Default Value");
//		System.out.println(str);
		opt.orElseThrow(() -> new RuntimeException("Name is empty"));
	}

	// Written By Param
	public static Optional<String> getName() {
		String str = null;
//		return Optional.ofNullable(str);
		return Optional.empty(); // This is simple Null
	}
}