package InClass12;

// GC: Garbage Collector
// Finalization
public class GCDemo {

	public static void main(String[] args) {
		
		Object obj = new Object();
//		GC: It is a process which JVM calls automatically to destory object memory
		
//		How we can make object eligible for GC
		
//		null reference to the Object
//		
//		User user = new User();
//		user = null;
		
//		Releasing the reference
		
//		User user1 = new User();
//		User user2 = new User();
//		user1 = user2;
		
		
//		Ways to call GC
//		1. System.gc()
//		2. Runtime.getRuntim().gc()
		
//		Finalization - 
//		finalize() is a method defined in the OBject class which GC calls before destroying an object.
		
		Employee1 e = new Employee1();
		e = null;
		
		System.gc();
	}
}

class Employee1 {
	
	@Override
	protected void finalize() {
		System.out.println("Calling finalize method");
	}
}