package ca.lambton.exam;

public class Occupation {

    private String title;
    private int salary;

    // Constructor with parameters (to be used in the User constructor)
    public Occupation(String title, int salary) {
        this.title = title;
        this.salary = salary;
    }

    // No-argument constructor (if needed for Spring or other purposes)
    public Occupation() {
        // Initialize default values or leave empty
        this.title = "";
        this.salary = 0;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
