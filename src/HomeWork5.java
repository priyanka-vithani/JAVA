import javax.xml.namespace.QName;

public class HomeWork5 {
    public static void main(String[] args) {
        
//        new Employee();
//        new Employee("Priyanka", 50000.00);
//        new Employee("Jay", 70000.00, "Android");

//        MathUtils multiply = new MathUtils();
//        System.out.println("multiplication of int and int: " + multiply.multiply(10, 20));
//        System.out.println("multiplication of Double and Double: " +  multiply.multiply(10.5, 20.5));
//        System.out.println("multiplication of int, int and int: " +  multiply.multiply(10, 20, 30));

//        Dog d = new Dog();
//        d.bark();
//        d.eat();

//        C c = new C();
//        c.methodC();
//        c.methodB();
//        c.methodA();

//        Circle circle = new Circle();
//        System.out.println("circle: " + circle.area(10));
//
//        Rectangle rectangle = new Rectangle();
//       System.out.println("rectangle: " +  rectangle.area(10,20));

//        Duck duck = new Duck();
//        duck.move();

//        Printer colorPrinter = new ColorPrinter();
//        colorPrinter.print();

        //Create an array of Animal type and store Dog, Cat, Cow objects. Call sound() method using polymorphism.

//        Animal[] animals = new Animal[3];
//        animals[0] = new Cat();
//        animals[1] = new Dog();
//        animals[2] = new Cat();
//
//        for(int i = 0; i < animals.length; i++){
//            animals[i].sound();
//        }
//        for (Animal animal : animals){
//            animal.sound();
//        }

//        BankAccount savings = new SavingsAccount();
//        savings.withdraw(500);
//
//        BankAccount current = new CurrentAccount();
//        current.withdraw(500);

//        Student student = new Student();
//        student.setName("Priyanka");
//        student.setMarks(99);
//        System.out.println("student naming " + student.getName() + " marks " + student.getMarks());

        //Demonstrate type casting: (a) int to double, (b) double to int, (c) upcasting and downcasting with classes.

//        int a = 10;
//        double b = a;
//
//        System.out.println("int to double: "+b);
//
//        double pi = 3.14;
//        int i = (int) pi;
//        System.out.println("double to int: "+i);
//
//        Animal dog = new Dog();
//        dog.sound();
//
//        Dog d = (Dog) dog;
//        d.bark();
//        d.sound();

//     new BaseB();

//        try {
//            double result = divide(10, 0);
//            System.out.println("Division Result: " + result);
//        }catch (Exception e){
//            System.out.println("error: " + e.getMessage());
//        }


        //Create Integer and Double wrapper objects using autoboxing. Do arithmetic using unboxed values.
//Integer intObj = 10;
//Double doubleObj = 10.0;
//System.out.println(intObj);
//System.out.println(doubleObj + doubleObj);
//
//int intVal = intObj;
//double doubleVal = doubleObj;
//
//System.out.println(intVal + doubleVal);

//Book b1 = new Book("Java HomeWork", "Priyanka");
//Book b2 = new Book("Java ClaWork", "Priyanka");
//
//System.out.println("Book 1: " + b1.toString());
//System.out.println("Book 2: "+ b2.toString());
//
//System.out.println("is b1 == b2: "+b1.equals(b2));
//System.out.println("is b1 auther == b2 auther: "+b1.author.equals(b2.author));
//System.out.println(" is b1 title == b2 title: " + b2.title.equals(b1.title));
//
//System.out.println("b1 auther hash code" + b1.author.hashCode());
//System.out.println("b2 auther hash code" + b2.author.hashCode());
//System.out.println("b1 title hash code" + b1.title.hashCode());
//System.out.println("b2 title hash code" + b2.title.hashCode());
//System.out.println("b2 hash code" + b2.hashCode());
//System.out.println("b1 hash code" + b1.hashCode());

//        FinalDemo finalDemo = new FinalDemo("Priyanka");
//        finalDemo.sayHello();
//        finalDemo = null;
//
//        System.gc();
//        System.out.println("GC Called");


//        EmployeeClass manager = new Manager(20, "Priyanka", 123, 50000, "Java Developer" );
//        EmployeeClass developer = new Developer("Java", "Jay", 100, 100000, "Java Developer" );
//
//        manager.displayDetails();
//        manager.work();
//
//        developer.displayDetails();
//        developer.work();

    }
    //Create method divide(int a, int b) that throws ArithmeticException if b == 0. Handle in the main method.

//    static double divide(int a,int b) throws ArithmeticException{
//        if(b==0){
//            throw new ArithmeticException("do not divide by zero");
//        }else {
//            return a/b;
//        }
//    }



}
//Create a class Employee with overloaded constructors: (1) only name, (2) name and salary, (3) name, salary, and department.
class Employee{
    String name;
    Double salary;
    String department;
    public Employee(){
        System.out.println("Default Constructor");
    }
    public Employee(String name, Double salary){
        this.name = name;
        this.salary = salary;
        System.out.println("Name and Salary Constructor: " + name + " " + salary);
    }
    public Employee(String name,Double salary,String department){
        this.name=name;
        this.salary=salary;
        this. department = department;
        System.out.println("Name, Salary and Department Constructor: " + name + " " + salary + " " + department);
    }
}
//Create a class MathUtils with overloaded methods multiply(int, int), multiply(double, double), and multiply(int, int, int).

class MathUtils{

    public  int multiply(int a,int b){
        return a*b;
    }
    public  double multiply(double a,double b){
        return a*b;
    }
    public double multiply(int a,int b,int c){
        return a*b*c;
    }
}
//
//Create a base class Animal with a method eat(). Inherit it in class Dog with a method bark(). Call both methods.
class Animal{
    public Boolean eat(){
        System.out.println("eat");
        return true;
    }

