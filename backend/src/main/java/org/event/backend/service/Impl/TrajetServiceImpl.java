package org.event.backend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.event.backend.Entity.Trajet;
import org.event.backend.dto.TrajetDTO;
import org.event.backend.repository.TrajetRepository;
import org.event.backend.service.TrajetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrajetServiceImpl implements TrajetService {

    private final TrajetRepository trajetRepository;

    @Override
    public TrajetDTO save(TrajetDTO dto) {
        Trajet trajet = new Trajet();
        trajet.setLieuDepart(dto.getLieuDepart());
        trajet.setDestinationFinale(dto.getDestinationFinal());
        trajet.setEtapesIntermediaires(dto.getEtapesIntermediaires());
        trajet.setDemensionsMaximalesAcceptees(dto.getDemensionsMaximalesAcceptees());
        trajet.setTypeMarchandise(dto.getTypeMarchandise());
        trajet.setCapaciteDisponible(dto.getCapaciteDisponible());

        return convertToDto(trajetRepository.save(trajet));
    }


    @Override
    public List<TrajetDTO> getAll() {
        return trajetRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrajetDTO getById(Long id) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));
        return convertToDto(trajet);
    }

    @Override
    public TrajetDTO update(Long id, TrajetDTO dto) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));

        trajet.setLieuDepart(dto.getLieuDepart());
        trajet.setDestinationFinale(dto.getDestinationFinal());
        trajet.setEtapesIntermediaires(dto.getEtapesIntermediaires());
        trajet.setDemensionsMaximalesAcceptees(dto.getDemensionsMaximalesAcceptees());
        trajet.setTypeMarchandise(dto.getTypeMarchandise());
        trajet.setCapaciteDisponible(dto.getCapaciteDisponible());

        return convertToDto(trajetRepository.save(trajet));
    }


    @Override
    public void delete(Long id) {
        trajetRepository.deleteById(id);
    }

    private TrajetDTO convertToDto(Trajet t) {
        return new TrajetDTO(
                t.getId(), t.getLieuDepart(), t.getDestinationFinale(),
                t.getEtapesIntermediaires(), t.getDemensionsMaximalesAcceptees(),
                t.getTypeMarchandise(), t.getCapaciteDisponible()
        );
    }
}

