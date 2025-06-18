package org.event.backend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.event.backend.Entity.Colis;
import org.event.backend.dto.ColisDTO;
import org.event.backend.repository.ColisRepository;
import org.event.backend.service.ColisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColisServiceImpl implements ColisService {

    private final ColisRepository colisRepository;

    @Override
    public ColisDTO save(ColisDTO dto) {
        Colis colis = new Colis();
        colis.setDimensions(dto.getDimensions());
        colis.setPoids(dto.getPoids());
        colis.setTypeColis(dto.getTypeColis());
        colis.setLongueur(dto.getLongueur());
        colis.setLargeur(dto.getLargeur());
        colis.setHauteur(dto.getHauteur());

        return convertToDto(colisRepository.save(colis));
    }

    @Override
    public ColisDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ColisDTO> getAll() {
        return List.of();
    }

    @Override
    public ColisDTO update(Long id, ColisDTO dto) {
        Colis colis = colisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colis non trouvé"));

        colis.setDimensions(dto.getDimensions());
        colis.setPoids(dto.getPoids());
        colis.setTypeColis(dto.getTypeColis());
        colis.setLongueur(dto.getLongueur());
        colis.setLargeur(dto.getLargeur());
        colis.setHauteur(dto.getHauteur());

        return convertToDto(colisRepository.save(colis));
    }

    @Override
    public void delete(Long id) {

    }

    private ColisDTO convertToDto(Colis colis) {
        return new ColisDTO(
                colis.getId(),
                colis.getDimensions(),
                colis.getTypeColis(),
                colis.getPoids(),
                colis.getLongueur(),
                colis.getLargeur(),
                colis.getHauteur()
        );
    }

}
