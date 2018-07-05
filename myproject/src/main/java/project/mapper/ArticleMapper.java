package project.mapper;

import project.dto.ArticleDto;
import project.entity.Article;

public class ArticleMapper {

    public static Article convertToArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        return article;
    }

    public static ArticleDto convertToDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle(article.getTitle());
        articleDto.setDinoName(article.getDino().getName());
        return articleDto;
    }
}
