import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();
        method4();
    }
    //✅ 1. While Loop & Do-While Loop
    //Write a while loop that prints numbers from 10 to 1 in reverse.
    static void method1(){
        int a=10;
        while (a != 0){
            System.out.println(a);
            a--;
        }
    }
    //Q2. Write a do-while loop that keeps asking the user to enter a number until they type a number > 100.
    static void method2(){
        Scanner input = new Scanner(System.in);
        int number = 110;
        System.out.println("Do While Loop Demo--------");
        do{
            System.out.println("Please ecter number greater than 100");
            number = input.nextInt();

        }while (number < 100);
    }
    //Q3. What's the key difference between while and do-while? Show using an example with i = 100.
    static void method3(){
        Scanner input = new Scanner(System.in);
        int number = 110;
        System.out.println("While Loop Demo--------");
        while (number < 100){
            System.out.println("Please ecter number greater than 100");
            number = input.nextInt();
        }
    }
//✅ 2. Break and Continue
    //Q1. Use a break to stop a loop when the sum of numbers exceeds 50.

    static void method4(){
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
            if (sum >= 50){
                System.out.println(sum);
                break;
            }
        }
    }
    //Q2. Use continue to skip even numbers from 1 to 10 and print only odd numbers.
    static void method5(){
        
    }
}
