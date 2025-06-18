package org.event.backend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.event.backend.Entity.*;
import org.event.backend.dto.DemandeDTO;
import org.event.backend.repository.ColisRepository;
import org.event.backend.repository.DemandeRepository;
import org.event.backend.repository.ExpediteurRepository;
import org.event.backend.repository.TrajetRepository;
import org.event.backend.service.DemandeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository demandeRepository;
    private final ColisRepository colisRepository;
    private final TrajetRepository trajetRepository;
    private final ExpediteurRepository expediteurRepository;

    @Override
    public DemandeDTO save(DemandeDTO dto) {
        // ✅ Vérification de l'existence des entités liées
        Colis colis = colisRepository.findById(dto.getColisId())
                .orElseThrow(() -> new RuntimeException("Colis introuvable avec l'ID: " + dto.getColisId()));
        Trajet trajet = trajetRepository.findById(dto.getTrajetId())
                .orElseThrow(() -> new RuntimeException("Trajet introuvable avec l'ID: " + dto.getTrajetId()));
        Expediteur expediteur = expediteurRepository.findById(dto.getExpediteurId())
                .orElseThrow(() -> new RuntimeException("Expéditeur introuvable avec l'ID: " + dto.getExpediteurId()));

        // ✅ Création et assignation des champs
        Demande demande = new Demande();
        demande.setDate(LocalDate.now());
        demande.setStatus(Status.EN_ATTENTE);
        demande.setColis(colis);
        demande.setTrajet(trajet);
        demande.setExpediteur(expediteur);

        return convertToDTO(demandeRepository.save(demande));
    }

    @Override
    public List<DemandeDTO> getAll() {
        return demandeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDTO getById(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'ID: " + id));
        return convertToDTO(demande);
    }

    @Override
    public DemandeDTO update(Long id, DemandeDTO dto) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'ID: " + id));
        demande.setStatus(Status.valueOf(dto.getEtat()));
        return convertToDTO(demandeRepository.save(demande));
    }

    @Override
    public void delete(Long id) {
        if (!demandeRepository.existsById(id)) {
            throw new RuntimeException("Demande avec l'ID: " + id + " n'existe pas.");
        }
        demandeRepository.deleteById(id);
    }

    private DemandeDTO convertToDTO(Demande demande) {
        return new DemandeDTO(
                demande.getId(),
                demande.getDate(),
                demande.getStatus().name(),
                demande.getTrajet().getId(),
                demande.getColis().getId(),
                demande.getExpediteur().getId()
        );
    }
}
