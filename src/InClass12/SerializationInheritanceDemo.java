package InClass12;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SerializationInheritanceDemo {

//	Serialization with Inheritance
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		Case1: Parent - Serializable, Child - Not Serializable

//		SubClass subClass = new SubClass();
//		subClass.superValue = 50;
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/New-Workspace/Demo/super2.ser"));
//		oos.writeObject(subClass);
//		oos.close();
//
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/New-Workspace/Demo/super2.ser"));
//		SubClass sub = (SubClass) ois.readObject();
//
//		System.out.println(sub.subValue);
//		System.out.println(sub.superValue);

//		Case2: Parent Not Serializable, Child - Serializable

//		Case3: Parent - Serializable, Child - Not Serializable

	}
}

//class SuperClass implements Serializable {
//	int superValue = 10;
//
//	SuperClass() {
//		System.out.println("SuperClass Default Constructor.");
//	}
//}
//
//class SubClass extends SuperClass {
//	int subValue = 20;
//
//	private void writeObject(ObjectOutputStream oos) throws NotSerializableException {
//		System.out.println("Serialization log");
//		throw new NotSerializableException("Subclass cannot be serialized");
//	}
//
//	private void readObject(ObjectInputStream ois) throws NotSerializableException {
//		System.out.println("Deserialization log");
//		throw new NotSerializableException("Subclass cannot be deserialized");
//	}
//}