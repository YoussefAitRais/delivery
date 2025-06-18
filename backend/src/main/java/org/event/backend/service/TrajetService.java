package org.event.backend.service;

import org.event.backend.dto.TrajetDTO;

import java.util.List;

public interface TrajetService {
    TrajetDTO save(TrajetDTO trajetDTO);
    List<TrajetDTO> getAll();
    TrajetDTO getById(Long id);
    TrajetDTO update(Long id, TrajetDTO trajetDTO);
    void delete(Long id);
}

