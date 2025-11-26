import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[][] arrs = {new int[]{5, 7, 8, 10, 11, 12, 13, 2, 4}, new int[]{0},
//        new int[]{6, 2}, new int[]{5, 6, 7, 8, 4}, new int[]{5, 6, 7, 8}};
//        for (int[] A : arrs){
//            System.out.println(Tirgul5.NumberOfRotationBinarySearch(A) - Tirgul5.NumberOfRotationLinear(A));
//        }
        int[][] arrs2 = {{0,1,1,2}, {0,1,2,2}, {0,1,2,3}, {0,0,1,2}, {1,1}, {0,1},
                {0,1,1}, {0,0,1}, {1,2,3,3,3,4,}, {1,2,3,3,3,4,5}};
        for (int[] b : arrs2) System.out.println(Arrays.toString(b) + "  " + Tirgul5.MoreThanHalf(b));
    }
}
