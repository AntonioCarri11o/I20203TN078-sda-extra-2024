package mx.edu.extra.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.extra.model.Article;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ArticleDto {
    @NotBlank(message = "Property 'name' required")
    @Size(max = 30, message = "Property 'name' allows max 30 characters.")
    String name;
    @NotNull(message = "Property 'price' is requiered.")
    @Max(value = 9999, message = "Property 'price' only allows 4 digits.")
    @PositiveOrZero(message = "Property 'price' only could be positive or zero.")
    double price;
    @NotBlank(message = "Property 'code' required.")
    @Size(min = 4, message = "Property 'code' only allows 4 characters.")
    @Pattern(regexp = "^[1-9]{4}$", message = "Property 'code' only allows numeric characters.")
    String code;
    @NotBlank(message = "Property 'description' required.")
    @Size(message = "Property 'description' allows max 300 characters.")
    String description;

    public Article createArticle() {
        Article article = new Article(
                this.name,
                this.price,
                this.code,
                this.description
        );
        return article;
    }
}
