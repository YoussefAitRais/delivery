package org.event.backend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.event.backend.Entity.*;
import org.event.backend.dto.*;
import org.event.backend.repository.UtilisateurRepository;
import org.event.backend.service.AuthService;
import org.event.backend.Security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(RegisterRequestDTO request) {
        Utilisateur utilisateur = switch (Role.valueOf(request.getRole())) {
            case CONDUCTEUR -> new Conducteur();
            case EXPEDITEUR -> new Expediteur();
            default -> throw new IllegalArgumentException("Rôle non supporté");
        };

        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(Role.valueOf(request.getRole()));
        utilisateur.setVerifie(false);

        utilisateurRepository.save(utilisateur);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Utilisateur user = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        String token = jwtUtil.generateToken(user);

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        return response;
    }
}
