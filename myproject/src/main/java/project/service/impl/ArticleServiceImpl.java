package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import project.dto.filters.ArticleFilter;
import project.entity.Article;
import project.entity.Dino;
import project.entity.Writer;
import project.exception.ArticleNotFoundException;
import project.repository.ArticleRepository;
import project.service.ArticleService;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired private ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article with id [" + id + "] not found"));
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.getOne(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Specification<Article> getSpecification(ArticleFilter articleFilter) {
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (articleFilter.getSearchTitle().isEmpty()&&articleFilter.getSearchDinoName().isEmpty()) {
                    return null;
                }
                else {
                    Join<Article, Dino> dinoJoin = root.join("dino");
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%" + articleFilter.getSearchTitle() + "%"),
                            criteriaBuilder.like(dinoJoin.get("name"), "%" + articleFilter.getSearchDinoName() + "%"));

                }
            }
        };
    }

    public Specification<Article> getSpecification(ArticleFilter articleFilter, Long id) {
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (articleFilter.getSearchTitle().isEmpty()&&articleFilter.getSearchDinoName().isEmpty()) {
                    Join<Article, Writer> writerJoin = root.join("writer");
                    return criteriaBuilder.equal(writerJoin.get("id"), id);
                }
                else {
                    Join<Article, Dino> dinoJoin = root.join("dino");
                    Join<Article, Writer> writerJoin = root.join("writer");
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%" + articleFilter.getSearchTitle() + "%"),
                            criteriaBuilder.like(dinoJoin.get("name"), "%" + articleFilter.getSearchDinoName() + "%"),
                            criteriaBuilder.equal(writerJoin.get("id"), id));

                }
            }
        };
    }

    @Override
    public List<Article> findByFilter(ArticleFilter articleFilter, Long id) {
        return articleRepository.findAll(getSpecification(articleFilter, id));
    }

    @Override
    public Page<Article> findAllByPage(Pageable pageable) {
        return articleRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    @Override
    public Page<Article> findAllByFilter(ArticleFilter articleFilter, Pageable pageable) {
        return articleRepository.findAll(getSpecification(articleFilter), PageRequest.of(pageable.getPageNumber(), articleFilter.getSize()));
    }

    @Override
    public List<Article> findAllByUserId(Long id) {
        return articleRepository.findAllByUserId(id);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Override
    public void updateArticle(String title, Long id) {
        articleRepository.updateArticle(title, id);
    }
}
