package org.event.backend.dto;

import lombok.Data;

@Data
public class UtilisateurResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private boolean verifie;
}
