package validations2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("validations2");
        Validator validator = context.getBean(Validator.class);
       Set<ConstraintViolation<Person>> violations = validator.validate(new Person("vasya" ));

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
