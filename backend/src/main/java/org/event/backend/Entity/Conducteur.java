package org.event.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Conducteur extends Utilisateur {

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Trajet> trajets;
}
