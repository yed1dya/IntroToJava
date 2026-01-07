package practice_exams;

public class Exam2023AA {

    public static void main(String[] args) {

    }

    // question 1
    public static void shuffle(double[] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            int otherIndex = index + (int) (Math.random() * (n - index));
            double temp = arr[index];
            arr[index] = arr[otherIndex];
            arr[otherIndex] = temp;
        }
    }

}
