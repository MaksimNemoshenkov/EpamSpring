package validations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("validations");
        DriverValidator driverValidator = context.getBean(DriverValidator.class);
        Driver boy = new Driver("John", 12, true);
        boolean valid = driverValidator.isValid(boy);
        DriverService driverService = new DriverService(boy);
        driverValidator.printErrorMessages(driverService);
    }
}