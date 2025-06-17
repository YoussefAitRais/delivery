package org.event.backend.dto;

import lombok.Data;

@Data
public class DemandeResponseDTO {

    private Long id;
    private String status;

    private String destinationFinale;
    private String typeMarchandise;

    private ColisDTO colis;
}
