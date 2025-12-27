package tirgul4;

import java.util.Arrays;

public class Tirgul4 {

    // question 1
    public static int sumToN(int n){
        int ans = -1;
        if (n >= 0){
            ans = 0;
            while (n > 0){
                ans += n;
                n--;
            }
        }
        return ans;
    }

    // question 2
    public static boolean isPalindrome(String s){
        if (s == null || s.length() < 2) return true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }

    // question 3
    // Source - stackoverflow
    public static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static boolean isPalindromeIgnoreSpecial(String s){
        if (s == null || s.length() < 2) return true;
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isLetterOrDigit(s.charAt(i))){
                t.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return isPalindrome(t.toString());
    }

    // question 4
    public static String reverse(String s){
        if (s == null || s.length() < 2) return s;
        StringBuilder t = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            t.append(s.charAt(i));
        }
        return t.toString();
    }

    // question 5
    public static double average(int[] arr){
        if (arr == null || arr.length == 0) return 0.0;
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return (double) sum / arr.length;
    }

    // question 6
    public static int[][] transpose(int[][] matrix){
        if (matrix == null || matrix.length == 0) {
            return new int[0][];
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] transposed = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                transposed[j][i] = matrix[i][j] + 1;
            }
        }

        return transposed;
    }

    // question 7
    public static int sumSlice(int[][][] data, int depth) {
        if (data == null || data.length == 0) return 0;
        if (depth < 0 || depth >= data.length) return 0;
        // Access the specific 2D slice
        int[][] slice = data[depth];
        int sum = 0;
        // Iterate through the rows (1st dimension of the slice)
        for (int[] row : slice) {
            // Check for potential empty or null rows (ragged array handling)
            if (row != null) {
                // Iterate through the elements (2nd dimension of the slice)
                for (int element : row) {
                    sum += element;
                }
            }
        }
        return sum;
    }

    // question 8
    public static int findMax(int[][][] data) {
        // Handle null or empty array
        if (data == null || data.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        // Loop 1: Depth (Pages)
        for (int[][] slice : data) {
            if (slice != null) {
                // Loop 2: Row
                for (int[] row : slice) {
                    if (row != null) {
                        // Loop 3: Column (Element)
                        for (int element : row) {
                            if (element > max) {
                                max = element;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    // question 9
    public static int[] findMaxQuantityLocation(int[][][][] inventory) {
        if (inventory == null || inventory.length == 0) return new int[0];
        // Initialize variables to track the maximum quantity and its location
        int maxQuantity = Integer.MIN_VALUE;
        // The result array: [Store, Aisle, Shelf, Item ID]
        int[] maxLocation = new int[4];

        // Loop 1: Store (S)
        for (int s = 0; s < inventory.length; s++) {
            int[][][] store = inventory[s];
            if (store == null) continue;

            // Loop 2: Aisle (A)
            for (int a = 0; a < store.length; a++) {
                int[][] aisle = store[a];
                if (aisle == null) continue;

                // Loop 3: Shelf (L)
                for (int l = 0; l < aisle.length; l++) {
                    int[] shelf = aisle[l];
                    if (shelf == null) continue;

                    // Loop 4: Item ID (I)
                    for (int i = 0; i < shelf.length; i++) {
                        int currentQuantity = shelf[i];

                        if (currentQuantity > maxQuantity) {
                            maxQuantity = currentQuantity;

                            // Update the location array
                            maxLocation[0] = s; // Store
                            maxLocation[1] = a; // Aisle
                            maxLocation[2] = l; // Shelf
                            maxLocation[3] = i; // Item ID
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(inventory));
        System.out.println(Arrays.toString(maxLocation));
        return maxLocation;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{11, 12, 13, 14, 15, 16}, {21, 22, 23, 24, 25, 26}, {31, 32, 33, 34, 35, 36}, {41, 42, 43, 44, 45, 46}};
        int[][] matrix3 = {{11, 12}, {21, 22}, {31, 32}, {41, 42}};
        System.out.println(Arrays.deepToString(transpose(matrix1)).replace('[', '{').replace(']', '}'));
        System.out.println(Arrays.deepToString(transpose(matrix2)).replace('[', '{').replace(']', '}'));
        System.out.println(Arrays.deepToString(transpose(matrix3)).replace('[', '{').replace(']', '}'));
    }
}
