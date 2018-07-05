package springboot.springbootapp.dto;

import lombok.Data;
import springboot.springbootapp.Validator.CheckPasswordMatch;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@CheckPasswordMatch
public class StudentDto {

    @Size(min = 3, max= 15)
    @NotEmpty(message = "First Name can't be empty")
    private String firstName;

    @NotEmpty(message = "Last Name can't be empty")
    private String lastName;

    @Min(value = 10, message = "Min AGE = 10")
    @Max(value = 95, message = "Max AGE = 95")
    private int age;


    private String password;

    private String passwordConfirm;
}
