package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class GenericsDemo {

	public static void main(String[] args) {
//		IdentifyHashMap
//		Key will be compared based on the object reference
//		.equals(), ==
		
//		HashMap - It will check for the value to identify the unique key
//		IdentityHashMap - (==)
//		Map<String, String> hashMap = new HashMap<>();
//		Map<String, String> identityHashMap = new IdentityHashMap();
//		
//		String a = new String("key");
//		String b = new String("key");
//		
//		System.out.println(a == b);
//		System.out.println(a.equals(b));
//		hashMap.put(a, "Value1");
//		hashMap.put(b, "Value2");
//		
//		identityHashMap.put(a, "Value1");
//		identityHashMap.put(b, "Value2");
//		
//		System.out.println("Normal Map - "+hashMap.size());
//		System.out.println("IdentityHash Map - "+identityHashMap.size());
		
//		Advanatages:
//		Allows multiple key with equals values if the reference are different
		
//		DisAd:
//		Not Thread-safe
		
//		TreeMap
//		Keys will be stored in the natural order by default
//		Null keys are not allowed
//		Null values are also not allowed
//		Non Thread safe
		
//		TreeMap<String, String> treeMap = new TreeMap<>();
//		treeMap.put("abcd", "105");
//		treeMap.put("abc", "102");
//		treeMap.put("ab", "101");
//		treeMap.put("abe", "107");
//		
//		for(String key : treeMap.keySet()) {
//			System.out.println("Key - "+key);
//		}
		
//		Advantages
//		Maintains the key order 
//		It supports custum sorting 
		
//		DisAdv
//		NOn thread safe
//		Not allowed null keys
		
//		NavigableMap
//		it allows us to traverse, search type of method
		
//		NavigableMap<Integer, String> navigableMap = new TreeMap<>();
//		navigableMap.put(60, "60");
//		navigableMap.put(70, "70");
//		navigableMap.put(80, "80");
//		navigableMap.put(90, "90");
//		
//		System.out.println(navigableMap.lowerKey(80)); // 70
//		System.out.println(navigableMap.floorKey(80)); // 80
//		System.out.println(navigableMap.ceilingKey(75)); // 80
//		System.out.println(navigableMap.higherKey(80)); // 90
//		
//		System.out.println(navigableMap.descendingKeySet());
//		System.out.println(navigableMap.descendingMap());
		
//		Adv:
//		It allows us to look up of range based data
//		Reverse order traversal
		
//		Queue
//		FIFO -First In First Out
		
//		Common methods
//		offer() - insert the data
//		poll() - retrvies and removes head
//		peek() - It retrvies head but do not remove
		
//		Queue<String> queue = new LinkedList<>();
//		queue.offer("A");
//		queue.offer("B");
//		queue.offer("C");
//		
//		System.out.println(queue.peek());
//		System.out.println(queue.poll());
//		System.out.println(queue.peek());
		
//		PriorityQueue
//		elements are ordered by narual order
//		Not FIFO, highest priority is processed first
//		It does not allowed null element
//		It uses binary search
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.offer(30);
////		30
//		pq.offer(10);
////		10
////	30
//		pq.offer(20);
////		10
////	30     20	
//		System.out.println(pq);
//		
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
	
//	NavigableSet
		
//		It is a sub interface of SortedSet
//		It is implemented by TreeSet
		
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		
		System.out.println(set.lower(25)); // 20
		
//		Generics:
//		It enable types to be parameters when defining classes, method
//		It ensures type safety
//		It will check the type at the compile time
		
//		List<String> list = new ArrayList<>();
//		list.add(1); // compile time error
		
//		Generic Classes:
		
//		Bounded Type
//		It limits types that can be passes to a generic
		
//		Calculator<Double> calculator = new Calculator(10, 20);
//		System.out.println(calculator.add());
//		
////		Generic methods & wildcard
//		
////		It defines methods with type(T) parameters
//		
////		int[] arr = {1,2};
//		log(1);
//		log("String");
//		
////		Wildcard
////		Use ? as a unknown type
//		
//		print(Arrays.asList(1,2));
//		print(Arrays.asList(1.3,2.5));
//		printList(Arrays.asList("A","B"));
		
//		Types of wildcard
//		? -> unknown type
//		? extends Number -> limited classes allowed
//		? super T
		
//		Utility classes:
		
//		Arrays
//		It provides static methods to work with array
		
//		int[] numbers = {10, 20, 30, 40, 50};
//		
//		Arrays.sort(numbers);
////		our array should be sorted
////		Arrays.binarySearch(null, 0)
//		System.out.println(numbers);
//
//		int index = Arrays.binarySearch(numbers, 30);
//		System.out.println(index);
		
//		Collections
//		- sorting
		
//		Natural sorting
		List<Integer> list = Arrays.asList(5,2,1,9);
//		Collections.sort(list);
		
//		Custom sorting
//		Collections.sort(list, Collections.reverseOrder());
		
		
//		 Reversing
//		It reverse the order of elements
		
		Collections.reverse(list);
		
//		Search
//		It uses the binary search
		
		Collections.sort(list);
		Integer index = Collections.binarySearch(list, 2);
		System.out.println(index);
		System.out.println(list);
		
	}
	
	public static void printList(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	public static void print(List<? extends Number> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	public static <T> void log(T objet) {
//		for(T e : array) {
			System.out.println(objet);
//		}
	} 
}

class Calculator<T extends Number> {
	private T num1;
	private T num2;
	
	public Calculator(T num1, T num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double add() {
		return num1.doubleValue() + num2.doubleValue();
	}
}

class ApiResponse<T> {
	private boolean success;
	private T data;
}