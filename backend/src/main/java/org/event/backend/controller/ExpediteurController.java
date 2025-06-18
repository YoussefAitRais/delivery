package org.event.backend.controller;

import lombok.RequiredArgsConstructor;
import org.event.backend.dto.ExpediteurDTO;
import org.event.backend.service.ExpediteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expediteurs")
@RequiredArgsConstructor
public class ExpediteurController {

    private final ExpediteurService expediteurService;

    @PostMapping
    public ResponseEntity<ExpediteurDTO> save(@RequestBody ExpediteurDTO dto) {
        return ResponseEntity.ok(expediteurService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ExpediteurDTO>> getAll() {
        return ResponseEntity.ok(expediteurService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpediteurDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(expediteurService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpediteurDTO> update(@PathVariable Long id, @RequestBody ExpediteurDTO dto) {
        return ResponseEntity.ok(expediteurService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expediteurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
