import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork2 {
    static  int a = 5, b = 10, c = 0;
    static boolean x = true, y = false, result;
    static int[] arr = {1, 2, 3, 4};
    static boolean check = (Math.pow(arr[2], 2) >= 9) && (arr[1] + arr[0] < 5);
    static int d = 2;
    static long e = 5;
    static int p, q, r;

    public static void main(String[] args) {
        c = (a++ * --b > 40) ? a & b | c ^ 2 : (a << 1) + (b >> 1);
        result = (x && y) || (!x ^ y) ? x == y : x != y;
        d <<= (int)(e % 3 + 1) * 2;
        p = q = r = (5 > 3) && (7 != 2) ? (10 | 3) + 4 : 0;
//    sumOfNNumbers(10);
//multiplicationTable(5);
//        primeNumbers(50);
//        reverseNum(987654321);
        triangle(5);
    }
    //Sum of N Natural Numbers
    static  void sumOfNNumbers(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of "+ n + " Natural Numbers " +sum);
    }
    //Multiplication Table of a Number

    static  void multiplicationTable(int n) {

        for (int i = 0; i <= 10; i++) {
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }
    //Print Prime Numbers from 1 to 50
    static void primeNumbers(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            Boolean isPrime = true;
            for(int j = 2; j*j <= i; j++){
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                numbers.add(i);
            }
        }
        System.out.println(numbers);
    }
    //Reverse the Digits of a Number
    static  void reverseNum(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }
        System.out.println(reverse);
    }
    //Pattern Printing – Triangle of Numbers

    static  void triangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");

        }
    }
}
