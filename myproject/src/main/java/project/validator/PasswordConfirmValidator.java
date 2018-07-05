package project.validator;

import org.springframework.stereotype.Component;
import project.dto.WriterDto;
import project.dto.WriterDtoReg;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, WriterDtoReg> {

    @Override
    public boolean isValid(WriterDtoReg writerDtoReg, ConstraintValidatorContext constraintValidatorContext) {
        if (writerDtoReg.getPassword() == null || writerDtoReg.getPasswordConfirm() == null) {
            return false;
        }

        if (writerDtoReg.getPassword().equals(writerDtoReg.getPasswordConfirm())) {
            return true;
        }
        return false;
    }
}
