package ca.lambton.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserCache userCache;

    @GetMapping("/mostpaid")
    public Occupation getMostPaidOccupation() {
        Occupation highestPaidOccupation = userCache.getOccupationWithLargestSalary();
        if (highestPaidOccupation == null) {
            return new Occupation("No Occupation", 0);
        }
        return highestPaidOccupation;
    }
}
