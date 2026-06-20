package schooldatabase; 

public class Course implements Comparable<Course> {

    private boolean isGraduateCourse;
    private int courseNum;
    private String courseDept;
    private int numCredits;

    public Course(boolean isGraduateCourse, int courseNum,String courseDept, int numCredits) {
        this.isGraduateCourse = isGraduateCourse;
        this.courseNum = courseNum;
        this.courseDept = courseDept;
        this.numCredits = numCredits;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public boolean isGraduateCourse() {
        return isGraduateCourse;
    }

    @Override
    public int compareTo(Course other) {
        return this.courseNum - other.courseNum;
    }

    @Override
    public String toString() {
        return String.format(
            "Course: %s-%d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits,
            isGraduateCourse ? "Graduate" : "Undergraduate");
    }
}
