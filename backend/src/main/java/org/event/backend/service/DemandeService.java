package org.event.backend.service;

import org.event.backend.dto.DemandeDTO;

import java.util.List;

public interface DemandeService {
    DemandeDTO save(DemandeDTO dto);
    List<DemandeDTO> getAll();
    DemandeDTO getById(Long id);
    DemandeDTO update(Long id, DemandeDTO dto);
    void delete(Long id);
}
