package tirgul7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCalculator {

    public static double computeFile(String filename, String operation) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        double result = 0;
        int count = 0;

        // Initialize based on operation (multiplication needs 1)
        if (operation.equals("prod")) result = 1;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    double num = scanner.nextDouble();
                    count++;

                    switch (operation) {
                        case "sum":
                        case "avg":
                            result += num;
                            break;
                        case "prod":
                            result *= num;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operation: " + operation);
                    }
                } else {
                    scanner.next(); // Skip non-number tokens
                }
            }
        }

        if (count == 0 && operation.equals("avg")) {
            throw new ArithmeticException("Cannot calculate average of empty file");
        }

        if (operation.equals("avg")) {
            return result / count;
        }

        return result;
    }
}
