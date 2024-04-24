package mx.edu.extra.service;

import jakarta.validation.*;
import mx.edu.extra.dao.ArticleDao;
import mx.edu.extra.dto.ArticleDto;
import mx.edu.extra.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    public List<Article> list() {
        return articleDao.findAll();
    }

    public void save(ArticleDto articleDto) throws Exception {
        Optional<Article> articleOptional = articleDao.findArticleByCode(articleDto.getCode());
        if(!articleOptional.isEmpty()) {
            throw new Exception("Codigo ya registrado");
        }
        Article article = articleDto.createArticle();
        articleDao.save(article);
    }
}
