package practice_exams.exam_example_2023;

import java.util.ArrayList;

public class Exam {

    // question 1a
    int[] d_range(int n) {
        if (isPrime(n)) return new int[0];
        int a = prevPrime(n), b = nextPrime(n);
        if (a == -1) return null;
        int len = b - a - 1;
        int[] ans = new int[len];
        a++;
        for (int i = 0; i < len; i++){
            ans[i] = a++;
        }
        return ans;
    }

    int prevPrime(int n) {
        if (n < 2) return -1;
        if (isPrime(n)) return n;
        while (!isPrime(n)) {
            n--;
        }
        return n;
    }

    int nextPrime(int n) {
        if (isPrime(n)) return n;
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        if (n <= 3) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // question 2a
    boolean isPer(ArrayList<String> words, String line) {
        if (line == null || words == null) return false;
        return isPerHelper(new ArrayList<>(words), line);
    }

    boolean isPerHelper(ArrayList<String> words, String line) {
        if (line.isEmpty() && words.isEmpty()) return true;
        if (words.isEmpty() || line.isEmpty()) return false;
        for (String word : words) {
            if (line.startsWith(word)) {
                words.remove(word);
                if (isPerHelper(words, line)) return true;
                words.add(word);
            }
        }
        return false;
    }
}


