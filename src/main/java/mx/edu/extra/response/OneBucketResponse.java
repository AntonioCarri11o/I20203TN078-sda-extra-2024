package mx.edu.extra.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.extra.model.Article;
import mx.edu.extra.model.Bucket;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OneBucketResponse {
    Bucket bucket;
    double total;
    public OneBucketResponse(Bucket bucket) {
        this.bucket = bucket;
        this.total = getTotal();
    }
    private double getTotal() {
        double total = 0;
        for(Article article : bucket.getArticles()) {
            total += article.getPrice();
        }
        return total;
    }
}
