package midterm;

import java.util.Arrays;

public class Midterm {

    /** Solution to problem 1, uses built-in sort.
     * @param arr array to turn into set.
     * @return a new array: a set of the items in arr. */
    public static int[] toSet1(int[] arr) {
        // if array is null, empty, or length 1, it's already a set:
        if (arr == null || arr.length < 2) return arr;
        // sort array with built-in sort method: O(n * log n).
        Arrays.sort(arr);
        // count how many distinct numbers appear in arr:
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (arr[i] != arr[i + 1]) {
                    count++;
                }
            }
        }
        // init ans array of length count, and put first item in:
        int[] ans = new int[count];
        ans[0] = arr[0];
        /* fill from arr:
         * go over arr from index 1.
         * compare current value to previous (at index i-1).
         * if the current value is different, add it to ans.
         * ansIndex increments only when we add to ans. */
        int ansIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                ans[ansIndex++] = arr[i];
            }
        }
        return ans;
    }
}
