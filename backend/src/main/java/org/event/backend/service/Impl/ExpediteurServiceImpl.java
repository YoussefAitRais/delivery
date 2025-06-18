package org.event.backend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.event.backend.Entity.Expediteur;
import org.event.backend.Entity.Role;
import org.event.backend.dto.ExpediteurDTO;
import org.event.backend.repository.ExpediteurRepository;
import org.event.backend.service.ExpediteurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpediteurServiceImpl implements ExpediteurService {

    private final ExpediteurRepository expediteurRepository;

    @Override
    public ExpediteurDTO save(ExpediteurDTO dto) {
        Expediteur expediteur = convertToEntity(dto);
        return convertToDTO(expediteurRepository.save(expediteur));
    }

    @Override
    public ExpediteurDTO getById(Long id) {
        return convertToDTO(
                expediteurRepository.findById(id).orElseThrow(() -> new RuntimeException("Expediteur non trouvé"))
        );
    }

    @Override
    public List<ExpediteurDTO> getAll() {
        return expediteurRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ExpediteurDTO update(Long id, ExpediteurDTO dto) {
        Expediteur expediteur = expediteurRepository.findById(id).orElseThrow();
        expediteur.setNom(dto.getNom());
        expediteur.setPrenom(dto.getPrenom());
        expediteur.setEmail(dto.getEmail());
        expediteur.setTelephone(dto.getTelephone());
        return convertToDTO(expediteurRepository.save(expediteur));
    }

    @Override
    public void delete(Long id) {
        expediteurRepository.deleteById(id);
    }

    private Expediteur convertToEntity(ExpediteurDTO dto) {
        Expediteur expediteur = new Expediteur();

        expediteur.setId(dto.getId());
        expediteur.setNom(dto.getNom());
        expediteur.setPrenom(dto.getPrenom());
        expediteur.setEmail(dto.getEmail());
        expediteur.setTelephone(dto.getTelephone());

        expediteur.setPassword("123456");
        expediteur.setRole(Role.EXPEDITEUR);
        expediteur.setVerifie(false);

        return expediteur;
    }

    private ExpediteurDTO convertToDTO(Expediteur e) {
        return new ExpediteurDTO(e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getTelephone());
    }
}
