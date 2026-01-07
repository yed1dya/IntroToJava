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
    /*
    NOTE: this is not what we did in class.
    the version we did had an error:
    in the case of: {"a", "ab"}, "aba",
    we have: "ab" + "a" == "aba", so we should return true.
    but we would first check if "a" is in the words list, and remove it.
    so the line would be "ba", and the words list {"ab"}.
    and then we would return false.

    the correct solution is to use recursion (sorry).
     */
    boolean isPer(ArrayList<String> words, String line) {
        if (line == null || words == null) return false;
        return isPerHelper(new ArrayList<>(words), line);
    }

    boolean isPerHelper(ArrayList<String> words, String line) {
        // base case 1 - success (line and words list are both empty):
        if (line.isEmpty() && words.isEmpty()) return true;

        // base case 2 - failure (only one is empty):
        if (words.isEmpty() || line.isEmpty()) return false;

        // check all options of words:
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            // if the line starts with the current word:
            if (startsWith(line, word)) {  // can also use built-in "line.startsWith(word)"

                // check if the rest of the line can be constructed from the remaining words:
                words.remove(word);
                if (isPerHelper(words, lineWithoutStart(line, word.length()))) return true;  // can also use built-in "line.substring(word.length())"

                /*
                if the recursion failed,
                it only means that we failed in the case that
                we used this specific word at the beginning.
                we want to check what happens if we use a different word at the beginning.
                so we add the word back to the words list (in the same place),
                and continue with the loop.
                 */
                words.add(i, word);
            }
        }
        return false;
    }

    boolean startsWith(String line, String sub) {
        if (line == null || sub == null || sub.length() > line.length()) return false;
        for (int i = 0; i < sub.length(); i++) {
            if (line.charAt(i) != sub.charAt(i)) return false;
        }
        return true;
    }

    String lineWithoutStart(String line, int startLength) {
        if (line == null) return null;
        int i = startLength;
        String ans = "";
        while (i < line.length()) {
            ans += line.charAt(i);
            i++;
        }
        return ans;
    }
}


