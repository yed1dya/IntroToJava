package tirgul7_practice;

public class EnrolledStudent {

    private Student studentInfo;
    private int grade;

    public EnrolledStudent(Student student){
        this.studentInfo = student;
        this.grade = 0;
    }

    public Student getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(Student studentInfo) {
        this.studentInfo = studentInfo;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
