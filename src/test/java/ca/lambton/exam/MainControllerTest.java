package ca.lambton.exam;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.mockito.*;

import java.util.List;

class MainControllerTest {

    @Mock
    private UserCache userCache;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    private MainController mainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mainController = new MainController(userCache);
    }

    @Test
    void testGetUsers() {
        User testUser = new User("Alice", 25, new Occupation("Developer", 50000));
        when(userCache.getAllUsers()).thenReturn(List.of(testUser));

        String viewName = mainController.getUsers(model);
        assertEquals("users", viewName);
        verify(model).addAttribute(eq("users"), argThat(users ->
                users != null && ((List<User>) users).contains(testUser)
        ));
    }

    @Test
    void testCreateUserForm() {
        // Verify that the GET /create mapping renders the correct view
        String viewName = mainController.createUserForm(model);
        assertEquals("create", viewName);
    }

    @Test
    void testCreateUserPostValid() {
        // Simulate a valid user submission
        User validUser = new User("John", 30, new Occupation("Engineer", 60000));

        // Mock the user addition (do nothing for void method)
        doNothing().when(userCache).addUser(validUser);

        // Mocking BindingResult to return false for hasErrors
        when(bindingResult.hasErrors()).thenReturn(false);

        // Call POST /create
        String viewName = mainController.createUser(validUser, bindingResult);

        // Assertions
        assertEquals("redirect:/users", viewName);
        verify(userCache).addUser(validUser);
    }

    @Test
    void testCreateUserPostInvalid() {
        // Simulate an invalid user submission
        User invalidUser = new User("A", 15, new Occupation("Intern", 1000));  // Invalid data

        // Mocking BindingResult to return true for hasErrors
        when(bindingResult.hasErrors()).thenReturn(true);

        // Call POST /create with invalid data
        String viewName = mainController.createUser(invalidUser, bindingResult);

        // Assertions
        assertEquals("create", viewName);
    }
}
