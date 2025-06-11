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
 
 
 
# Homework 7

Tasks
- Write a program to list all files and directories in a given directory.
- Write a program to read the contents of a .txt file character by character using FileReader.
- Write a program to take user input and write it to a file using FileWriter.
- Write a program to copy the contents of one file to another using BufferedReader and BufferedWriter.
- Write a program to count the number of lines and words in a file using BufferedReader.
 