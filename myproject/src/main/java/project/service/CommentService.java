package project.service;

import project.entity.Comment;

import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);

    Comment findById(Long id);

    List<Comment> findAll();

    List<Comment> findAllByArticleId(Long id);
}
