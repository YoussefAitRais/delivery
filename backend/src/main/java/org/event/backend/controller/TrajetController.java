package org.event.backend.controller;

import lombok.RequiredArgsConstructor;
import org.event.backend.dto.TrajetDTO;
import org.event.backend.service.TrajetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajets")
@RequiredArgsConstructor
public class TrajetController {

    private final TrajetService trajetService;

    @PostMapping("/add")
    public ResponseEntity<TrajetDTO> create(@RequestBody TrajetDTO dto) {
        return ResponseEntity.ok(trajetService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<TrajetDTO>> getAll() {
        return ResponseEntity.ok(trajetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrajetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trajetService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrajetDTO> update(@PathVariable Long id, @RequestBody TrajetDTO dto) {
        return ResponseEntity.ok(trajetService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trajetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
