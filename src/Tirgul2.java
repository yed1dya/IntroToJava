import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Tirgul2 {
    public static void problem1a(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        System.out.println("1 + 2 + ... + N = " + n * (n + 1) / 2);
    }

    public static void problem1b(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("1 + 2 + ... + N = " + sum);
    }

    public static void problem2(){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("enter number " + (i+1));
            arr[i] = scan.nextInt();
        }
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        System.out.println("average: " + ((double)sum / 3));
    }

    public static void problem3(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void problem4(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        long n = scan.nextLong();
        System.out.println("enter X");
        int x = scan.nextInt();
        if (n == 0 && x == 0){
            System.out.println(1);
        }
        else {
            int count = 0;
            while (n > 0){
                if (n % 10 == x){
                    count++;
                }
                n /= 10;
            }
            System.out.println(count);
        }
    }

    public static void problem5(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter M");
        int n = scan.nextInt();
        System.out.println("enter N");
        int m = scan.nextInt();
        long res = 1;
        for (int i = 0; i < m; i++) {
            res *= n;
        }
        System.out.println(res);
    }

    public static void problem6(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter x");
        float x = scan.nextFloat();
        System.out.println("enter y");
        float y = scan.nextFloat();
        System.out.println("enter z");
        float z = scan.nextFloat();
        float t;
        if (x > y){
            t = x; x = y; y = t;
        }
        if (y > z){
            t = y; y = z; z = t;
        }
        if (x > y){
            t = x; x = y; y = t;
        }
        System.out.println("min: " + x + ", max: " + z);
    }

    public static void problem7(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a");
        float a = scan.nextFloat();
        System.out.println("enter b");
        float b = scan.nextFloat();
        System.out.println("enter c");
        float c = scan.nextFloat();
        double discriminant = b*b - 4*a*c;
        if (discriminant < 0){
            System.out.println("no roots");
        }
        else{
            double squareRoot = Math.sqrt(discriminant);
            System.out.println("X1 = " + ((-b - squareRoot) / 2*a));
            System.out.println("X2 = " + ((-b + squareRoot) / 2*a));
        }
    }

    public static void problem8(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        long ans = 1;
        while (n > 1){
            ans *= n--;
        }
        System.out.println(ans);
    }

    public static void problem9(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        int[] arr = new int[n];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            System.out.print("enter num: ");
            arr[i] = scan.nextInt();
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        System.out.println("average: " + ((double)sum / n) + ", max: " + max);
    }

    public static void problem10(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter string");
        String s = scan.next();
        if (s.length() >= 9){
            if (s.substring(2, 5).equals(s.substring(6, 9))){
                System.out.println("places 2-4 equal to places 6-8");
            }
            else{
                System.out.println("places 2-4 not equal to places 6-8");
            }
        }
        else{
            System.out.println("not long enough");
        }
    }

    public static void problem11(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        if (n % 2 == 1){
            for (int i = 1; i <= n; i+=2) {
                for (int j = 0; j < (n-i)/2; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < i; j++) {
                    System.out.print('*');
                }
                System.out.println();
            }
        }
        else {
            for (int i = 2; i <= n; i+=2) {
                for (int j = 0; j < (n-i)/2; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }

    public static void problem12(){
        for (int i = 1; i <= 100; i++){
            String s = "";
            if (i < 10){
                s += " ";
            }
            s += i + " ";
            System.out.print(s);
            if (i % 10 == 0){
                System.out.println();
            }
        }
    }

    public static void problem13(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print('*');
        }
        System.out.println();
        for (int i = 0; i < n - 2; i++){
            System.out.print('*');
            for (int j = 0; j < n - 2; j++){
                System.out.print(' ');
            }
            System.out.println('*');
        }
        for (int i = 0; i < n; i++){
            System.out.print('*');
        }
    }

    public static void problem14(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i * j < 10) System.out.print(" ");
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    public static void problem15(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter string");
        String s = scan.next().toLowerCase();
        int len = s.length();
        boolean palindrome = true;
        for (int i = 0; i < len; i++){
            if (s.charAt(i) != s.charAt(len - i - 1)){
                palindrome = false;
                break;
            }
        }
        if (palindrome){
            System.out.println("palindrome");
        }
        else {
            System.out.println("not a palindrome");
        }
    }

    public static void problem16(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= n / 2; i++){
            if (n % i == 0){
                sum += i;
            }
        }
        if (sum == n){
            System.out.println("perfect number");
        }else {
            System.out.println("not perfect");
        }
    }

    public static void problem17(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number");
        int n = scan.nextInt();
        int d = n % 10;
        n /= 10;
        boolean mono = true;
        while (n > 0 && mono){
            if (n % 10 > d){
                mono = false;
            }
            d = n % 10;
            n /= 10;
        }
        if (mono){
            System.out.println("monotone");
        }else{
            System.out.println("not monotone");
        }
    }

    public static void problem18(){
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        System.out.println("enter number");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print(r.nextInt(1, 7) + " ");
        }
    }

    public static void problem19(){
        Random r = new Random();
        int n = r.nextInt(1, 101);
        Scanner scan = new Scanner(System.in);
        int guess = 0, count = 0;
        while (guess != n){
            System.out.println("guess a number:");
            guess = scan.nextInt();
            count++;
            if (guess < n) System.out.println("too small");
            if (guess > n) System.out.println("too big");
        }
        System.out.println("you got it! the number was " + n + "\ntook you " + count + " guesses.");
    }

    public static void main(String[] args) {
        problem16();
    }
}
