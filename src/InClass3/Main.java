package InClass3;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main implements Cloneable{
    //can in whole access
    public int publicFiled = 1;

    //withing the class
    private int privatef = 2;
    //child class and packgae
    protected int protectedf = 3;

    //within the pakkage
    int defaultField = 4;

    static String staticField = "Shared";

    final String finalField = "Constant";

    transient  int transField = 999;

    volatile boolean flag = true;


    public String message(){
        return "parent";
    }

    public void performTask(){
        System.out.println("performing task");
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static  void objectCreattionExmaples() throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //new keyword
        Main obj1 = new Main();

        //using clone
        Main obj2 = (Main) obj1.clone();


        //using reflection

        Constructor<Main> cons = Main.class.getConstructor();

        Main obj3 = cons.newInstance();

        //using Class.forname
        Main obj4 = (Main) Class.forName("org.example.Main").newInstance();



    }

    public static void stringExma(){

        //immutable slow
        String s1 = "Hello";
//      s1 = "world";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1==s2);  //true (scp)
        System.out.println(s1==s3); // false (heap)
        System.out.println(s1.equals(s3));  //true (heap)

        ////mutable thread safe nahi hai faster
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);

        //mutable thread safe thoda compare builder
        StringBuffer sbu = new StringBuffer("Hello");
        sbu.append(" World");
        System.out.println(sbu);
    }

    public static void wrapperDemo(){
        int x = 10;
        Integer y = x ; //autoboxing
        int z = y; //unboxing
        System.out.println("x="+x+"y="+y+"z="+z);
    }

    public static void typeCasting(){
        double d = 10.5;
        int i = (int) d;//explicit
        long l = i; //implicit
        System.out.println(i);
        System.out.println(l);
    }

    static class MyCustomException extends Exception{
        MyCustomException(String m){
            super(m);
        }
    }
    public static void main(String[] args) throws Exception {
//     objectCreattionExmaples();
//     stringExma();
//      wrapperDemo();
//      typeCasting();
//      Main m = new Main();
//      m.finalField="10";
//      SubClass subClass = new SubClass();
//      System.out.println(subClass.message());

        try{
            throw new MyCustomException("custom");
//         System.exit(0);
//         throw  new Exception();
        }catch (MyCustomException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("hello");
        }
    }

}
//inhanritance abtracttion encapsulation
class SubClass extends Main{

    @Override
    public String message(){
        return super.message();
    }

    @Override
    public void performTask(){
        System.out.println("performing task logic");
    }
}

//https://www.pinterest.com/pin/618541330066513517/
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

//try to debug above code and understand about lambda function
