package mx.edu.extra.controller;

import jakarta.persistence.EntityNotFoundException;
import mx.edu.extra.dto.BucketDTO;
import mx.edu.extra.response.ExceptionResponse;
import mx.edu.extra.response.SuccessResponse;
import mx.edu.extra.service.BucketService;
import mx.edu.extra.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bucket")
@CrossOrigin(origins = Global.CROSS_ORIGINS_URL)
public class BucketController {
    @Autowired
    BucketService bucketService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BucketDTO bucketDTO) {
        try {
            bucketService.save(bucketDTO);
            return ResponseEntity.ok(new SuccessResponse("Éxito al guardar"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(e.getMessage()));
        }

    }
}
