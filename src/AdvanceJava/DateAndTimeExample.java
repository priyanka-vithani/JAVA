package AdvanceJava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;

public class DateAndTimeExample {
	public static void main(String[] args) {
		System.out.println(new Date()); // Date and Time will be Printed

		System.out.println(LocalDate.now()); // Only Date will be Printed
		System.out.println(LocalTime.now()); // Only Time will be Printed
		System.out.println(LocalDateTime.now()); // Date and Time will be Printed

		LocalDate birthDate = LocalDate.of(1999, 1, 1);
		System.out.println(birthDate); // 1999-01-01
		Period age = Period.between(birthDate, LocalDate.now());
		System.out.println(age.getYears()); // 26
	}
}