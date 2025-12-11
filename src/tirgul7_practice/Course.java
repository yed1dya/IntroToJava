package tirgul7_practice;

import java.util.ArrayList;

public class Course {
    private int courseID, capacity;
    private String courseName;
    private ArrayList<EnrolledStudent> studentList;

    public Course(int courseID, int capacity, String name) {
        this.courseID = courseID;
        this.courseName = name;
        this.capacity = capacity;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (studentList.size() != capacity) {
            studentList.add(new EnrolledStudent(student));
        }
    }
}
