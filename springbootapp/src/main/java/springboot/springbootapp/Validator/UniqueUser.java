package springboot.springbootapp.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueUserValidator.class)
public @interface UniqueUser {
    String message() default "User already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field1();
    String field2();
}