    void sound(){
        System.out.println("sound");
    }
}
class Dog extends Animal{
    public Boolean bark(){
        System.out.println("bark");
        return true;
    }

    @Override void sound(){
        System.out.println("Dog sound");
    }
}

class Cat extends Animal{
    public Boolean bark(){
        System.out.println("bark");
        return true;
    }

    @Override void sound(){
        System.out.println("Cat sound");
    }
}

class Cow extends Animal{
    public Boolean bark(){
        System.out.println("bark");
        return true;
    }
    @Override void sound(){
        System.out.println("Cow sound");
    }
}
//Create classes A → B → C in multilevel inheritance. Each adds its own method. Call all from class C object.
class A{
    public void methodA(){
        System.out.println("methodA");
    }
}

class B extends A{
    public void methodB(){
        System.out.println("methodB");
    }
}
class C extends B{
    public void methodC(){
        System.out.println("methodC");
    }
}
//
//Create a class Shape with method area(). Inherit Circle and Rectangle from it. Override area() in both.

class Shape{
    public double area(){
        return 3.14;
    }
}
class Rectangle extends Shape{
    public double area(int a,int b){
        return a*b;
    }
}
class Circle extends Shape{
    public double area(int r){
        return Math.PI*r*r;
    }
}

//Create interfaces Flyable and Swimmable, both with move() method. Implement both in class Duck.

interface Flyable{
    void move();
}
interface Swimable{
    void move();
}

class Duck implements Flyable,Swimable{
    public void move(){
        System.out.println("move");
    }
}
//
//Create class Printer with method print(). Override it in subclass ColorPrinter. Call using superclass reference.

class Printer{
    void print(){
        System.out.println("print");
    }
}
class ColorPrinter extends Printer{
    void print(){
        System.out.println("Color Print");
    }
}
//

//
//Create abstract class BankAccount with abstract method withdraw(). Extend it in SavingsAccount and CurrentAccount.
//
abstract class BankAccount{
    double TotalBalance = 2000.0;
    abstract void withdraw(double amount);
}

class SavingsAccount  extends BankAccount{
    @Override
    void withdraw(double amount){

        TotalBalance -= amount;
        System.out.println("withdraw from Savings Account: " + amount);
        System.out.println("Remaining Balance after withdrawal from Savings Account: " + TotalBalance);
    }
}

class CurrentAccount   extends BankAccount{
    @Override
    void withdraw(double amount){
        TotalBalance -= amount;
        System.out.println("withdraw from Current Account: " +  amount);
        System.out.println("Remaining Balance after withdrawal from Current Account: " + TotalBalance);
    }

}
//Create class Student with private fields. Add public getter/setter with validation (marks 0–100 only).

class Student {
    private String name;
    private int marks;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100){
            System.out.println("Invalid Marks");
        }else {
            this.marks = marks;
        }
    }
}
//
//

//        Create class A with constructor printing "A". Extend it in class B, use super() and this() in constructors.
class BaseA{
    int a;
    BaseA(){
        this.a = 1;
        System.out.println("A - " + a);
    }
}
class BaseB extends BaseA{
   BaseB(){
       super();
       super.a = 10;
       System.out.println("B - " + a);
   }
}

//
//

//
//        Override toString(), equals(), and hashCode() in class Book. Create and compare two Book objects.

class Book{
    String title;
    String author;
    Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + '}';
    }
    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return this.title == book.title && this.author == book.author;
    }
    @Override
    public int hashCode() {
        return this.title.hashCode() + this.author.hashCode();
    }

}
//
//Create class with final variable, final method, and final class. Show example of finalize() before GC.

final class FinalDemo{
    final String name;

    FinalDemo(String name){
        this.name = name;
    }

    final  void sayHello(){
        System.out.println("Hello" + name);
    }

//    @Override
//    public void finalize(){
//        System.out.println("finalize called");
//    }
}
//
//Design an employee hierarchy: Employee (base), Manager and Developer (subclasses). Use all OOP concepts.
// Abstract Employee Class
abstract class EmployeeClass{
    String name;
    int id;
    Double salary;
    String department;

    //Constructor (Encapsutaion)

    public EmployeeClass(String name, int id, double salary, String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    //Getters (Encapsulation)
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public Double getSalary(){
        return salary;
    }
    public String getDepartment(){
        return department;
    }

    // Abstract method (Polymorphism)
    public abstract void work();

    //Concrete Method
    public void displayDetails(){
        System.out.println("Name: " + name + ", id: " + id + ", salary: $" + salary + ", department: " + department );
    }

}

class Manager extends EmployeeClass{
    int teamSize;

    public Manager(int teamSize, String name, int id, double salary, String department) {
        this.teamSize = teamSize;
        super(name, id, salary, department);
    }
    @Override
    public void work() {
        System.out.println(super.name +" is the manager of team " + department + "containing team size of " + teamSize);
    }
}

class Developer extends EmployeeClass{
    String progLang;

    public Developer(String progLang, String name, int id, double salary, String department) {
        super(name, id, salary, department);
        this.progLang = progLang;
    }

    @Override
    public void work() {
        System.out.println(super.name + " is the Developer using programming Language " + progLang);
    }
}

//class Developer extends EmployeeClass{
//String progLang;
//
//public Developer(String progLang, String name, String department, int id,  double salary){
//    super(name,id,salary,department);
//    this.progLang = progLang;
//}
//
//@Override
//public void work(){
//    System.out.println(name + " is working on programming language " + progLang);
//}
//}