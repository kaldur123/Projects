package project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ImageDto {

    @NotEmpty(message = "Field must not be empty")
    private String image;
}
