package org.event.backend.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role; // "CONDUCTEUR", "EXPEDITEUR", etc.
}
