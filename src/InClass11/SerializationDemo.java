package InClass11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Serialization: 
//		It is a process of converting a JAva object into a byte stream.
//		Java has Serializable interface
//		Class must implement Serializable interface

//		Serializable - marker interface
//		Why we need to use this?
//		To store the objects state inside the file, we can send the object stream over the network

//		Example:
//		Student student = new Student(1, "S1", "abcd");
//		FileOutputStream fos = new FileOutputStream("D:/New-Workspace/Demo/student.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(student);
//		oos.close();
//
//		System.out.println("Student - " + student.id);
//		System.out.println("Student - " + student.name);
//		System.out.println("Student - " + student.password);
//		FileInputStream fis = new FileInputStream("D:/New-Workspace/Demo/student.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//
//		Student studentNew = (Student) ois.readObject();
//
//		ois.close();
//		System.out.println("NewStudent - " + studentNew.id);
//		System.out.println("NewStudent - " + studentNew.name);
//		System.out.println("NewStudent - " + studentNew.password);

//		Address add = new Address("Ahmedabad");
//		Employee emp = new Employee("E1", add);
//
//		FileOutputStream fos = new FileOutputStream("D:/New-Workspace/Demo/emp.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(emp);
//		oos.close();
		
		
		Account account = new Account("A1", "abc");
		FileOutputStream fos = new FileOutputStream("D:/New-Workspace/Demo/account.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(account);
		oos.close();
	}
}

class Student implements Serializable {
	int id;
	String name;
	transient String password;

	Student(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
}

class Address implements Serializable {
	String city;

	Address(String city) {
		this.city = city;
	}
}

class Employee implements Serializable {

	String name;
	Address address;

	Employee(String name, Address add) {
		this.name = name;
		this.address = add;
	}
}

class Account implements Serializable {
	String userName;
	transient String password;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(password + "123");
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		String pass = (String) ois.readObject();
		password = pass.substring(0, pass.length() - 3);
	}
	
	Account(String uName, String password){
		this.userName = uName;
		this.password = password;
	}
}
