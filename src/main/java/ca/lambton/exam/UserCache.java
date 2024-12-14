package ca.lambton.exam;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserCache {

    private final List<User> users = new ArrayList<>();

    // Add a user to the list
    public void addUser(User user) {
        users.add(user);
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Fetch a user by name
    public Optional<User> getUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Fetch users with a minimum salary and under a certain age
    public List<User> getUsersBySalaryAndAge(int minSalary, int maxAge) {
        return users.stream()
                .filter(user -> user.getOccupation().getSalary() >= minSalary && user.getAge() < maxAge)
                .collect(Collectors.toList());
    }

    // Fetch the Occupation with the highest salary
    public Occupation getOccupationWithLargestSalary() {
        return users.stream()
                .map(User::getOccupation)
                .max((o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary()))
                .orElse(null);
    }

    // Fetch a user by ID
    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
