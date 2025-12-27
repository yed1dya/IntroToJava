package tirgul5;

public class Tirgul5 {
    /**
     * swaps the elements at indices i, j in array A.
     * @param A array of ints.
     * @param i first index.
     * @param j second index.
     */
    public static void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void BubbleSort(int[] A){
        int len = A.length;
        boolean swapped;
        for (int i = 0; i < len - 1; i++) {
            swapped = false;
            for (int j = i; j < len - 1; j++) {
                if (A[j] > A[j + 1]){
                    swap(A, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void SelectionSort(int[] A){
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < len; j++) {
                if (A[j] < A[min_idx]) {
                    min_idx = j;
                }
            }
            swap(A, i, min_idx);
        }
    }

    public static void InsertionSort(int[] A){
        int len = A.length;
        for (int i = 1; i < len; i++) {
            int val = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > val){
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = val;
        }
    }

    public static void CountingSort(int[] A) {
        int min = A[0], max = A[0];
        for (int i = 1; i < A.length; i++)
        {
            if (A[i]>max) max = A[i];
            else if (A[i]<min) min = A[i];
        }
        int[] freq = new int[max - min + 1];
        for (int value : A) freq[value - min]++;
        int j = 0;
        for (int k = 0; k < freq.length; k++){
            for (int i = 0; i < freq[k]; i++){
                A[j++] = k + min;
            }
        }
    }

    public static int[] MergeTwoAscendingArrays(int[] A, int[] B){
        if (A == null) return B;
        if (B == null) return A;
        int lenA = A.length, lenB = B.length;
        int[] ans = new int[lenA + lenB];
        int i = 0, j = 0, k = 0;
        while (i < lenA && j < lenB){
            if (A[i] <= B[j]) ans[k++] = A[i++];
            else ans[k++] = B[j++];
        }
        while (i < lenA) ans[k++] = A[i++];
        while (j < lenB) ans[k++] = B[j++];
        return ans;
    }

    /**
     * Iterative (loop) implementation of binary search..
     * @param A array to search.
     * @return index of value in array, or -1 if not found.
     */
    public static int BinarySearch(int[] A, int val){
        if (A == null || A.length == 0) return -1;
        int start = 0, end = A.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;  // or, use: start + (end - start) / 2 to prevent integer overflow
            if (A[mid] == val) return mid;
            else if (A[mid] < val) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    /**
     * finds the k-smallest number in the array.
     * @param A array of ints.
     * @param k which "place" number to find.
     * @return the k-smallest number in A.
     */
    public static int findKthSmallest(int[] A, int k){
        if (k <= 0 || k > A.length) {
            throw new IllegalArgumentException("k must be between 1 and array length.");
        }
        for (int i = 0; i < k; i++) {
            int min_idx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min_idx]) {
                    min_idx = j;
                }
            }
            swap(A, i, min_idx);
        }
        return A[k - 1];
    }

    /**
     * Helper function: finds the index of the max element of the array.
     * @param A array of ints.
     * @return index of the max element.
     */
    public static int MaxIndex(int[] A){
        if (A == null || A.length == 0) return -1;
        int maxIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }

    /**
     * Helper function: finds the index of the min element of the array.
     * @param A array of ints.
     * @return index of the min element.
     */
    public static int MinIndex(int[] A){
        if (A == null || A.length == 0) return -1;
        int minIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < A[minIdx]) minIdx = i;
        }
        return minIdx;
    }

    /**
     * Given an array that is sorted in ascending order, but rotated k times to the right, finds k.
     * Uses naive linear approach.
     * @param A circularly sorted integer array.
     * @return number of rotations preformed.
     */
    public static int NumberOfRotationLinear(int[] A){
        if (A == null || A.length <= 1) return 0;
        int i = 0;
        boolean ascending = true;
        while (i < A.length - 1){
            if (A[i] > A[i + 1]) return i + 1;
            i++;
        }
        return A[i] < A[i - 1] ? i : 0;
    }

    /**
     * Given an array that is sorted in ascending order, but rotated k times to the right, finds k.
     * Uses binary-search-like method.
     * @param A circularly sorted integer array.
     * @return number of rotations preformed.
     */
    public static int NumberOfRotationBinarySearch(int[] A){
        if (A == null || A.length == 0) return 0;
        int len = A.length, left = 0, right = len - 1;
        while (left <= right){
            if (A[left] <= A[right]) return left;
            int mid = (left + right) / 2;
            int next = (mid + 1) % len;
            int prev = (mid - 1 + len) % len;
            if (A[mid] < A[prev] && A[mid] < A[next]) return mid;
            else if (A[mid] < A[right]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static int[] FirstLast(int[] A, int val){
        int idx = BinarySearch(A, val);
        if (idx != -1){
            int left = idx, right = idx;
            while (left > 0 && A[left] == val) left -= 1;
            while (right < A.length && A[right] == val) right += 1;
            return new int[]{left, right};
        }
        return null;
    }

    public static boolean MoreThanHalf(int[] A){
        if (A == null || A.length == 0) return false;
        int len = A.length, mid = len / 2;
        for (int i = 0; i <= mid; i++) if (A[i] == A[i + mid - (1 - len % 2)]) return true;
        return false;
    }

}
