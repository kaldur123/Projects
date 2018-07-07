package project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNotEmptyValidator implements ConstraintValidator<IsNotEmpty, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.toLowerCase().equals("")) {
            return true;
        }
        return false;
    }
}
