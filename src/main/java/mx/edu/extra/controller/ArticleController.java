package mx.edu.extra.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.extra.dto.ArticleDto;
import mx.edu.extra.model.Article;
import mx.edu.extra.response.ArticlesResponse;
import mx.edu.extra.response.ExceptionResponse;
import mx.edu.extra.response.SuccessResponse;
import mx.edu.extra.service.ArticleService;
import mx.edu.extra.utils.Global;
import mx.edu.extra.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@CrossOrigin(origins = Global.CROSS_ORIGINS_URL)
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            List<Article> articles = articleService.list();
            ArticlesResponse articlesResponse = new ArticlesResponse(articles);
            return ResponseEntity.ok(articlesResponse);
        } catch (Exception e) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
            return ResponseEntity.badRequest().body(exceptionResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ArticleDto articleDto) {
        try {
            articleService.save(articleDto);
            SuccessResponse successResponse = new SuccessResponse("Éxito al guardar");
            return ResponseEntity.ok(successResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
