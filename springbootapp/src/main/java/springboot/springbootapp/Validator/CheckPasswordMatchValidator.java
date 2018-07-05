package springboot.springbootapp.Validator;

import springboot.springbootapp.dto.StudentDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPasswordMatchValidator implements ConstraintValidator<CheckPasswordMatch, StudentDto> {

    @Override
    public boolean isValid(StudentDto studentDto, ConstraintValidatorContext constraintValidatorContext) {
        if (studentDto.getPassword() == null || studentDto.getPasswordConfirm() == null) {
            return false;
        }

        if (studentDto.getPassword().equals(studentDto.getPasswordConfirm())) {
            return true;
        }
        return false;
    }
}
