package project.dto;

import lombok.Data;
import project.validator.UniqueDinoName;

import javax.validation.constraints.NotEmpty;

@Data
public class DinoDto {

    @UniqueDinoName
    @NotEmpty(message = "Field must not be empty")
    private String name;

    @NotEmpty(message = "Field must not be empty")
    private String kind;
}
