package InClass14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SetInterfaceDemo {

//	Cursors
	public static void main(String[] args) throws InterruptedException {
//		Cursors:
//		To iterate the collections

//		1. Enumeration:
//		Legacy Interface
//		Use on Legacy classes like Vector, HashTable
//		It only supports the read operation

//		Vector<String> vec = new Vector<>();
//		vec.add("Obj1");
//		vec.add("Obj2");
//		vec.add("Obj3");
//
//		Enumeration<String> e = vec.elements();
////		e.hasMoreElements();  // It return the true if one or more elements are there
//		while (e.hasMoreElements()) {
//			System.out.println(e.nextElement());
//		}

//		Advantages:
//		It works with the Legacy classes

//		DisAdv:
//		It only reads the data

//		2. Iterator
//		introduced in Java Collection Framework
//		Used to iterate the collections
//		It allows modify & remove as well
//		Reads data in forward direction
//		List<String> students = new ArrayList<>();
//		students.add("S1");
//		students.add("S2");
//		students.add("S3");

//		Iterator<String> iterator = students.iterator();
//		while (iterator.hasNext()) {
//			String name = iterator.next();
//			if (name.equals("S2")) {
//				iterator.remove();
//			}
//			System.out.println(name);
//		}
//		System.out.println(students);

//		Advantages
//		Works with the collections
//		It can modify or remove elements as well

//		3. ListIterator:
//		Extended version of Interator
//		It can read data in both direction: Fwd, Bwd
//		It can also modify objects in collection

//		ListIterator<String> lstIterator = students.listIterator();
//		
//		while(lstIterator.hasNext()) {
//			System.out.println(lstIterator.next());
//			Thread.sleep(5000L);
//		}

//		Adv:
//		Traverse in both direction
//		modify the object as well

//		Fail-fast & Fail-safe conditions.
//		Fail-fast: Fail-fast Iterator throws the ConcurrentModificaitonException when we make any structural changes(modify, remove, add) in the collection except via the iterator's own.

//		ArrayList
//		Set
//		Map
//		List<String> list = new ArrayList<>();
//		list.add("O1");
//		list.add("O2");
//		list.add("O3");
//		
////		Iterator<String> it = list.iterator();
//		for(String str : list) {
//			list.remove("O1");
//			System.out.println(str);
//		}

//		Fail-safe: It does not throw the ConcurrentModificaitonException if we make any structural changes
//		CopyOnWriteArrayList

//		CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
//		arrayList.add("1");
//		arrayList.add("2");
//		for (String str : arrayList) {
//			arrayList.add("3");
//			System.out.println(str);
//		}
//		CopyOnWriteArrayList
//		ConcurrentHashMap
//		Collections java.util.concurrent

//		System.out.println(arrayList);

//		Interview Que
//		Fail-Fast - throw Exception, Thread-safe, Ex: ArrayList, HashMap etc
//		Fail-Safe - Does not throw an Exception, Thread Safe . Ex: CopyOnWriteArrayList, ConcurrentHashMap

//		====================SET Interface=================

//		1. HashSet:
//		Implemetns Set Interface
//		Insertion order does not maintain
//		It stores only unique elements

//		Set<Integer> set = new HashSet<>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(1);
//
//		Iterator<Integer> it = set.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
//		System.out.println(set);

//		Adv:
//		It prevents to store duplicate data

//		DisAdv:
//		Iterator order unpredicatble
//		Not Thread safe

//		2. LinkedHashSet

//		It extends the HashSet
//		It maintains the insertion order

//		Set<String> linkedHashSet = new LinkedHashSet<>();
//	linkedHashSet.add("1");
//	linkedHashSet.add("2");
//	linkedHashSet.add("3");
//	linkedHashSet.add("3");
//	
//	System.out.println(linkedHashSet);

//	Adv:
//	It maintains the inserion order
//	Data access fast compared to HashSet

//	DisAd:
//	It slightly takes more memory(Due to it maintains the insertion order)

//	SortedSet - Interface

//	It extends the Set Interface
//	Insersion order maintain
//	We can not create direct object of the SortedSet

//		SortedSet<String> sortedSet = new TreeSet<>();
//		sortedSet.add("B");
//		sortedSet.add("F");
//		sortedSet.add("A");
//		sortedSet.add("C");
//
//		System.out.println(sortedSet);
//
//		System.out.println("First - " + sortedSet.first());
//		System.out.println("Last - " + sortedSet.last());
//		System.out.println("HeadSet (before C) - " + sortedSet.headSet("C"));
//		System.out.println("TailSet (from C) - " + sortedSet.tailSet("C"));
//		System.out.println("SubSet (B, F) - " + sortedSet.subSet("B", "F"));

//		TreeSet
//		It is a concreate class
//		natural sorting (alp or numerical)
//		It allows custom sorting as well

//		TreeSet<String> treeSet = new TreeSet<>();
//		treeSet.add("B");
//		treeSet.add("F");
//		treeSet.add("A");
//		treeSet.add("C");
//
//		System.out.println(treeSet);
//
//		System.out.println("First - " + treeSet.first());
//		System.out.println("Last - " + treeSet.last());
//		System.out.println("HeadSet (before C) - " + treeSet.headSet("C"));
//		System.out.println("TailSet (from C) - " + treeSet.tailSet("C"));
//		System.out.println("SubSet (B, F) - " + treeSet.subSet("B", "F"));

//		 Sorting
//		1. Comparable

//		It is a natual sorting
//		Implemented by class to define the default sorting

//		List<Student> students = new ArrayList<>();
//		students.add(new Student(3, "S3"));
//		students.add(new Student(1, "S1"));
//		students.add(new Student(2, "S2"));
//
//		System.out.println("Before - "+students);
//		Collections.sort(students);
//		System.out.println("After - "+students);

//		Adv:
//		Natural sorting

//		DisAdv:
//		Only one sort per class

//		2. Comprator
//		Defined custom sorting logic

//		Sorting with one field only
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("C", 30000));
		employees.add(new Employee("B", 20000));
		employees.add(new Employee("E", 10000));
		employees.add(new Employee("A", 20000));

		System.out.println("Before - " + employees);
//		Sorting on salary
//		employees.sort(Comparator.comparing(Employee::getName));
//		:: -> Method reference (ClassName::methodName)
//		System.out.println("After - " + employees);

//		two layer sorting

		employees.sort(
				Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName).reversed());
		System.out.println("After - " + employees);

//		Advantages:
//		It allows multiple sorting strategies
//		No changes needed in class
		
//		Interview Que: What is Comparable & Comparator.
	}
}

class Student implements Comparable<Student> {

//	Default sorting on this field
	int rollNo;
	String name;

	Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public String toString() {
		return rollNo + " - " + name;
	}

	@Override
	public int compareTo(Student other) {
		return this.rollNo - other.rollNo; // Asc sorting
	}
}

class Employee {
	String name;
	double salary;

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return name + " - " + salary;
	}
}