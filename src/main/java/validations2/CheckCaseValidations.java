package validations2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidations implements ConstraintValidator<CheckCase, String > {
    private CaseType caseType;
    @Override
    public void initialize(CheckCase checkCase) {
        caseType = checkCase.value();
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (caseType == caseType.UPPER_CASE) {
            return s.equals(s.toUpperCase());
        } else {
            return s.equals(s.toLowerCase());
        }
    }
}