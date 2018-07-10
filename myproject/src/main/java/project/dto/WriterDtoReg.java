package project.dto;

import lombok.Data;
import project.validator.PasswordConfirm;
import project.validator.UniqueEmail;

import javax.validation.constraints.*;

@Data
@PasswordConfirm
public class WriterDtoReg {
    @NotEmpty(message = "Field Full Name is empty")
    private String fullName;

    @Min(value = 18, message = "Minimal age = 18")
    @Max(value = 80, message = "Maximal AGE = 80")
    private int age;

    @UniqueEmail
    @NotEmpty(message = "Field Email is empty")
    @Email(message = "Wrong email format")
    private String email;

    @Size(min = 5, max= 15, message = "Password Length must be from 5 to 15 symbols")
    @NotEmpty(message = "Field Password is empty")
    private String password;

    @Size(min = 5, max= 15, message = "Password Confirm Length must be from 5 to 15 symbols")
    @NotEmpty(message = "Field Password Confirm is empty")
    private String passwordConfirm;

    @NotEmpty(message = "Field Country is empty")
    private String country;


    private String imageUrl;
}
