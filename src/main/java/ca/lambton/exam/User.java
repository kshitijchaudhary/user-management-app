package ca.lambton.exam;

public class User {

    private Long id;
    private String name;
    private int age;
    private Occupation occupation;

    // Constructor with parameters
    public User(String name, int age, Occupation occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // No-argument constructor
    public User() {
        // Initialize default values or leave empty
        this.name = "";
        this.age = 0;
        this.occupation = new Occupation();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
