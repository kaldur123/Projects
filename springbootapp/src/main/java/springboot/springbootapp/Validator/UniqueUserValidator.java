package springboot.springbootapp.Validator;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.springbootapp.repository.UserRepository;
import springboot.springbootapp.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUser, Object> {

    @Autowired
    UserService userService;

    String field1;

    String field2;

    @Override
    public void initialize(UniqueUser constraintAnnotation) {
        this.field1 = constraintAnnotation.field1();
        this.field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object field1Value = new BeanWrapperImpl(o).getPropertyValue(field1);
        Object field2Value = new BeanWrapperImpl(o).getPropertyValue(field2);

        if (field1Value != null && field2Value != null) {
            return userService.isPresent(field1, field2);
        }
        return true;
    }
}
