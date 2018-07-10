package project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ArticleDto {

    @NotEmpty(message = "Field Title is empty")
    private String title;

//    @NotEmpty(message = "Field must not be empty")
//    private String description;

    @NotEmpty(message = "Field Dino Kind is empty")
    private String dinoKind;

    @NotEmpty(message = "Field Dino Name is empty")
    private String dinoName;
}
