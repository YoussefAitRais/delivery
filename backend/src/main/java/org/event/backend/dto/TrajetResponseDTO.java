package org.event.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TrajetResponseDTO {
    private Long id;
    private String lieuDepart;
    private String destinationFinale;
    private String typeMarchandise;
    private Double capaciteDisponible;
    private LocalDate dateDepart;
}
