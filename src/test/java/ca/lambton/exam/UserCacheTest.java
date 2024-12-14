package ca.lambton.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserCacheTest {

    private UserCache userCache;

    @BeforeEach
    void setUp() {
        userCache = new UserCache();
    }

    @Test
    void testAddUser() {
        User user = new User("Alice", 25, new Occupation("Developer", 50000));
        userCache.addUser(user);

        // Check if user is added
        assertTrue(userCache.getAllUsers().contains(user));
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("Alice", 25, new Occupation("Developer", 50000));
        User user2 = new User("Bob", 30, new Occupation("Manager", 60000));

        userCache.addUser(user1);
        userCache.addUser(user2);

        // Fetch all users
        List<User> users = userCache.getAllUsers();

        // Assertions
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    void testGetUserByName() {
        User user = new User("Alice", 25, new Occupation("Developer", 50000));
        userCache.addUser(user);

        // Fetch user by name (Optional handling)
        User fetchedUser = userCache.getUserByName("Alice").orElse(null);

        // Assertions
        assertNotNull(fetchedUser);
        assertEquals("Alice", fetchedUser.getName());
    }

    @Test
    void testGetUsersWithSalaryAndAge() {
        User user1 = new User("Alice", 25, new Occupation("Developer", 50000));
        User user2 = new User("Bob", 30, new Occupation("Manager", 60000));
        userCache.addUser(user1);
        userCache.addUser(user2);

        // Fetch users with salary >= 50000 and age < 30
        List<User> users = userCache.getUsersBySalaryAndAge(50000, 30);

        // Assertions: Expecting only Alice to be returned
        assertEquals(1, users.size());
        assertTrue(users.contains(user1));
        assertFalse(users.contains(user2));
    }


    @Test
    void testGetOccupationWithLargestSalary() {
        User user1 = new User("Alice", 25, new Occupation("Developer", 50000));
        User user2 = new User("Bob", 30, new Occupation("Manager", 60000));
        userCache.addUser(user1);
        userCache.addUser(user2);

        // Fetch occupation with the largest salary
        Occupation highestPaidOccupation = userCache.getOccupationWithLargestSalary();

        // Assertions
        assertEquals("Manager", highestPaidOccupation.getTitle());
        assertEquals(60000, highestPaidOccupation.getSalary());
    }
}
