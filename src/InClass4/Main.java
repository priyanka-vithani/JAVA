package InClass4;


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
