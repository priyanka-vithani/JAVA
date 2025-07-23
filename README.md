# JAVA

# HomeWork 1:

Java Basics – Student Assignment
 
Instructions:
 
Complete all the tasks in Ecllipse or intelij 
 
---
 
Task 1: Setup & Hello World
 
1. Install JDK 21 and Eclipse IDE
 
 
2. Create a new project named JavaBasics
 
 
3. Create a class HelloJava
 
Print: Hello, I am learning Java!
 
 
 
---
 
Task 2: Primitive Datatypes Practice
 
Create a class PrimitiveDemo and:
 
Declare all 8 primitive datatypes
 
Assign example values
 
Print them with clear labels
 
 
Example output:
 
Byte value: 100  
Char value: A  
Boolean value: true  
...
 
 
---
 
Task 3: Variable Types
 
Create a class VariableTypesDemo with the following:
 
An instance variable studentName
 
A static variable schoolName
 
A method showDetails() that contains a local variable rollNo
 
Print all three variables
 
 
 
---
 
Task 4: Variable Declaration & Assignment
 
Create a class VariableAssignment:
 
Declare 3 variables: int x, double y, char grade
 
Assign values to them
 
Print them before and after changing the values
 
---
 
Task 5: Literals and Output Formatting
 
Create a class LiteralDemo:
 
Use examples of integer, floating, character, string, and boolean literals
 
Also try hexadecimal and binary literals
 
Print all with formatting
 
 
---
 
Task 6: Use of Operators
 
Create a class OperatorDemo:
 
Declare two integers a = 10, b = 5
 
Show examples of:
 
Arithmetic operators (+, -, *, /, %)
 
Relational operators (>, <, ==, !=)
 
Logical operators (&&, ||, !)
 
Assignment operators (+=, -=, etc.)
 
 
Print results with descriptions
 
 
Example:
 
Sum = 15  
a > b: true  
a != b: true  
a += 5 → a becomes 15


# Theory:
https://en.cppreference.com/w/c/language/operator_precedence
 

 
 
# Homework 2::


follow above table ..
 
int a = 5, b = 10, c = 0;

c = (a++ * --b > 40) ? a & b | c ^ 2 : (a << 1) + (b >> 1);
 
boolean x = true, y = false;

boolean result = (x && y) || (!x ^ y) ? x == y : x != y;
 
int[] arr = {1, 2, 3, 4};

boolean check = (Math.pow(arr[2], 2) >= 9) && (arr[1] + arr[0] < 5);
 
int d = 2;

long e = 5;

d <<= (int)(e % 3 + 1) * 2;
 
int p, q, r;

p = q = r = (5 > 3) && (7 != 2) ? (10 | 3) + 4 : 0;

 
try to understand this

Sum of N Natural Numbers
Multiplication Table of a Number
Print Prime Numbers from 1 to 50
Reverse the Digits of a Number
Pattern Printing – Triangle of Numbers

#Theory::
// Demonstration of hashCode(), wait(), wait(long), wait(long,int), notify(), and notifyAll()
 
// 1. hashCode() and equals()

class Employee {

    int id;

    String name;
 
    Employee(int id, String name) {

        this.id = id;

        this.name = name;

    }
 
    @Override

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee e = (Employee) obj;

        return id == e.id && name.equals(e.name);

    }
 
    @Override

    public int hashCode() {

        return id * 31 + name.hashCode();

    }

}
 
class HashCodeDemo {

    public static void run() {

        Employee e1 = new Employee(1, "John");

        Employee e2 = new Employee(1, "John");
 
        System.out.println("e1.hashCode(): " + e1.hashCode());

        System.out.println("e2.hashCode(): " + e2.hashCode());

        System.out.println("e1.equals(e2): " + e1.equals(e2));

        // Output:

        // hashCodes should be same for e1 and e2

        // equals should return true

    }

}
 
// 2. wait() and notify()

class SharedResource {

    private boolean dataAvailable = false;
 
    synchronized void produce() throws InterruptedException {

        System.out.println("Producing...");

        dataAvailable = true;

        notify(); // Notifies waiting consumer

    }
 
    synchronized void consume() throws InterruptedException {

        while (!dataAvailable) {

            wait(); // Waits until notified by producer

        }

        System.out.println("Consuming...");

    }

}
 
class WaitNotifyDemo {

