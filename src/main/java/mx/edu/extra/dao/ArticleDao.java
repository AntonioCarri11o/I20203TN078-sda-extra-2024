package mx.edu.extra.dao;

import mx.edu.extra.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {
    Optional<Article> findArticleByCode(String code);
}
