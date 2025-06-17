package org.event.backend.dto;

import lombok.Data;

@Data
public class UtilisateurRegisterDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