    public static void run() {

        SharedResource resource = new SharedResource();
 
        Thread consumer = new Thread(() -> {

            try {

                resource.consume();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        });
 
        Thread producer = new Thread(() -> {

            try {

                Thread.sleep(1000); // simulate delay

                resource.produce();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        });
 
        consumer.start();

        producer.start();

        // Output:

        // Consumer thread waits

        // Producer runs after 1 sec and notifies

        // Consumer resumes and consumes

    }

}
 
// 3. wait(long timeout)

class TimeoutWaitDemo {

    public static void run() {

        Object lock = new Object();
 
        Thread t = new Thread(() -> {

            synchronized (lock) {

                try {

                    System.out.println("Thread waiting with timeout...");

                    lock.wait(2000); // Wait for max 2 seconds

                    System.out.println("Thread resumed after timeout or notify.");

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        });
 
        t.start();

        // Output:

        // Thread starts waiting

        // After 2 seconds, resumes automatically if not notified

    }

}
 
// 4. notifyAll()

class NotifyAllDemo {

    private final Object lock = new Object();
 
    class WaitingThread extends Thread {

        public void run() {

            synchronized (lock) {

                try {

                    System.out.println(Thread.currentThread().getName() + " waiting...");

                    lock.wait();

                    System.out.println(Thread.currentThread().getName() + " resumed!");

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        }

    }
 
    void runDemo() throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            new WaitingThread().start();

        }
 
        Thread.sleep(1000);

        synchronized (lock) {

            System.out.println("Notifying all waiting threads...");

            lock.notifyAll();

        }

        // Output:

        // All threads print "waiting..."

        // After 1 sec, all resume with "resumed!"

    }

}
 
public class ThreadSyncExamples {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- HashCode Demo ---");

        HashCodeDemo.run();
 
        System.out.println("\n--- Wait/Notify Demo ---");

        WaitNotifyDemo.run();
 
        Thread.sleep(3000); // wait to finish above threads
 
        System.out.println("\n--- Wait with Timeout Demo ---");

        TimeoutWaitDemo.run();
 
        Thread.sleep(3000);
 
        System.out.println("\n--- NotifyAll Demo ---");

        new NotifyAllDemo().runDemo();

    }

}

try to debug above code and understand about lambda function
 

# Homework 3::

✅ 1. While Loop & Do-While Loop

Q1. Write a while loop that prints numbers from 10 to 1 in reverse.

Q2. Write a do-while loop that keeps asking the user to enter a number until they type a number > 100.

Q3. What's the key difference between while and do-while? Show using an example with i = 100.
 
✅ 2. Break and Continue

Q1. Use break to stop a loop when the sum of numbers exceeds 50.

Q2. Use continue to skip even numbers from 1 to 10 and print only odd numbers.

Q3. Rewrite this loop to avoid continue, but still skip printing the number 5:
 
✅ 3. Iterative vs Recursive Factorial

Q1. Write an iterative method to calculate sum of first n natural numbers.

Q2. Write a recursive method to calculate power of a number pow(a, b) = a^b.

Q3. Which is better for calculating factorial of large numbers, and why?
 
✅ 4. Marker Interface

Q1. Create a marker interface Loggable. Create 2 classes that implement it.

Q2. In main(), check if objects are instanceof Loggable and print special message.

Q3. What’s the purpose of marker interfaces if they don’t have methods?
 
✅ 5. 1D & 2D Arrays

Q1. Declare a 1D array of size 5, take input from user, and print the sum of all elements.

Q2. Write a program to find max element in a 2D array:
 
 
✅ 6. OOP: Constructors and Object Methods

Q1. Create a class Book with name and price. Add default and parameterized constructors.

Q2. Create 2 objects of Book, and display hashCode and class name using hashCode() and getClass().

Q3. Modify your class to override toString() to return "Book[name=..., price=...]".

 

# Topics 4:

"Ways to create the object in java

- by using new keyword

- by using clone() method

- by using Constructor.newInstance() Reflection API

- by using Class.forName().newInstance() method

Java Strings

- What is String

- What is Immutability

- Ways to create String in java

    - By using Literals

    - By using new keyword

- SCP 

- Heap

- SCP Vs Heap

- == vs .equals

- Constructors

- Methods"

"StringBuilder and StringBuffer

Difference between StringBuilder and StringBuffer

Difference between String vs StringBuilder/StringBuffer

Modifiers in Java

    - public

    - private

    - protected

    - default

    - abstract

    - static

    - native

    - synchronized

    - strictfp

    - final

    - transient

    - volatile

Wrapper classses in Java

Auto-boxing

Auto-unboxing"

"Java Constructors

- Constructor Creation

- Overloading
 
basic defination covered
Abstraction in Java

Encapsulation in Java

Inherintance in Java
 
Type casting in java

    - Implicit

    - Explicit

Rules for Type Casting
 
Exception Handling in Java

    - Introduction

    - Default Exception Handling in Java

    - Exception Hierarchy

    - try

    - catch

    - finally

    - throw

    - throws

    - Custom Exceptions"
 
 
these are the topics we covered in previous lecture
 
 
# Topics 5::

Constructor Overloading
 
Method Overloading
 
Single Inheritance
 
Multilevel Inheritance
 
Hierarchical Inheritance
 
Multiple Inheritance using Interfaces
 
Diamond Problem Resolution using Interfaces
 
Method Overriding
 
Exception Handling in Method Overriding (Checked Exceptions Rule)
 
Abstraction using Abstract Classes
 
Encapsulation using Private Fields and Public Getters/Setters
 
Access Modifiers (private, public)
 
Interface Default Methods
 
Why Java Doesn’t Support Multiple Class Inheritance
 
Runtime Polymorphism (Dynamic Method Dispatch)

 
topic covered today
 
 
 # Homework 5::
 
 Create a class Employee with overloaded constructors: (1) only name, (2) name and salary, (3) name, salary, and department.
 
Create a class MathUtils with overloaded methods multiply(int, int), multiply(double, double), and multiply(int, int, int).
 
Create a base class Animal with a method eat(). Inherit it in class Dog with a method bark(). Call both methods.
 
Create classes A → B → C in multilevel inheritance. Each adds its own method. Call all from class C object.
 
Create a class Shape with method area(). Inherit Circle and Rectangle from it. Override area() in both.
 
Create interfaces Flyable and Swimmable, both with move() method. Implement both in class Duck.
 
Create class Printer with method print(). Override it in subclass ColorPrinter. Call using superclass reference.
 
Create an array of Animal type and store Dog, Cat, Cow objects. Call sound() method using polymorphism.
 
Create abstract class BankAccount with abstract method withdraw(). Extend it in SavingsAccount and CurrentAccount.
 
Create class Student with private fields. Add public getter/setter with validation (marks 0–100 only).
 
Demonstrate type casting: (a) int to double, (b) double to int, (c) upcasting and downcasting with classes.
 
Create class A with constructor printing "A". Extend it in class B, use super() and this() in constructors.
 
Create method divide(int a, int b) that throws ArithmeticException if b == 0. Handle in main method.
 
Create Integer and Double wrapper objects using autoboxing. Do arithmetic using unboxed values.
 
Override toString(), equals(), and hashCode() in class Book. Create and compare two Book objects.
 
Create class with final variable, final method, and final class. Show example of finalize() before GC.
 
Design an employee hierarchy: Employee (base), Manager and Developer (subclasses). Use all OOP concepts.
 
# Topics 6::

Top 10 Most used Java Exceptions

Java 7 Updates for Exception Handling

        - Try with Resources

        - With Multi-catch blocks

Exception Handling in Java

        - Introduction

        - Default Exception Handling in Java

        - Exception Hierarchy

        - try

        - catch

        - finally

        - throw

        - throws

        - Custom Exceptions
 
Difference between final, finally and finalize

Inner class in Java

        - Normal Inner Class

        - Method Local Inner Class

        - Static Inner Class

        - Annonymous Inner class(Compilation - javac <fileName.java>, Run -> java <class Name without extention>)

Inner Class Combinations with classes and Interfaces

        - Class inside Class - Already Seen

        - Class inside Interface - sendEmail();

        - Interface inside class

        - Interface inside interface
topic covered in today lecture
 
 
 
 
 # Homework 6::
 
 Write a program that handles NumberFormatException when converting user input to an integer.
 
Create a method that calculates square root and throws a custom NegativeNumberException if input is negative.
 
Create a banking app method that throws InsufficientBalanceException (custom) if withdrawal exceeds balance.
 
Simulate a scenario where ClassNotFoundException occurs using Class.forName(...).
 
Simulate FileNotFoundException by trying to read a non-existent file.
 
Write a program to handle multiple exceptions using nested try-catch blocks.
 
Write a program using Scanner that demonstrates InputMismatchException.
 
Demonstrate rethrowing an exception after catching it.
 
Create a custom unchecked exception InvalidPasswordException and demonstrate its usage.
 
Simulate a SQLException scenario in JDBC (no actual DB needed, just simulate with custom class).
 
 
Create an outer class School with an inner class Student having fields like name and roll number.
 
Define an interface inside a class Vehicle, and implement it in an anonymous inner class to simulate start() method.
 
Write a method that defines a method-local inner class to validate user age.
 
Create a static nested class inside a class Library that prints available books.
 
Create an interface Operation with a nested interface Validator and implement both.
 
 
 
//https://rollbar.com/blog/java-exceptions-hierarchy-explained/

//https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/

//https://www.shiksha.com/online-courses/articles/difference-between-throw-and-throws/
Java Exceptions Hierarchy Explained | Rollbar
The tree diagram below shows the standard exception and error classes defined in Java, organized in the Java exceptions hierarchy.
 
 
 


# Topic 7 

File
File Reader
File Writer
Buffered Reader
Buffered Writer
Print Writer
# Homework 7
Tasks
- Write a program to list all files and directories in a given directory.
- Write a program to read the contents of a .txt file character by character using FileReader.
- Write a program to take user input and write it to a file using FileWriter.
- Write a program to copy the contents of one file to another using BufferedReader and BufferedWriter.
- Write a program to count the number of lines and words in a file using BufferedReader.
 


# Topics 8: 

Thread - lightweight process
How to create the Thread
1. Thread class 2. Runnable interface

# Homework 8

Tasks: 

- Create a class that implements Runnable and prints numbers from 1 to 10. Create two threads of it and start them.
- Create a class that extends Thread and prints "Hello from thread" five times. Start two threads from this class.
- Demonstrate at least 2 constructors of the Thread class. one with no argument and one with Runnable as argument.
- Write a Java program that demonstrates the use of getName(), setName(), getState()
- Create a thread and start it. Then, try to call start() again and observe the output. Catch and print the exception message.
- Create three threads: T1, T2, and T3. Use join() such that
  - T1 starts first
  - T2 starts only after T1 completes
  - T3 starts only after T2 completes
- Create a program that performs two independent tasks(below) in two separate threads
- Printing even numbers
- Printing odd numbers


# Topic 9
Threadpool Demo

// ThreadPool

How it works?
fixed amount threads are created and kept alive.
tasks are submitted to the thread pool
threads are pick up from the thread pool and execute that task
once task has been completed then threads returns to the thread pool

Why we need to use that?
it improves the performance.

Types of ThreadPool
FixedThreadPoolExecutor - Fixed number of threads

When to use this?

No new task can be created after shutdown


CachedThreadPool - It creates new thread as need.
If any threads is in the ideal state for 60 seconds then it will automatically terminate

When to use this?
It will be used to execute small tasks

SingleThreadPoolExecutor - Only one thread will be there in pool

When to use this?
If we want to perform tasks in the sequentcially.
If ordering is matter
Thread safety
Real-time ex: Logs printing

# Homework 9

- Create a fixed thread pool of size 3. Submit 5 tasks that print the current thread name and simulate some work using Thread.sleep().
- Create a cached thread pool. Submit 10 tasks and observe that threads are reused or created based on demand.
- Use a single-threaded executor to process tasks in order.
- Manually create a ThreadPoolExecutor and understand queue capacity and rejected tasks.
- Schedule a task to run every 3 seconds, regardless of how long the task takes.
- Schedule a task to run 2 seconds after the previous execution completes.

# Topic 10
ThreadGroup:
It allows us to manage multiple threads as single unit
Advantages:
Collectively Manage
Hierarchy Support
Categorization

// Synchronization : it is a process of controlling the access of multiple threads to shared resource
methods
block
static
Advantages:
Thread safety
Data Integrity

Java Runtime Class

Singleton class
It allows to executer external command
Get memory details
Request to call to GC
Exit the JVM

Java Shutdown Hook


# Homework 10


Exercises:
- Create a ThreadGroup named "MyGroup" and add 3 threads that print their names and group name.
- Start 5 threads in a group and interrupt the entire group after 2 seconds using ThreadGroup.interrupt().
- Create a BankAccount class with synchronized deposit() and withdraw() methods. Use multiple threads to operate on the same object.
- Use Runtime.getRuntime() to print:
    - Available processors
    - Total memory
    - Free memory
- Add a shutdown hook that writes a message like "Application stopped at <time>" to the console.
 
# Topic 11

Serialization:
- It is a process of converting a JAva object into a byte stream.
- Java has Serializable interface
- Class must implement Serializable interface

- Serializable - marker interface
- Why we need to use this?
- To store the objects state inside the file, we can send the object stream over the network

- Deadlock
- Inter-thread communication

Deadlock:
Deadlock occurs when two or more thread are blocked forever. each waiting for the other to release the lock
How to avoid this deadlock?
Always accuired obj in same order
Avoid unneccesary locks

Inter-thread communication
It Allows us to pause the execution and let other thread to take over.
wait() - it release the lock and go into waiting state until another thread calls notify() or notifyAll()
notify() - Wakes up one waiting thread (randomly)
notifyAll() - Wakes up all waiting thread
It belongs to the Object class

join() vs wait/notify
join - It waits to completed the execution of the Thread
wait()/notify() - It waits until the condition satisfied

# Homework 11

Excercise:
- Demonstrate how synchronized blocks can lead to deadlock.
- Implement a Producer-Consumer pattern using wait() and notify().
- Create threads that print odd and even numbers alternately. (using inter thread communication)
- Demonstrate thread coordination using notify() and shared flags.
- Show a thread waiting for a condition to be true before proceeding.
- Serialize and deserialize a Student class with basic fields.
- Add transient fields and show their effect on serialization.
- Serialize an object that contains references to other objects.
- Serialize a list of custom objects and read them back.

# Topic 12: 

Externalization:
Advantages:
- Full control
- Only store required data
DisAdvantages:
- More Complex
- Easy forget some fields
Serialization | Externalization
- Automatice | Manually
- No method to implement | Two methods to implement
- Used trisient for exclution | you decide what to include/exclude


What is the use of the Marker Interface?

Serialization with Inheritance

Case1: Parent - Serializable, Child - Not Serializable
Case2: Parent Not Serializable, Child - Serializable
Case3: Parent - Serializable, Child - Not Serializable


GC: Garbage Collector
GC: It is a process which JVM calls automatically to destory object memory

How we can make object eligible for GC
- null reference to the Object
- Releasing the reference

Ways to call GC
1. System.gc()
2. Runtime.getRuntim().gc()

Finalization
- finalize() is a method defined in the OBject class which GC calls before destroying an object.

Collection: 

- List - ArrayList, LinkedList, Vector
  - add()
  - addAll()
  - clear()
  - remove(index)
  - remove(object)
  - size()
  - toArray()
- Set
- Map
- Queue
- TreeSet
- TreeMap

# Homework 12

Excercise:

- Serialize a subclass object where the parent class is not serializable. Observe the behavior.
- Create a custom readObject() and writeObject() in subclass and manipulate fields during serialization.
- Use transient keyword in a subclass and serialize and verify the result.
- Try serializing an object when serialVersionUID is missing, then modify the class and deserialize to see what happens.
- Create a class that implements Externalizable and override writeExternal() and readExternal().
- Omit the no-arg constructor and attempt deserialization—observe the result.
- Create two Externalizable classes with inheritance, customize serialization logic in both.
- Override the finalize() method and print a message when it's called—trigger GC and observe.
- Create and iterate over ArrayList. add, remove, search elements.
- Convert a list to array and array to list.
- Create an immutable list and try to modify it.
- Remove elements conditionally using removeIf() and Iterator.
 

# Topic 13 and HomeWork 13: 


1. ArrayList – Student Management System

Description:
Create a simple Student Management System using ArrayList to store and manage student records.

Requirements:
- Create a Student class with fields: id, name, course, and marks.
- Use an ArrayList<Student> to store the students.
- Implement the following operations:
    - Add a new student
    - Remove a student by ID
    - Update student details
    - Search for a student by name
    - Display all student records
    - Sort students by marks and display the top 3 performers


2. LinkedList – Task Scheduler / To-Do List

Description:
Design a simple task scheduling or to-do list application using LinkedList.

Requirements:
- Create a Task class with fields: id, description, priority, and timestamp.
- Use a LinkedList<Task> to store the list of tasks.
- Implement the following features:
    - Add a new task (at the end)
    - Remove a completed task (from the beginning)
    - View the next task to execute
    - Move a high-priority task to the front
    - Display all pending tasks

3. Vector – Chat Room History Manager

Description:
Build a simple chat room history feature that is safe to use in a multi-threaded environment using Vector.

Requirements:
- Create a Message class with fields: sender, timestamp, and messageText.
- Use a Vector<Message> to store all chat messages.
- Simulate multiple users (threads) adding messages to the chat.
- Implement features to:
    - Display all messages chronologically
    - Search for messages by sender name


4. Stack – Expression Validator and Evaluator

Description:
Build a utility that validates and evaluates arithmetic expressions using a Stack.

Requirements:
- Accept an infix expression (e.g., (2 + 3) * (5 - 2)) as input.
- Implement the following features:
    - Validate the balance of parentheses (), {}, []
    - Convert infix to postfix notation
    - Evaluate the postfix expression and return the result
- Display:
    - Validity of the expression
    - Postfix expression
    - Final evaluated result

# Topic 14: 

- Cursors
- Set
- HashSet
- LinkedHashSet
- TreeSet
- SortedSet
-  Fail fast & Fail Safe collections -  Imp
-  sorting
-  Comparable & Comparator - Imp


- Map : Data stored in the Key value pair

- HashMap

  - We can only store one null key but not multiple
-   We can store multiple null values

- Cursors: To iterate the collections

1. Enumeration:
- Legacy Interface
- Use on Legacy classes like Vector, HashTable
- It only supports the read operation

Advantages: It works with the Legacy classes

DisAdv: It only reads the data

2. Iterator
- introduced in Java Collection Framework
- Used to iterate the collections
- It allows modify & remove as well
- Reads data in forward direction

Advantages
- Works with the collections
- It can modify or remove elements as well

3. ListIterator:
- Extended version of Interator
- It can read data in both direction: Fwd, Bwd
- It can also modify objects in collection

Adv:
- Traverse in both direction
- modify the object as well

Fail-fast & Fail-safe conditions.
- Fail-fast: Fail-fast Iterator throws the ConcurrentModificaitonException when we make any structural changes(modify, remove, add) in the collection except via the iterator's own.

- ArrayList
- Set
- Map


- Fail-safe: It does not throw the ConcurrentModificaitonException if we make any structural changes

- CopyOnWriteArrayList

- Interview Que
- Fail-Fast - throw Exception, Thread-safe, Ex: ArrayList, HashMap etc
- Fail-Safe - Does not throw an Exception, Thread Safe . Ex: CopyOnWriteArrayList, ConcurrentHashMap

====================SET Interface=================

1. HashSet:
- Implemetns Set Interface
- Insertion order does not maintain
- It stores only unique elements

Adv: It prevents to store duplicate data

DisAdv:
- Iterator order unpredicatble
- Not Thread safe

2. LinkedHashSet

- It extends the HashSet
- It maintains the insertion order

Adv:
- It maintains the inserion order
- Data access fast compared to HashSet

DisAd:
- It slightly takes more memory(Due to it maintains the insertion order)

SortedSet - Interface

- It extends the Set Interface
- Insersion order maintain
- We can not create direct object of the SortedSet


TreeSet
- It is a concreate class
- natural sorting (alp or numerical)
- It allows custom sorting as well


Sorting
1. Comparable

- It is a natual sorting
- Implemented by class to define the default sorting

Adv: Natural sorting
DisAdv: Only one sort per class

2. Comprator: Defined custom sorting logic

- two layer sorting

Advantages:
- It allows multiple sorting strategies
- No changes needed in class

- Interview Que: What is Comparable & Comparator.


# HomeWork 14:

Excercises:

Program to traverse a Vector using Enumeration and print all elements

Program to remove even numbers from a List using Iterator

Program to update a List of tasks using ListIterator and print in reverse order

Program to store unique names using HashSet and display them

Program to store and sort strings alphabetically using TreeSet

Program to demonstrate basic operations using SortedSet like first and last element

Program to show ConcurrentModificationException by modifying ArrayList during iteration

Program to safely modify a CopyOnWriteArrayList while iterating

Program to sort a list of students by roll number using Comparable

Program to sort employees by salary using Comparator

Program to sort products by rating, then by price using multiple Comparators

Program to store and retrieve student marks using HashMap

Program to store and display contacts sorted by phone number using TreeMap


# Interview Questions:


- Explain the concept of OOP in Java.
- What is the difference between JDK, JRE, and JVM?
- What is the static keyword? Where is it used?
- What is the difference between == and .equals()?
- What is the difference between abstract class and interface?
- Can we override static methods?
- What is the purpose of the finalize() method?
- What is the difference between checked and unchecked exceptions?
- Can we write a try block without catch or finally?
- What is thread lifecycle in Java?
- What is a daemon thread?
- What is the difference between ArrayList and LinkedList?
- What is the difference between HashMap and Hashtable?
- What is the difference between fail-fast and fail-safe?
- How can you make a collection thread-safe?
- What are lambda expressions in Java?
- What are functional interfaces?
- What is the use of Optional?
- What are method references?
- What is the use of transient and volatile keywords?
- What is the difference between shallow copy and deep copy?
- Why is String immutable in Java?


# Topic 15:

//HashMap
//LinkedHashMap
//HashTable
//WeakedHashMap


- Map: key value pair

- HashMap
  - No duplicate key allowed
  - one null key and multiple null values are allowed
  - No insertion order maintained 
  - Non thread safe

- Internal working of the HashMap -> Interview Que
- It uses the hash function interanlly for the Key
- If two different key's having same has value -> LinkedList

Advantages:
- Fast access
- data stored in the key value pair

DisAdv:
- No insertion order maintained
- Not synchronized

LinkedHashMap

- subclass of HashMap
- It maintains the order

- When to use removeEldestEntry?
- When we implement LRU Cached
- when you want size bound

Advantages
- Maintains the order
- it supports removeEldestEntry method to remove last accessed element
- all hashmap benefits

DisAdv:
- It takes more memory -> due to insersion order maintains
- slightyl slower compared to HashMap
- Non thread safe

HashTable:
- It is a legacy class
- java.util
- Key value pair
- Keys are unique.
- Thread safe
- It does not allow null key or value

Internal working
- It internally uses an array of buckets
- Each bucket stores the LinkedList
- methods sychronized, put, get, remove

Advantages:
 - Thread-safe

DisAdv:
 - Due to sychronization performace slow
 - No null values or keys are allowed

Difference -> Interview Que
HashMap				HashTable
Not synchronized	synchronized
It allows 1 null
key & mul null values  Does not allowed null key or value
Fail-fast collection  It does not throw ConcurrentMOdificationException
It is fast access     slow(due to synchronization)

WeakedHashMap
- It automatically removes the entry if keys are no longer in use
- When GC called then it is automatically removes that entry

Object References
- Strong -> Never collected
- Weak -> Collected when GC runs (if no strong reference)
- Soft -> It collected only when memory is low
- Phantom -> It collected after finalization

Advantages:
- Prevents memory leaks automatically
- It works with GC

DisAdv:
- No Thread safe
- Entries can be disappear(remove) at any time
- Slower than HashMap due to GC interation

# HomeWork 15:

Excercises:

- Count word occurrences in a sentence using HashMap.
- Maintain product price list and print products in insertion order using LinkedHashMap.
- Create a login system where usernames and passwords are stored securely using Hashtable.
- Create a temporary object cache using WeakHashMap and demonstrate automatic removal of entries after GC.
- Store and display recent search history maintaining insertion order using LinkedHashMap.
- Store objects in a WeakHashMap and show how unreferenced objects are removed by garbage collector.
- Group names by their starting letters using HashMap.
- Store recently opened files in order using LinkedHashMap and remove the oldest when limit exceeds.
 
# Homework 16: 

Exercises

- Store two different String objects with same content as keys and observe both entries exist. (IdentityMap)
- Create a TreeMap and find ceiling, floor, lower, and higher keys for a given number.
- Create a task priority system where tasks with smaller numbers (higher priority) are processed first.
- Add integers to a TreeSet and find nearest lower and higher values for a given input.
- Sort a list of student names alphabetically using Collections.
- Perform binary search on a sorted list of integers to find a given number using Collections.
- Reverse the order of elements in a list of city names using Collections.
- Sort an array of integers in ascending order using Arrays.sort().
- Search for a number in a sorted array using Arrays.binarySearch().
- Convert an array of strings to a list and print all elements.
- Create a generic method that accepts an array of any type and prints its elements.
- 