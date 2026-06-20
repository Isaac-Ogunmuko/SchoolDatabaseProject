package schooldatabase;

public class Student extends Person {

    private static int studentCounter = 0;
    private int studentID;
    private String major;
    private boolean isGraduate;

    public Student() {
        super();
        this.studentID = ++studentCounter;
        this.major = "undeclared";
        this.isGraduate = false;
    }

    public Student(boolean isGraduate) {
        super();
        this.studentID = ++studentCounter;
        this.major = "undeclared"; // Default major
        this.isGraduate = isGraduate;
    }

    public Student(String major, boolean isGraduate) {
        super();
        this.studentID = ++studentCounter;
        this.major = major;
        this.isGraduate = isGraduate;
    }

    public Student(String name, int birthYear, String major, boolean isGraduate) {
        super(name, birthYear);
        this.studentID = ++studentCounter;
        this.major = major;
        this.isGraduate = isGraduate;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public boolean isGraduate() {
        return isGraduate;
    }
}