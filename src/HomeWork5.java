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

    }
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
    abstract void withdraw(double amount);
}

class SavingsAccount  extends BankAccount{
    void withdraw(double amount){
        System.out.println("withdraw from Savings Account");
    }
}

class CurrentAccount   extends BankAccount{
    void withdraw(double amount){
        System.out.println("withdraw from Current Account");
    }

}
//Create class Student with private fields. Add public getter/setter with validation (marks 0–100 only).
//
//Demonstrate type casting: (a) int to double, (b) double to int, (c) upcasting and downcasting with classes.
//
//        Create class A with constructor printing "A". Extend it in class B, use super() and this() in constructors.
//
//Create method divide(int a, int b) that throws ArithmeticException if b == 0. Handle in main method.
//
//Create Integer and Double wrapper objects using autoboxing. Do arithmetic using unboxed values.
//
//        Override toString(), equals(), and hashCode() in class Book. Create and compare two Book objects.
//
//Create class with final variable, final method, and final class. Show example of finalize() before GC.
//
//Design an employee hierarchy: Employee (base), Manager and Developer (subclasses). Use all OOP concepts.