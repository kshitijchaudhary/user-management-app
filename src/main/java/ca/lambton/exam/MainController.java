package ca.lambton.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


@Controller
public class MainController{

    private final UserCache userCache;

    @Autowired
    public MainController(UserCache userCache) {
        this.userCache = userCache;
    }

    // Mapping for the index page
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Mapping to display all users
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userCache.getAllUsers());
        return "users";
    }

    // Mapping for creating a new user
    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    // Handle the form submission for creating a new user
    @PostMapping("/create")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        userCache.addUser(user);
        return "redirect:/users";
    }

    // Mapping to get the occupation with the highest salary
    @GetMapping("/most-paid")
    public String getMostPaid(Model model) {
        Occupation mostPaidOccupation = userCache.getOccupationWithLargestSalary();
        model.addAttribute("mostPaid", mostPaidOccupation);
        return "mostpaid";
    }

}
