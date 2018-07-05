package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select a from Article a where a.writer.id = :id")
    List<Article> findAllByUserId(@Param("id")Long id);

    @Query("select a from Article a where a.title = :title")
    List<Article> findByTitle(@Param("title") String title);

//    @Query("update Article a set a.title = :title, a.description = :description where a.id = :id")
//    void updateArticle(@Param("title") String title, @Param("description") String s, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Article a set a.title = :title where a.id = :id")
    void updateArticle(@Param("title") String title, @Param("id") Long id);
}
