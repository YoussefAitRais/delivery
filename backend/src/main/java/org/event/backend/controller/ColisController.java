package org.event.backend.controller;

import lombok.RequiredArgsConstructor;
import org.event.backend.dto.ColisDTO;
import org.event.backend.service.ColisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
@RequiredArgsConstructor
public class ColisController {

    private final ColisService colisService;

    @PostMapping
    public ResponseEntity<ColisDTO> createColis(@RequestBody ColisDTO dto) {
        return ResponseEntity.ok(colisService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ColisDTO>> getAllColis() {
        return ResponseEntity.ok(colisService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColisDTO> getColisById(@PathVariable Long id) {
        return ResponseEntity.ok(colisService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColisDTO> updateColis(@PathVariable Long id, @RequestBody ColisDTO dto) {
        return ResponseEntity.ok(colisService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColis(@PathVariable Long id) {
        colisService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
