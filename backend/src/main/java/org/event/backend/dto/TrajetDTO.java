package org.event.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrajetDTO {
    private Long id;
    private String lieuDepart;
    private String destinationFinal;
    private List<String> etapesIntermediaires;
    private String demensionsMaximalesAcceptees;
    private String typeMarchandise;
    private Double capaciteDisponible;
}
