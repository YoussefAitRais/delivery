package org.event.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private Expediteur expediteur;

    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajet trajet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colis_id")
    private Colis colis;
}
