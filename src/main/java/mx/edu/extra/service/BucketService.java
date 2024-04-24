package mx.edu.extra.service;

import jakarta.persistence.EntityNotFoundException;
import mx.edu.extra.dao.ArticleDao;
import mx.edu.extra.dao.BucketDao;
import mx.edu.extra.dto.BucketDTO;
import mx.edu.extra.model.Article;
import mx.edu.extra.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BucketService {
    @Autowired
    BucketDao bucketDao;
    @Autowired
    ArticleDao articleDao;
    public void save(BucketDTO bucketDTO) {
        Long [] articles = bucketDTO.getArticles();
        Set<Article> articlesSet = new HashSet<>();
        for (Long id : articles) {
            Optional<Article> articleOptional = articleDao.findById(id);
            if (articleOptional.isEmpty()) {
                throw  new EntityNotFoundException("Article with id: " + id + "not founded.");
            }
            articlesSet.add(articleOptional.get());
        }
        Bucket bucket = new Bucket(articlesSet);
        bucketDao.save(bucket);
    }
}
