import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Tirgul3 {
    public static void problem1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter N");
        int n = scan.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("enter number: ");
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                sum += arr[i];
            }
        }
        System.out.println("sum of even numbers: " + sum);
        sum = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("sum of odd numbers: " + sum);
    }

    public static void problem2(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            int t = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = t;
        }
    }

    public static int problem3a(double[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }

    public static int[] problem3b(double[][] arr){
        int max_i = 0, max_j = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > arr[max_i][max_j]) {
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return new int[]{max_i, max_j};
    }

    public static void problem4(int[] arr){
        for (int i : arr){
            System.out.print(i);
        }
    }

    public static void problem4(double[] arr){
        double max = arr[problem3a(arr)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
    }

    public static int[] problem5(int n, int a, int b){
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(a, b);
        }
        return arr;
    }

    public static int problem6a(int n){
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0){
                sum += i;
            }
        }
        return sum;
    }

    public static boolean problem6b(int n){
        return problem6a(n) == n;
    }

    public static void problem6c(int n){
        for (int i = 0; i <= n; i++) {
            if (problem6b(i)) System.out.print(i + ", ");
        }
    }

    public static int[][] problem7b(int[][] matrix){
        int[][] temp_matrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp_matrix[j][i] = matrix[i][j];
            }
        }
        return temp_matrix;
    }

    public static void main(String[] args) {
        int[] my_arr = new int[]{1, 2, 3, 4};
        problem2(my_arr);
        System.out.println(Arrays.toString(my_arr));

        String[][] arr = {{"Plus", "yellow", "track"}, {"heart"}, {"orange", "night"}, {"\n"}};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j].charAt(0));
            }
        }

        System.out.println(problem3a(new double[]{2, 4, 5, 8, 45, 2, 4}));
        double[] my_arr2 = new double[]{1, 2, 3, 4, 5};
        problem4(my_arr2);
        System.out.println(Arrays.toString(my_arr2));

        int[] my_arr3 = problem5(8, 3, 19);
        System.out.println(Arrays.toString(my_arr3));

        problem6c(9999);
        System.out.println("\n");

        int[][] matrix = {{11, 12, 13, 14, 15, 16}, {21, 22, 23, 24, 25, 26}, {31, 32, 33, 34, 35, 36}, {41, 42, 43, 44, 45, 46}};
        matrix = problem7b(matrix);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
