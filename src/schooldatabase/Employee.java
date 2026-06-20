package schooldatabase;

public class Employee extends Person {

    private String deptName;
    private int employeeNumber;
    private static int employeeCounter = 0;

    public Employee() {
        super();
        this.deptName = "Unknown Department";
        this.employeeNumber = ++employeeCounter;
    }

    public Employee(String deptName) {
        super();
        this.deptName = deptName != null ? deptName : "Unknown Department";
        this.employeeNumber = ++employeeCounter;
    }

    public Employee(String name, int birthYear, String deptName) {
        super(name, birthYear);
        this.deptName = deptName != null ? deptName : "Unknown Department";
        this.employeeNumber = ++employeeCounter;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }
}