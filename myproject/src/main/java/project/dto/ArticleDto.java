package project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ArticleDto {

    @NotEmpty(message = "Field must not be empty")
    private String title;

//    @NotEmpty(message = "Field must not be empty")
//    private String description;

    @NotEmpty(message = "Field must not be empty")
    private String dinoKind;

    @NotEmpty(message = "Field must not be empty")
    private String dinoName;
}
