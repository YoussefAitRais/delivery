package org.event.backend.service;

import org.event.backend.dto.LoginRequestDTO;
import org.event.backend.dto.LoginResponseDTO;
import org.event.backend.dto.RegisterRequestDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
    void register(RegisterRequestDTO request);
}
