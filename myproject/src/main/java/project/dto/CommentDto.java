package project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDto {

    @NotEmpty(message = "Field must not be empty")
    private String text;

    @NotEmpty(message = "Field must not be empty")
    private String writerName;
}
