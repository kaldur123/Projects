package project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.service.DinoService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueDinoNameValidator implements ConstraintValidator<UniqueDinoName, String> {

    @Autowired private DinoService dinoService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (dinoService.findDinoByName(s.toLowerCase()) == null) {
            return true;
        }
        return false;
    }
}
