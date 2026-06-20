package schooldatabase;

import java.io.File;


public class Driver_SchoolDB {

    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Faculty> facultyList = new ArrayList<>();
    static ArrayList<GeneralStaff> staffList = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Step 1: Read data from the file and create objects
        readFromFile("SchoolDB_Initial.txt");

        // Step 2: Display the database content in the required format
        displayDatabaseContent();
    }

    public static void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
    // Method to process each line and create the appropriate object
    public static void processLine(String line) {

        if (line.startsWith("Course:")) {

            String[] parts = line.split(", ");

            if (parts.length == 4) {
                boolean isGraduate = Boolean.parseBoolean(parts[0].split(": ")[1]);
                int courseNum = Integer.parseInt(parts[1]);
                String courseDept = parts[2];
                int numCredits = Integer.parseInt(parts[3]);

                Course course = new Course(isGraduate, courseNum, courseDept, numCredits);
                courses.add(course);
            }
            else {
                System.out.println("Invalid course line: " + line);
            }
        } else if (line.startsWith("Faculty:")) {
            processFacultyLine(line);
        } else if (line.startsWith("Student:")) {
            processStudentLine(line);
        } else if (line.startsWith("GeneralStaff:")) {
            processGeneralStaffLine(line);
        } else {
            System.out.println("Invalid line format: " + line);
        }
    }

    public static void processFacultyLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 1) {
            Faculty faculty = new Faculty();  // default Faculty object
            facultyList.add(faculty);
        } else if (parts.length == 2) {
            boolean isTenured = Boolean.parseBoolean(parts[1]);
            Faculty faculty = new Faculty(isTenured);
            facultyList.add(faculty);
        } else if (parts.length == 3) {
            String deptName = parts[1];
            boolean isTenured = Boolean.parseBoolean(parts[2]);
            Faculty faculty = new Faculty(deptName, isTenured);
            facultyList.add(faculty);
        } else if (parts.length == 4) {
            String name = parts[0];
            int birthYear = Integer.parseInt(parts[1]); // Ensure this is the birth year
            String deptName = parts[2]; // Department name (like PHY)
            boolean isTenured = Boolean.parseBoolean(parts[3]);

            Faculty faculty = new Faculty(name, birthYear, deptName, isTenured);
            facultyList.add(faculty);
        } else {
            System.out.println("Invalid faculty line: " + line);
        }
    }

    public static void processStudentLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 1) {
            Student student = new Student(); //default Student object
            students.add(student);
        } else if (parts.length == 2) {
            boolean isGraduate = Boolean.parseBoolean(parts[1]);
            Student student = new Student(isGraduate);
            students.add(student);
        } else if (parts.length == 3) {
            String major = parts[1];
            boolean isGraduate = Boolean.parseBoolean(parts[2]);
            Student student = new Student(major, isGraduate);
            students.add(student);
        } else if (parts.length == 4) {
            String name = parts[0];  // Student name
            int birthYear = Integer.parseInt(parts[1]);  //Birth year should be an integer
            String major = parts[2]; //Major, such as "JST"
            boolean isGraduate = Boolean.parseBoolean(parts[3]);  // Boolean for graduate status

            Student student = new Student(name, birthYear, major, isGraduate);
            students.add(student);
        } else {
            System.out.println("Invalid student line: " + line);
        }
    }

    public static void processGeneralStaffLine(String line) {

        String[] parts = line.split(", ");
        if (parts.length == 1) {
            GeneralStaff staff = new GeneralStaff(); //default GeneralStaff object
            staffList.add(staff);
        } else if (parts.length == 2) {
            String duty = parts[1]; //Duty (e.g., "advise students")
            GeneralStaff staff = new GeneralStaff(duty);
            staffList.add(staff);
        } else if (parts.length == 3) {
            String deptName = parts[1]; // Department name (e.g. "Sanitation")
            String duty = parts[2];  // Duty (e.g., "clean") 
            GeneralStaff staff = new GeneralStaff(deptName, duty);
            staffList.add(staff);
        } else if (parts.length == 4) {
            String name = parts[0];       // General Staff name
            int birthYear = Integer.parseInt(parts[1]);  // Birth year should be an integer
            String deptName = parts[2];         // Department name (e.g., "Security")
            String duty = parts[3];             // Duty (e.g., "safety")

            GeneralStaff staff = new GeneralStaff(name, birthYear, deptName, duty);
            staffList.add(staff);
        } else {
            System.out.println("Invalid general staff line: " + line);
        }
    }

    public static void displayDatabaseContent() {

        System.out.println("****************************************");
        System.out.println( "SCHOOL DATABASE INFO:");
        System.out.println("****************************************");

        // Display Courses
        System.out.println("COURSES:");
        for (Course course : courses) {
            System.out.printf( "Course: %-8s | Number of Credits: %02d | %-12s%n",
                    course.getCourseDept() + "-" + course.getCourseNum(),
                    course.getNumCredits(),
                    course.isGraduateCourse() ? "Graduate" : "Undergraduate");
        }

        System.out.println("****************************************");
        System.out.println("PERSONS:");
        System.out.println("****************************************");

        // Display Employees (General Staff and Faculty)
        System.out.println("EMPLOYEES:");
        System.out.println("****************************************");

        // Display General Staff
        System.out.println("GENERAL STAFF:");
        for (GeneralStaff staff : staffList) {
            System.out.printf( "GeneralStaff: %-15s | Birth Year: %4d | Employee Number: %2d | Department: %-10s | Duty: %-20s%n",
                    staff.getName(), staff.getBirthYear(), staff.getEmployeeNumber(), staff.getDeptName(), staff.getDuty());
        }
        System.out.println( "****************************************");

        // Displaying Faculty
        System.out.println("FACULTY:");
        for (Faculty faculty : facultyList) {
            System.out.printf("Faculty: %-15s | Birth Year: %4d | Employee Number: %2d | Department: %-10s | Faculty: %-12s | Number of Courses Taught: %02d%n",
                    faculty.getName(), faculty.getBirthYear(), faculty.getEmployeeNumber(), faculty.getDeptName(), 
                    faculty.isTenured() ? "Tenured" : "Not Tenured", faculty.getCoursesTaught().length);
        }

        System.out.println("****************************************");
        
        // Displaying Students
        System.out.println("STUDENTS:");

        for (Student student : students) {
            System.out.printf( "Student: ID: %04d | Major: %-10s | %-15s | Number of Courses Taken: %02d%n",
                student.getStudentID(), student.getMajor(), student.isGraduate() ? "Graduate" : "Undergraduate", 0);
        }
        System.out.println( "****************************************");
    }
}