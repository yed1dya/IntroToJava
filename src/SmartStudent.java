import java.sql.Time;

public class SmartStudent {

    private String name;
    private int timeAsStudent = 0, ID;
    private double height;
    private int yearJoined;
    private int InfiGrade;

    public SmartStudent(){
        this.name = "a";
        this.ID = 1;
        this.height = 0;
        yearJoined = 1998;
    }

    public SmartStudent(SmartStudent other){
        this(other.name, other.ID, other.height);
    }

    public SmartStudent(String name, int ID, double height){
        this.name = name;
        this.ID = ID;
        this.height = height;
        yearJoined = 1998;
    }

    public SmartStudent(String name, int ID, double height, int grade){
        this.name = name;
        this.ID = ID;
        this.height = height;
        yearJoined = 1998;
        this.InfiGrade = grade;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public boolean setName(String name){
        // check that name is valid
        this.name = name;
        return true;
    }
}
