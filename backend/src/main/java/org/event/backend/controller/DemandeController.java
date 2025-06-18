package org.event.backend.controller;

import lombok.RequiredArgsConstructor;
import org.event.backend.dto.DemandeDTO;
import org.event.backend.service.DemandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
public class DemandeController {

    private final DemandeService demandeService;

    @PostMapping
    public ResponseEntity<DemandeDTO> create(@RequestBody DemandeDTO dto) {
        return ResponseEntity.ok(demandeService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<DemandeDTO>> getAll() {
        return ResponseEntity.ok(demandeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(demandeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeDTO> update(@PathVariable Long id, @RequestBody DemandeDTO dto) {
        return ResponseEntity.ok(demandeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        demandeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
