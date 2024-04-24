package mx.edu.extra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "bucket")
public class Bucket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bucket")
    Long Id;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "article_bucket",
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "id_bucket")
    )
    Set<Article> articles;

    public Bucket(Set<Article> articles) {
        this.articles = articles;
    }
}
