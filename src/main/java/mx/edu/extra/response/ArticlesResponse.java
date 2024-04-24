package mx.edu.extra.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.extra.model.Article;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ArticlesResponse {
    List<Article> articles;
}
