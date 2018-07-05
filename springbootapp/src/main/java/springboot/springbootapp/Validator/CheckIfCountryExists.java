package springboot.springbootapp.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, ElementType.METHOD})
@Constraint(validatedBy = CheckIfCountryExistsValidator.class)
public @interface CheckIfCountryExists {

    String message() default "Country already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
