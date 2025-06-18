package org.event.backend.service;

import org.event.backend.dto.ColisDTO;

import java.util.List;

public interface ColisService {
    ColisDTO save(ColisDTO dto);
    ColisDTO getById(Long id);
    List<ColisDTO> getAll();
    ColisDTO update(Long id, ColisDTO dto);
    void delete(Long id);
}
