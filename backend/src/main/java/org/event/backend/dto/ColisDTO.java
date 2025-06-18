package org.event.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColisDTO {
    private Long id;
    private String dimensions;
    private String typeColis;
    private double poids;
    private double longueur;
    private double largeur;
    private double hauteur;
}
