package project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import project.validator.UniqueEmail;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class WriterDto {

    @NotEmpty(message = "Field must not be empty")
    //@Size(min=1, message = "Field must not be empty")
    private String fullName;

    @Min(value = 18, message = "Minimal age = 18")
    @Max(value = 80, message = "Maximal AGE = 80")
    private int age;


//    private String email;
//
//
//    private String password;
//
//
//    private String passwordConfirm;

    @NotEmpty(message = "Field must not be empty")
    private String country;


    private String imageUrl;
}
