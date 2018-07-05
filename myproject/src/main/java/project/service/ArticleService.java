package project.service;

import project.entity.Article;

import java.util.List;

public interface ArticleService {

    void saveArticle(Article article);

    void deleteArticle(Article article);

    Article findById(Long id);

    List<Article> findAll();

    List<Article> findAllByUserId(Long id);

    List<Article> findByTitle(String title);

    void updateArticle(String title, Long id);
}
