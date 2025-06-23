package InClass14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Cursors
// Set
//HashSet
//LinkedHashSet
//TreeSet
//SortedSet
// Fail fast & Fail Safe collections -  Imp
// sorting
// Comparable & Comparator - Imp
public class MapInterfaceDemo {
	public static void main(String[] args) {
//		Map 

//		Data stored in the Key value pair

//		HashMap

		HashMap<Integer, String> map = new HashMap<>();
//		map.put(1, "Obj1");
//		map.put(2, "Obj2");
//		map.put(3, "Obj3");
//		map.put(1, "Obj"); // Override Value
//
//		System.out.println(map.containsKey(1));
//		System.out.println(map.containsValue("Obj"));
//		System.out.println(map.get(4)); // Need to pass key
//		System.out.println(map.keySet());
//		System.out.println(map.values());

//		We can only store one null key but not multiple
//		We can store multiple null values

		map.put(null, "1");
		map.put(1, null);
		map.put(2, null);

		System.out.println(map);

		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Entry<Integer, String> entry : set) {
			// Iterate the HashMap
			System.out.println("Key - " + entry.getKey() + ", Value - " + entry.getValue());
		}

	}
}
