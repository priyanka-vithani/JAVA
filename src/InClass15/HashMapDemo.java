package InClass15;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

//HashMap
//LinkedHashMap
//HashTable
//WeakedHashMap
public class HashMapDemo {

	public static void main(String[] args) {
//		Map
//		key value pair

//		HashMap
//		No duplicate key allowed
//		one null key and multiple null values are allowed
//		No insertion order maintained
//		Non thread safe

//		Map<Integer, String> map = new HashMap<>();
//
//		map.put(3, "Three");
//		map.put(1, "One");
//		map.put(4, "Four");
//		map.put(2, "Two");
//
//		for (Entry<Integer, String> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "=> " + entry.getValue());
//		}

//		Internal working of the HashMap -> Interview Que
//		It uses the hash function interanlly for the Key
//		If two different key's having same has value -> LinkedList

//		buckets
//		[4]
//		[1]
//		[(LinkedList) -> (2) -> (3)]

//		String key1 = "FB";
//		String key2 = "Ea";
//
//		System.out.println("Key1 Hash -> " + key1.hashCode());
//		System.out.println("Key2 Hash -> " + key2.hashCode());
//
//		Map<String, String> map = new HashMap<>();
//		map.put(key1, "First");
//		map.put(key2, "Sec");
//
//		for (Entry<String, String> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "=> " + entry.getValue());
//		}

//		Advantages:
//		Fast access
//		data stored in the key value pair

//		DisAdv:
//		No insertion order maintained
//		Not synchronized

//		LinkedHashMap

//		subclass of HashMap
//		It maintains the order
//		
//		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
//		linkedHashMap.put(1, "1");
//		linkedHashMap.put(2, "2");
//		linkedHashMap.put(3, "3");
//		
//		for(Entry<Integer, String> entry : linkedHashMap.entrySet()) {
//			System.out.println(entry.getKey() + "=> " + entry.getValue());
//		}

//		removeEldestEntry()
//		It is used auto removal of eldest entry
//		It is called when we call the put method

//		Map<Integer, String> linkedHashMap = new LinkedHashMap<>(3);
//		linkedHashMap.put(1, "1");
//		linkedHashMap.put(2, "2");
//		linkedHashMap.put(3, "3");
//		linkedHashMap.put(4, "4");
//		
//		for(Entry<Integer, String> entry : linkedHashMap.entrySet()) {
//			System.out.println(entry.getKey() + "=> " + entry.getValue());
//		}

//		LRU (Last Recently Used) Cache
//		LRUCache<Integer, String> cache = new LRUCache(3);
//		
//		cache.put(1, "A");
//		cache.put(2, "B");
//		cache.put(3, "C");
//
////		access
//		cache.get(2);
//		
//		cache.put(4, "D");
//		
////		access order list
////		[3]
////		2st key element accessed
////		[2]
////		[4] -> add
//		
////		2 -> remove
////		3
////		1
////		4
//		for(Entry<Integer, String> entry : cache.entrySet()) {
//			System.out.println(entry.getKey() +"=> "+entry.getValue());
//		}
//		
//		When to use removeEldestEntry?
//		When we implement LRU Cached
//		when you want size bound

//		Advantages
//		Maintains the order
//		it supports removeEldestEntry method to remove last accessed element
//		all hashmap benefits

//		DisAdv:
//		It takes more memory -> due to insersion order maintains
//		slightyl slower compared to HashMap
//		Non thread safe

//		HashTable:
//		It is a legacy class
//		java.util
//		Key value pair
//		Keys are unique.
//		Thread safe
//		It does not allow null key or value

//		Hashtable<Integer, String> hashtable = new Hashtable<>();
//
//		hashtable.put(1, "1");
//		hashtable.put(2, "2");
//		hashtable.put(3, "3");
//		hashtable.put(null, "null"); -> it throws NullPointerException
//		hashtable.put(4, null); -> it throws NullPointerException

//		Internal working
//		It internally uses an array of buckets
//		Each bucket stores the LinkedList
//		methods sychronized, put, get, remove

//		Advantages:
//		Thread-safe

//		DisAdv:
//		Due to sychronization performace slow
//		No null values or keys are allowed

//		Difference -> Interview Que
//		HashMap				HashTable
//	    Not synchronized	synchronized
//		It allows 1 null 
//		key & mul null values  Does not allowed null key or value
//		Fail-fast collection  It does not throw ConcurrentMOdificationException
//		It is fast access     slow(due to synchronization)

//		WeakedHashMap
//		It automatically removes the entry if keys are no longer in use
//		When GC called then it is automatically removes that entry

		Map<Data, String> map = new WeakHashMap<>();

		Data data1 = new Data("Key1");
		Data data2 = new Data("Key2");

		map.put(data1, "Value1");
		map.put(data2, "Value2");

		System.out.println("Before GC: " + map);

		data1 = null; // After GC this object will be removed from map

		System.gc();

		System.out.println("After GC Called: -" + map);
		
//		Object References
//		Strong -> Never collected
//		Weak -> Collected when GC runs (if no strong reference)
//		Soft -> It collected only when memory is low
//		Phantom -> It collected after finalization
		
//		Advantages:
//		Prevents memory leaks automatically
//		It works with GC
		
//		DisAdv:
//		No Thread safe
//		Entries can be disappear(remove) at any time
//		Slower than HashMap due to GC interation
	}

}

class Data {
	public String name;

	public Data(String name) {
		this.name = name;
	}

	public String toString() {
		return "Data:" + name;
	}

	protected void finalize() {
		System.out.println(name + " is being GC");
	}
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int maxSize;

	public LRUCache(int maxSize) {
		super(maxSize, 0.75f, true);
		this.maxSize = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		System.out.println("removeEldestEntry called." + (size() > maxSize));
		return size() > maxSize;
	}
}