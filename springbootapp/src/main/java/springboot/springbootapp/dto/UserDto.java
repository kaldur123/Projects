package springboot.springbootapp.dto;

import lombok.Data;
import springboot.springbootapp.Validator.PassConfirm;
import springboot.springbootapp.Validator.UniqueUser;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@UniqueUser(field1 = "email", field2 = "login")
@PassConfirm(field = "pass", fieldMatch = "passConfirm")
public class UserDto {

    @NotEmpty(message = "Field must not be empty")
    @Email(message = "Wrong email format")
    private String email;

    @NotEmpty(message = "Field must not be empty")
    private String login;

    @NotEmpty(message = "Field must not be empty")
    private String firstName;

    @NotEmpty(message = "Field must not be empty")
    private String lastName;

    private int salary;

    @NotEmpty(message = "Field must not be empty")
    private String pass;

    @NotEmpty(message = "Field must not be empty")
    private String passConfirm;
}
