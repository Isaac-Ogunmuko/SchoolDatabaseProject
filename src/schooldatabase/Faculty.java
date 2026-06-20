package schooldatabase;

public class Faculty extends Employee {

    private Course[] coursesTaught;
    private boolean isTenured;

    public Faculty() {
        super();
        this.coursesTaught = new Course[0];
        this.isTenured = false;
    }

    public Faculty(boolean isTenured) {
        super();
        this.coursesTaught = new Course[0];
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        super(deptName != null ? deptName : "Unknown Department");
        this.isTenured = isTenured;
        this.coursesTaught = new Course[0];
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
        super(name, birthYear,
              deptName != null ? deptName : "Unknown Department");
        this.isTenured = isTenured;
        this.coursesTaught = new Course[0];
    }

    public boolean isTenured() {
        return isTenured;
    }

    public Course[] getCoursesTaught() {
        return coursesTaught;
    }
}