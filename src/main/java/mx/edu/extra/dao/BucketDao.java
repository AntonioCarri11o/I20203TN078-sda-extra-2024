package mx.edu.extra.dao;

import mx.edu.extra.model.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketDao  extends JpaRepository<Bucket, Long> {

}
