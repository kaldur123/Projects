package project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import project.service.WriterService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired private WriterService writerService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (writerService.findByEmail(s.toLowerCase()) == null) {
            return true;
        }
        return false;
    }
}
