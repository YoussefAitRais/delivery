package org.event.backend.service.Impl;

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

    @GetMapping
    public List<TrajetDTO> getAll() {
        return trajetService.getAll();
    }

    @GetMapping("/demandes")
    public List<TrajetDTO> getDemandes() {
        return trajetService.getDemandes();
    }

    @GetMapping("/{id}")
    public TrajetDTO getById(@PathVariable Long id) {
        return trajetService.getById(id);
    }

    @PutMapping("/{id}")
    public TrajetDTO update(@PathVariable Long id, @RequestBody TrajetDTO dto) {
        return trajetService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trajetService.delete(id);
        return ResponseEntity.ok().build();
    }
}
