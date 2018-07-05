package project.dto;

import lombok.Data;
import project.validator.PasswordConfirm;
import project.validator.UniqueEmail;

import javax.validation.constraints.*;

@Data
@PasswordConfirm
public class WriterDtoReg {
    @NotEmpty(message = "Field must not be empty")
    private String fullName;

    @Min(value = 18, message = "Minimal age = 18")
    @Max(value = 80, message = "Maximal AGE = 80")
    private int age;

    @UniqueEmail
    @NotEmpty(message = "Field must not be empty")
    @Email(message = "Wrong email format")
    private String email;

    @Size(min = 5, max= 15)
    @NotEmpty(message = "Field must not be empty")
    private String password;

    @Size(min = 5, max= 15)
    @NotEmpty(message = "Field must not be empty")
    private String passwordConfirm;

    @NotEmpty(message = "Field must not be empty")
    private String country;


    private String imageUrl;
}
