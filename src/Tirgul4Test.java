import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class Tirgul4Test {
    // question 1
    @Test
    public void testSumToN(){
        assertEquals(10, Tirgul4.sumToN(4));
        assertEquals(0, Tirgul4.sumToN(0));
        for (int i = -11; i < 0; i+=2) {
            assertEquals(-1, Tirgul4.sumToN(i));
        }
    }

    // question 2
    @Test
    public void testIsPalindrome(){
        assertTrue(Tirgul4.isPalindrome(""));
        assertTrue(Tirgul4.isPalindrome(" "));
        assertTrue(Tirgul4.isPalindrome(" ! "));
        assertFalse(Tirgul4.isPalindrome(" !  "));
        assertFalse(Tirgul4.isPalindrome("abA"));
        assertFalse(Tirgul4.isPalindrome("abcdeabcde"));
        assertTrue(Tirgul4.isPalindrome("racecar"));
        assertTrue(Tirgul4.isPalindrome("raceecar"));
    }

    // question 3
    @Test
    public void testIsLetterOrDigit(){
        assertTrue(Tirgul4.isLetterOrDigit('a'));
        assertTrue(Tirgul4.isLetterOrDigit('0'));
        assertFalse(Tirgul4.isLetterOrDigit('@'));
        assertFalse(Tirgul4.isLetterOrDigit(' '));
    }

    @Test
    public void testIsPalindromeIgnoreSpecial(){
        assertTrue(Tirgul4.isPalindromeIgnoreSpecial("A man, a plan, a canal: Panama!"));
        assertTrue(Tirgul4.isPalindromeIgnoreSpecial("Race car"));
        assertTrue(Tirgul4.isPalindromeIgnoreSpecial(" ! @# ^."));
        assertTrue(Tirgul4.isPalindromeIgnoreSpecial("!@#Level!@#"));
        assertTrue(Tirgul4.isPalindromeIgnoreSpecial(" ! @#b ^.b"));
        assertFalse(Tirgul4.isPalindromeIgnoreSpecial(" ! @#b ^.a"));
    }

    // question 4
    @Test
    public void testReverse(){
        assertEquals("asdf", Tirgul4.reverse("fdsa"));
        assertNotEquals(" a  ", Tirgul4.reverse(" a "));
    }

    // question 5
    @Test
    public void testAverage(){
        int[] testArr1 = {10, 20, 30, 40};
        assertEquals(25.0, Tirgul4.average(testArr1), 0.0001);
        int[] testArr2 = {};
        assertEquals(0, Tirgul4.average(testArr2));
        assertEquals(0, Tirgul4.average(null));
        int[] testArr3 = {-5, 5, 10};
        assertEquals(3.333333333333333, Tirgul4.average(testArr3), 0.0001);
    }

    // question 6
    @Test
    public void testTranspose(){
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{11, 12, 13, 14, 15, 16}, {21, 22, 23, 24, 25, 26}, {31, 32, 33, 34, 35, 36}, {41, 42, 43, 44, 45, 46}};
        int[][] matrix3 = {{11, 12}, {21, 22}, {31, 32}, {41, 42}};
        int[][] exp1 = {{1, 4}, {2, 5}, {3, 6}};
        int[][] exp2 = {{11, 21, 31, 41}, {12, 22, 32, 42}, {13, 23, 33, 43}, {14, 24, 34, 44}, {15, 25, 35, 45}, {16, 26, 36, 46}};
        int[][] exp3 = {{11, 21, 31, 41}, {12, 22, 32, 42}};
        assertTrue(Arrays.deepEquals(exp1, Tirgul4.transpose(matrix1)));
        assertTrue(Arrays.deepEquals(exp2, Tirgul4.transpose(matrix2)));
        assertTrue(Arrays.deepEquals(exp3, Tirgul4.transpose(matrix3)));
    }

    @Test
    public void testTranspose2x3(){
        int[][] original = {{1, 2, 3}, {4, 5, 6}}; // 2x3 matrix
        int[][] expected = {{1, 4}, {2, 5}, {3, 6}}; // 3x2 matrix
        int[][] actual = Tirgul4.transpose(original);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranspose3x3() {
        int[][] original = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 3x3 matrix
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}; // 3x3 matrix
        int[][] actual = Tirgul4.transpose(original);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    void testOneRowMatrix() {
        int[][] original = {{10, 20, 30, 40}}; // 1x4 matrix
        int[][] expected = {{10}, {20}, {30}, {40}}; // 4x1 matrix
        int[][] actual = Tirgul4.transpose(original);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    void testOneColumnMatrix() {
        int[][] original = {{5}, {6}, {7}}; // 3x1 matrix
        int[][] expected = {{5, 6, 7}}; // 1x3 matrix
        int[][] actual = Tirgul4.transpose(original);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    void testNegativeAndZeroValues() {
        int[][] original = {{-1, 0}, {5, -10}}; // 2x2 matrix
        int[][] expected = {{-1, 5}, {0, -10}}; // 2x2 matrix
        int[][] actual = Tirgul4.transpose(original);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    void testEmptyMatrix() {
        int[][] original = {};
        int[][] expected = {};
        int[][] actual = Tirgul4.transpose(original);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    void testNullMatrix() {
        // The implementation specifies returning an empty array for null/empty input
        int[][] expected = new int[0][];
        int[][] actual = Tirgul4.transpose(null);
        // Note: assertNotNull is used here to ensure the method handles null gracefully
        assertNotNull(actual);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    // question 7
    public final int[][][] TEST_CUBE = {
            // Depth 0: Sum = 1+2+3 + 4+5+6 = 21
            {{1, 2, 3}, {4, 5, 6}},
            // Depth 1: Sum = 10+20+30 + 40+50+60 = 210
            {{10, 20, 30}, {40, 50, 60}}
    };

    @Test
    void testFirstSliceSum() {
        assertEquals(21, Tirgul4.sumSlice(TEST_CUBE, 0),
                "Should correctly sum the slice at depth 0.");
    }

    @Test
    void testSecondSliceSum() {
        assertEquals(210, Tirgul4.sumSlice(TEST_CUBE, 1),
                "Should correctly sum the slice at depth 1.");
    }

    @Test
    void testIndexOutOfBounds() {
        assertEquals(0, Tirgul4.sumSlice(TEST_CUBE, 2),
                "Should return 0 for an out-of-bounds depth index.");
        assertEquals(0, Tirgul4.sumSlice(TEST_CUBE, -1),
                "Should return 0 for a negative depth index.");
    }

    @Test
    void testNullOrEmptyArray() {
        assertEquals(0, Tirgul4.sumSlice(null, 0),
                "Should return 0 for a null array.");
        assertEquals(0, Tirgul4.sumSlice(new int[0][][], 0),
                "Should return 0 for an empty 3D array.");
    }


    // question 8
    public final int[][][] MAX_TEST_CUBE = {
            // Depth 0
            {{-1, 10, -5}, {15, -99, 0}}, // Max 15
            // Depth 1
            {{200, 50, 2}, {1, 3, 400}}    // Max 400
    };

    @Test
    void testMaxInCube() {
        assertEquals(400, Tirgul4.findMax(MAX_TEST_CUBE),
                "Should find the overall maximum element (400).");
    }

    @Test
    void testMaximumIsNegative() {
        int[][][] negativeCube = {{{-10, -5}, {-1}}, {{-20, -2}}};
        assertEquals(-1, Tirgul4.findMax(negativeCube),
                "Should find the maximum even if it is negative (-1).");
    }

    @Test
    void testEmptyArray() {
        assertEquals(Integer.MIN_VALUE, Tirgul4.findMax(new int[0][][]),
                "Should return Integer.MIN_VALUE for an empty array.");
    }

    @Test
    void testNullArray() {
        assertEquals(Integer.MIN_VALUE, Tirgul4.findMax(null),
                "Should return Integer.MIN_VALUE for a null array.");
    }

    // question 9
    private final int[][][][] INVENTORY_DATA = {
            // store 0
            { // aisle 0
                {
                    {10, 20, 30}, // shelf 0
                        {20, 15, 5}, // shelf 1
                        {30, 25, 10}}, // shelf 2
                    // aisle 1
                    {{5, 10}, {15, 20}, {10, 95}, {30, 20}}},
            // store 1
            {{{90}, {40}, {60}, {70}}, {{30}, {80}, {45}}, {{35}, {25}, {5}}}
    };

    @Test
    void testFindMaxLocationStandard() {
        int[] expected = {0, 1, 2, 1}; // Store 0, Aisle 1, Shelf 2, Item ID 1 (Quantity 95)
        int[] actual = Tirgul4.findMaxQuantityLocation(INVENTORY_DATA);
        assertArrayEquals(expected, actual, "Should find the location [0, 1, 2, 1] of the max quantity 95.");
    }

    @Test
    void testFindMaxLocationZero() {
        // If max is at index 0,0,0,0
        int[][][][] inventory = {{{{100, 0}, {0, 0}}}};
        int[] expected = {0, 0, 0, 0};
        int[] actual = Tirgul4.findMaxQuantityLocation(inventory);
        assertArrayEquals(expected, actual, "Should find the max location at the start [0, 0, 0, 0].");
    }

    @Test
    void testFindMaxLocationNegative() {
        // Test array with negative values where -1 is the max
        int[][][][] inventory = {{{{-5, -1}, {-10, -2}}}};
        int[] expected = {0, 0, 0, 1}; // Max -1 is at [0, 0, 0, 1]
        int[] actual = Tirgul4.findMaxQuantityLocation(inventory);
        assertArrayEquals(expected, actual, "Should correctly find the location of the largest negative number.");
    }

    @Test
    void testEmptyArrayFMQL() {
        int[][][][] empty = new int[0][][][];
        int[] expected = new int[0];
        int[] actual = Tirgul4.findMaxQuantityLocation(empty);
        assertArrayEquals(expected, actual, "Should return an empty array for an empty 4D array.");
    }

    @Test
    void testNullArrayFMQL() {
        int[] expected = new int[0];
        int[] actual = Tirgul4.findMaxQuantityLocation(null);
        assertArrayEquals(expected, actual, "Should return an empty array for a null 4D array.");
    }

}
