package InClass12;

import java.util.ArrayList;
import java.util.List;

// Collection
public class CollectionDemo {
	
//	List - ArrayList, LinkedList, Vector
//	Set
//	Map
//	Queue
//	TreeSet
//	TreeMap
	
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(1);
		list.add("demo");
		
//		add()
//		addAll()
//		clear()
//		remove(index)
//		remove(object)
//		size()
//		toArray()
		
//		 it is a dynamic size
		List<Integer> intList = new ArrayList<>();
		for(int i=0; i < 10; i++) {
			intList.add(i);
		}
//		System.out.println(intList);
		
		List<Integer> intList2 = new ArrayList<>();
		for(int i=0; i < 10; i++) {
			intList2.add(i);
		}
		
		intList.addAll(intList2);
//		System.out.println(intList);
		
		System.out.println(intList.size());
//		intList.clear();
		System.out.println(intList.size());

		Integer element = intList.get(5);
//		intList.remove(5);
		intList.remove(element);
		System.out.println(intList);
		System.out.println(intList.size());
		
		Object[] arr = intList.toArray();
		System.out.println(arr);
	}
}
