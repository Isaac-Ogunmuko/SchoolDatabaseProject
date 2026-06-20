package schooldatabase;

public class Person {

    private String name;
    private int birthYear;

    public Person() {
        this.name = "Name";
        this.birthYear = 0;
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }
}