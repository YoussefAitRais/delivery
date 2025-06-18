package org.event.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpediteurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}
