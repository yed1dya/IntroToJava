package tirgul7;

public class StudentDetails {

    private String name;
    private String id;

    public StudentDetails(String name, String id) {
        if(name == null || id == null) throw new IllegalArgumentException("Invalid details");
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() { return name + "," + id; } // Helper for file writing
}