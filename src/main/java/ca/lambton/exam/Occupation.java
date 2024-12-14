package ca.lambton.exam;

public class Occupation {

    private String title;
    private int salary;

    // Constructor with parameters
    public Occupation(String title, int salary) {
        this.title = title;
        this.salary = salary;
    }

    // No-argument constructor
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
