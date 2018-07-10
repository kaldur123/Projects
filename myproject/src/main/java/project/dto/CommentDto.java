package project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDto {

    @NotEmpty(message = "Field Text is empty")
    private String text;

    @NotEmpty(message = "Field Writer Name is empty")
    private String writerName;
}
