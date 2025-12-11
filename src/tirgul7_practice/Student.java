package tirgul7_practice;

public class Student {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int ID;

    public Student(int ID, String name){
        this.ID = ID;
        this.name = name;
    }


}
