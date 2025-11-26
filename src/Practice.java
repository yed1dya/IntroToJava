import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

    }

    public static int checkRotate(int[] A){
        if (A == null) return 0;
        int i = 0;
        while (i < A.length - 1 && A[i + 1] > A[i]){
            i += 1;
        }
        if (i == A.length - 1) return 0;
        return i + 1;
    }

    public static int rotateLog(int[] A, int left, int right){
        if (A == null) return -1;
        int m = (left + right) / 2;
        int next = m + 1;
        if (m == A.length - 1){
            next = 0;
        }
        int prev = m - 1;
        if (m == 0){
            prev = A.length - 1;
        }
        if (A[m] < A[prev] && A[m] < A[next]){
            return m;
        }
        if (A[m] < A[right]) return rotateLog(A, left, m - 1);
        return rotateLog(A, m + 1, right);
    }

}
