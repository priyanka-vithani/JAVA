package InClass5;

import java.nio.file.attribute.UserPrincipal;

public class Main{

    static class User{
        String name;
        int age;
        public User(){
            System.out.println("default contructor");
        }
        public User(String name){
            this.name = name;
            System.out.println("user with only name:"+name);
        }

        public User(String name,int age){
            this.name = name;
            this.age = age;
            System.out.println("user with name an age:"+name+" "+age);

        }
    }

    static class UserChild extends User{
        public UserChild(){
            super();
//          super();
//         super("himalay",22);
            System.out.println("userchild");
        }

        public UserChild(int age){
            super();
//         this();
            System.out.println("userchild with parameter");
        }

    }

    static class Calculator{
        public int add(int a,int b){
            return a+b;
        }

        public int add(int a,int b,int c){
            return a+b+c;
        }

        public double add(double a,double b){
            System.out.println("double");
            return a+b;
        }


        // wrong method overovering (only return type difffer(not allowed)(access modifer also same way)
//      private int add(int a,int b){
//         return  a+b;
//      }
    }

    static class  Vehicle{
        void start(){
            System.out.println("vehicle started");
        }
    }
    static class Car extends Vehicle{
        void drive(){
            System.out.println("car is driving!");
        }

        void add(){

        }
    }

    static class SportCar extends Car{
        void boost(){
            System.out.println("boosting sport car!");
        }
        void add(){

        }
    }

    static class Truck extends Vehicle{
        void load(){
            System.out.println("truck is loading something!");
        }
    }

    //not supported multiple inharitance why ( java compiler confuse ho jayega if vehicle and sportcar having same method so it does not know which one to call!)
//   static class A extends Vehicle,SportCar{
//
//   }

    interface MusicPlayer{
        void play();

        default void greet(){
            System.out.println("music player calling");
        }

    }


    interface VideoPlayer{
        void play();

//      default void greet(){
//         System.out.println("videoplayer calling!");
//      }

//      static void add(){
//         System.out.println("hello");
//      }

    }

    static class SmartDevice implements MusicPlayer,VideoPlayer{

        @Override
        public void play() {
            System.out.println("smartdevice palying");
        }

//      public void greet(){
//         MusicPlayer.super.greet();
//         VideoPlayer.super.greet();
//      }
    }

    static class Animal{
        void sound(){
            System.out.println("Animal make sound");
        }

        void sleep() throws Exception{
            System.out.println("animal sleeeps");
        }
    }

    static class Dog extends Animal{
        void sound(){
            System.out.println("dog barks");
        }

        // jo apun log ne parent class throws kar raha uska hamesha child wala hi exception apun log child class me throws karva sakte
        void sleep() throws java.io.IOException{
            System.out.println("dogs sleeps");
        }
    }


    //Real-wrold  define template for payment service
    abstract static class  Payment{
        abstract void  pay(double amout);

        void paymentGateway(){
            System.out.println("connecting the payment gatewat");
        }

    }

    static class CreditCardPayment extends Payment{
        @Override
        void pay(double amout) {
            System.out.println("Paid "+amout+"using creditcard");
        }
    }

    static class Upi extends Payment{

        @Override
        void pay(double amout) {
            System.out.println("Paid "+amout+"using upi");
        }
    }


    static class Person{
        private String name;

        private int age;


        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name= name;
        }

        public int getAge(){
            return age;
        }

        public void setAge(int age){
            if(age>0){
                this.age = age;
            }
            else{
                System.out.println("invalida age!");
            }
        }



    }

    public static void main(String[] args) throws Exception {
        //overloading
//      new User();
//      new User("himalay");
//      new User("ambika",25);

        //method overloading

//      Calculator  c = new Calculator();
//      System.out.println(c.add(10,20));
//      System.out.println(c.add(10,20,30));
//      System.out.println(c.add((double) 10,(double) 20));

        //Inharitance
        //single inharitance
//      Car car = new Car();
//      car.start();
//      car.drive();

        //multilevel inharitance
//      SportCar sportCar = new SportCar();
//      sportCar.start();
//      sportCar.drive();
//      sportCar.boost();

        //hirarchical inharitance
//      Truck t = new Truck();
//      t.start();
//      t.load();

        //multiple inharitance

//      SmartDevice smartDevice = new SmartDevice();
//      smartDevice.play();
//      smartDevice.greet();
//       Animal dog = new Dog();
//       dog.sleep();

//      Payment credit = new CreditCardPayment();
//      credit.pay(100);
//
//      Payment upi = new Upi();
//      upi.pay(100);


        //Encapsulation exmaple (binding similar type of properties of the object into single unit (class exmpaple))
//      Person p = new Person();
//      p.setName("himalay");
//      p.setAge(24);
//
//      System.out.println("name:"+p.getName());
//      System.out.println("age:"+p.getAge());
//
//      p.setAge(-3);
//
//      System.out.println("age:"+p.getAge());

        UserChild userChild = new UserChild(22);

    }
}


