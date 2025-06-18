package org.event.backend.service;

import org.event.backend.dto.ExpediteurDTO;
import java.util.List;

public interface ExpediteurService {
    ExpediteurDTO save(ExpediteurDTO dto);
    ExpediteurDTO getById(Long id);
    List<ExpediteurDTO> getAll();
    ExpediteurDTO update(Long id, ExpediteurDTO dto);
    void delete(Long id);
}
