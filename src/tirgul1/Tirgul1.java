package tirgul1;

import java.util.Scanner;
public class Tirgul1 {
    public static void main(String[] args) {
    }

    public static void problem1(){
        Scanner scan = new Scanner(System.in);
        int x;
        int y;
        System.out.println("first number");
        x = scan.nextInt();
        System.out.println("second number");
        y = scan.nextInt();
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("swapping...");
        int t = x;
        x = y;
        y = t;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

    public static void problem2(){
        Scanner scan = new Scanner(System.in);
        int x, y;
        System.out.println("first number");
        x = scan.nextInt();
        System.out.println("second number");
        y = scan.nextInt();
        int avg = (x + y) / 2;
        System.out.println("average (rounded): " + avg);
    }

    public static void problem3(){
        Scanner scan = new Scanner(System.in);
        System.out.println("first number");
        float x = scan.nextFloat();
        System.out.println("second number");
        float y = scan.nextFloat();
        float avg = (x + y) / 2;
        System.out.println("average: " + avg);
    }

    public static void problem4(){
        Scanner scan = new Scanner(System.in);
        System.out.println("first number");
        int x = scan.nextInt();
        System.out.println("second number");
        int y = scan.nextInt();
        float avg = (float) (x + y) / 2;
        System.out.println("average (exact): " + avg);
    }

    public static void problem5(){
        Scanner scan = new Scanner(System.in);
        System.out.println("first number");
        int x = scan.nextInt();
        System.out.println("second number");
        int y = scan.nextInt();
        System.out.println("remainder of x / y: " + x % y);
    }

    public static void problem6(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter 3-digit number");
        int x = scan.nextInt();
        int sum = x % 10;
        x /= 10;
        sum += x % 10;
        x /= 10;
        sum += x % 10;
        System.out.println("digit sum: " + sum);
    }

    public static void problem7(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter radius");
        float r = scan.nextFloat();
        System.out.println("enter C for circumference or A for area");
        String x = scan.next().toLowerCase();
        if(x.equals("a")){
            System.out.println("area: " + (Math.PI * r * r));
        } else if (x.equals("c")) {
            System.out.println("circumference: " + (Math.PI * r * 2));
        }
        else {
            System.out.println("bad input");
        }
    }

    public static void problem8() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number of seconds");
        int seconds = scan.nextInt();
        int hours = seconds / 3600;
        seconds -= hours * 3600;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}