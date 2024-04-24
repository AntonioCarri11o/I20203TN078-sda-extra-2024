package mx.edu.extra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "Article")
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_article")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    double price;
    @Column(name = "code")
    String code;
    @Column(name = "description", columnDefinition = "text")
    String description;

    public Article(String name, double price, String code, String description) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.description = description;
    }
}
