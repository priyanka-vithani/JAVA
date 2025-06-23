package InClass12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ExternalizationDemo {

//	Externalization
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

//		SubClass sub = new SubClass("Super", "Sub");
//
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/New-Workspace/Demo/external.ser"));
//		oos.writeObject(sub);
//		oos.close();

//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/New-Workspace/Demo/external.ser"));
//		SubClass obj = (SubClass) ois.readObject();
//		ois.close();
//		System.out.println(obj.subValue);
//		System.out.println(obj.superValue);
		
//		Advantages:
//		Full control
//		Only store required data
		
//		DisAdvantages:
//		More Complex
//		Easy forget some fields
		
//		Serialization | Externalization
//		Automatice | Manually
//		No method to implement | Two methods to implement
//		Used trisient for exclution | you decide what to include/exclude
		
//		serialVersionUID
		
//		Student5 st = new Student5("Student1", 1);
//		
//		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("D:/New-Workspace/Demo/stu.ser"));
//		oos.writeObject(st);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/New-Workspace/Demo/stu.ser"));
		Student5 s = (Student5) ois.readObject();
		ois.close();
		
		System.out.println(s.id);
		System.out.println(s.name);
		System.out.println(s.department);
		
//		What is the use of the Marker Interface?
		
	}

}

//class SuperClass {
//	String superValue;
//
//	public SuperClass() {
//		System.out.println("SuperClass default constructor");
//	}
//
//	public SuperClass(String superValue) {
//		this.superValue = superValue;
//	}
//}
//
//class SubClass extends SuperClass implements Externalizable {
//
//	String subValue;
//
//	public SubClass() {
//		System.out.println("SubClass default constructor");
//	}
//
//	public SubClass(String superValue, String subValue) {
//		super(superValue);
//		this.subValue = subValue;
//		System.out.println("SubClass default constructor");
//	}
//
//	@Override
//	public void writeExternal(ObjectOutput out) throws IOException {
//		System.out.println("writeExternal");
//		out.writeObject(superValue);
//		out.writeObject(subValue);
//
//	}
//
//	@Override
//	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//		System.out.println("readExternal");
//		superValue = (String) in.readObject();
//		subValue = (String) in.readObject();
//	}
//
//}

class Student5 implements Serializable {
//	private static final long serialVersionUID =2L;
	
	String name;
	int id;
	String department;
	
	public Student5 (String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}
}

interface AdminAccess {
	
}

class AdminUser implements AdminAccess {
	
}

// User user = new User();
// if (user instanceof Serializable) {
//	Performs admin operation
//}