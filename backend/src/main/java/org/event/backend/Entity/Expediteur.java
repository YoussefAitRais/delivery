package org.event.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expediteur extends Utilisateur {

    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL)
    private List<Demande> demandes;
}
