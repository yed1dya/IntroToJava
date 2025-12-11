package tirgul7;


public class EnrolledStudent {
    private StudentDetails details;
    private int grade;

    public EnrolledStudent(StudentDetails details) {
        this.details = details;
        this.grade = -1; // Default "no grade"
    }

    public void setGrade(int grade) {
        if(grade < 0 || grade > 100) throw new IllegalArgumentException("Invalid grade");
        this.grade = grade;
    }

    public int getGrade() { return grade; }

    public StudentDetails getDetails() { return details; }

    @Override
    public String toString() {
        return details.toString() + "," + grade;
    }
}