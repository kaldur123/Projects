package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.dto.filters.ArticleFilter;
import project.entity.Article;

import java.util.List;

public interface ArticleService {

    void saveArticle(Article article);

    void deleteArticle(Article article);

    Article findById(Long id);

    Article getById(Long id);

    List<Article> findAll();

    Page<Article> findAllByPage(Pageable pageable);

    Page<Article> findAllByFilter(ArticleFilter articleFilter, Pageable pageable);

    List<Article> findByFilter(ArticleFilter articleFilter, Long id);

    List<Article> findAllByUserId(Long id);

    List<Article> findByTitle(String title);

    void updateArticle(String title, Long id);
}
