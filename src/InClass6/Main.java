package InClass6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void defaultExceptionDemo(){
        System.out.println("----Default exception handling demo-----");
        int a = 10,b=0;
        int result = a/b;  // will thow ArithmaticExeption

        System.out.println("result: "+result);
    }

    public static void tryCatchFinnallyDemo(){
        System.out.println("--- try catch and finnaly demo----");
        try{
            int a = 10,b=0;
            int result = a/b;
        }
//      System.out.println("compile time error");
        catch (Exception e){
            System.out.println("caught exception: "+e);
        }
//      System.out.println("compile time error");
        finally {
            System.out.println("this block always executes");
        }
        System.out.println("compile time error");
    }

    public static  void throwKeywordDemo(){
        try{

            System.out.println("-- throw keyword demo ---");
            int age = 15;
            if(age<18){
                throw  new ArithmeticException("not eligible for votting");
            }
        }catch (Exception e){

        }
    }

    static  class  InvalidMarksException extends Exception{
        public InvalidMarksException(String message){
            super(message);
        }
    }

    public static void custumExceptionDemo(int marks) throws InvalidMarksException{


        if(marks>100 || marks<0){
            throw new InvalidMarksException("marks should be between 0 and 100");
        }
        else{
            System.out.println("Valid marks: "+marks);
        }

    }

    public static void tryWithReousesDemo() {

        try(BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter something: ");
            String input = br.readLine();
            System.out.println("you entered: "+input);
//         br.close();
        }catch (IOException ioException){

        }


    }

    public static void multiCatchDemo(){
        try{
            String s = null;
            int a = 10/0;
            System.out.println(s.length());
        }catch (ArithmeticException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


    public static void finalFinallyfinalizeDemo(){
        final  int x = 10;
//      x =20; //cant change once it is assigned
        try{
            int a = 5/0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("this is finnally block");
        }
        Main obj = new Main();
        obj = null;
        System.gc();
        System.out.println("hello");
    }

    protected void finalize(){
        System.out.println("finalize called!");
    }


    class  Outer{
        int x =10;
        class Inner{
            void show(){
                System.out.println("accessing from outer x from inner : "+x);
            }
        }
    }

    public void methodLocalInnerClass(){
        class LocalInner{
            void msg(){
                System.out.println("inside method local inner class");
            }
        }
        LocalInner l = new LocalInner();
        l.msg();
    }

    static class StaticInner{
        static void display(){
            System.out.println("inside static inner class");
        }
    }

    interface I1{
        public void run();
    }
    public void annonymousInnerClassDemo(){
        I1 r = new I1() {
            @Override
            public void run() {
                System.out.println("Running annomynous class");
            }
        };
        r.run();
    }


    interface EmailSender{
        void send();
        class DefaultImpl{
            void sendDefault(){
                System.out.println("default emailsender sedndinf mail");
            }
        }
    }

    interface  OuterInterface{
        interface  InnerInterface{
            void hello();
        }
    }


    public static void main(String[] args) throws Exception,IOException,ArrayIndexOutOfBoundsException {
        Main d = new Main();
//      Himalay himalay = new Himalay();
//      defaultExceptionDemo();

//      tryCatchFinnallyDemo();
//      System.out.println("hello");
//      throwKeywordDemo();
//      System.out.println("hello");

//         throwKeywordDemo();

//      custumExceptionDemo(101);


//      tryWithReousesDemo();
//      System.out.println("hello");

//      multiCatchDemo();

      finalFinallyfinalizeDemo();

//      Main.Outer outer = d.new Outer();
//      Main.Outer.Inner innter =  outer.new Inner();
//      innter.show();

//      d.methodLocalInnerClass();
//      StaticInner.display();

//      d.annonymousInnerClassDemo();

//      EmailSender.DefaultImpl impl =  new EmailSender.DefaultImpl();
//      impl.sendDefault();

//      OuterInterface.InnerInterface innerInterface = new OuterInterface.InnerInterface(){
//
//         @Override
//         public void hello() {
//            System.out.println("hello");
//         }
//      };
//      innerInterface.hello();
//      Database db = new Database();
//      Database.Connection.add();
//        Database.Connection conn = new Database.Connection(){
//
//            @Override
//            public void connect() {
//                System.out.println("connect");
//            }
//        };

    }
}
class Database{
    interface Connection{
        void connect();

        default void add(){
            System.out.println("add");
        }
    }
}

//https://rollbar.com/blog/java-exceptions-hierarchy-explained/
//https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/
//https://www.shiksha.com/online-courses/articles/difference-between-throw-and-throws/
