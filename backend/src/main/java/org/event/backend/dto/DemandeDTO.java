package org.event.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeDTO {
    private Long id;
    private LocalDate date;
    private String etat;

    private Long trajetId;
    private Long colisId;
    private Long expediteurId;
}
