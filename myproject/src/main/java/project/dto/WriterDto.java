package project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class WriterDto {

//    @NotEmpty(message = "Field must not be empty")
    //@Size(min=1, message = "Field must not be empty")
    private String fullName;

    @Min(value = 18, message = "Minimal age = 18")
    @Max(value = 80, message = "Maximal AGE = 80")
    private int age;

    @NotEmpty(message = "Field Country is empty")
    private String country;


    private String imageUrl;
}
