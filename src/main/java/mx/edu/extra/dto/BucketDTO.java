package mx.edu.extra.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.extra.model.Bucket;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BucketDTO {
    Long id;
    @NotNull(message = "Property 'articles' required.")
    Long[] articles;
    public Bucket createBucket() {
        return new Bucket();
    }
}
