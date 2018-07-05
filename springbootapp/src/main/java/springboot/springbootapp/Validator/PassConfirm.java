package springboot.springbootapp.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PassConfirmValidator.class)
public @interface PassConfirm {

    String message() default "Confirm field doesn't match to your password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();
    String fieldMatch();
}
