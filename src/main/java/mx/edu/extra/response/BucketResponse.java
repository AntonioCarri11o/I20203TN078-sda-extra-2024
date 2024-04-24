package mx.edu.extra.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.extra.model.Bucket;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class BucketResponse {
    List<Bucket> buckets;
    public BucketResponse(List<Bucket> buckets) {
        this.buckets = buckets;
    }
}
