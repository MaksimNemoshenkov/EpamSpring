package validations2;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = CheckCaseValidations.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {
    CaseType value();
    String message();
     Class<?>[] groups() default {};
    Class<? extends Payload>[] payLoad() default {};
}