package org.event.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lieuDepart;
    private String destinationFinale;

    @ElementCollection
    private List<String> etapesIntermediaires;

    private String demensionsMaximalesAcceptees; // chaîne JSON أو format libre
    private String typeMarchandise;

    private Double capaciteDisponible;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL)
    private List<Demande> demandes;
}
