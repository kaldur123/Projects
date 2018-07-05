package project.mapper;

import project.dto.CommentDto;
import project.entity.Comment;

public class CommentMapper {

    public static Comment convertToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        return comment;
    }

    public static CommentDto convertToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setText(comment.getText());
        commentDto.setWriterName(comment.getWriter().getFullName());
        return commentDto;
    }
}
