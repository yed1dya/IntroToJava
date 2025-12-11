package tirgul7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
    private String courseId;
    private String courseName;
    private int capacity;
    private List<EnrolledStudent> students;

    // Standard Constructor
    public Course(String courseId, String courseName, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    // Exercise 7: Constructor from File
    public Course(String filename) throws IOException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            // Parsing lines manually based on the format in saveInfo
            // Note: This requires strict adherence to the file format
            this.courseId = scanner.nextLine().split(":")[1].trim();
            this.courseName = scanner.nextLine().split(":")[1].trim();
            this.capacity = Integer.parseInt(scanner.nextLine().split(":")[1].trim());

            // Skip "Enrolled", "Average", "Students list" headers
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();

            this.students = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                // parsing format: Name,ID,Grade
                String[] parts = line.split(",");
                StudentDetails details = new StudentDetails(parts[0], parts[1]);
                EnrolledStudent enrolled = new EnrolledStudent(details);
                enrolled.setGrade(Integer.parseInt(parts[2]));
                this.students.add(enrolled);
            }
        } catch (Exception e) {
            throw new IOException("Error parsing course file: " + e.getMessage());
        }
    }

    public void registerStudent(EnrolledStudent s) {
        if (students.size() >= capacity) throw new IllegalStateException("Course full");
        students.add(s);
    }

    public double getAverage() {
        if (students.isEmpty()) return 0;
        return students.stream().mapToInt(EnrolledStudent::getGrade).average().orElse(0);
    }

    // Exercise 6: Save to File
    public void saveInfo(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Course ID: " + courseId);
            writer.println("Course name: " + courseName);
            writer.println("Capacity: " + capacity);
            writer.println("Enrolled: " + students.size());
            writer.println("Average: " + getAverage());
            writer.println("Students list:");
            for (EnrolledStudent s : students) {
                // Using the helper toString format: Name,ID,Grade
                writer.println(s.toString());
            }
        }
    }
}