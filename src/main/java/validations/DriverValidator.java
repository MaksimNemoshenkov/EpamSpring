package validations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class DriverValidator {
    @Autowired
    private Validator validator;

    public void printAllErrorMessages (Driver driver){
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver);
        for (ConstraintViolation<Driver > violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
    public boolean isValid(Driver driver){
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver);
        return violations.isEmpty();
    }
    public void printErrorMessages (DriverService driverService){
        Set<ConstraintViolation<DriverService>> violations = validator.validate(driverService);
        for (ConstraintViolation<DriverService > violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

}
