package org.event.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class TrajetRequestDTO {
    private String lieuDepart;
    private String destinationFinale;
    private List<String> etapesIntermediaires;
    private String typeMarchandise;
    private String demensionsMaximalesAcceptees;
    private Double capaciteDisponible;
    private Long conducteurId;
}
