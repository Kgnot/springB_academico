package com.frenos_el_control.principal.security.service;


import com.frenos_el_control.principal.auth.service.JwtService;
import com.frenos_el_control.principal.dto.auth.AuthResponse;
import com.frenos_el_control.principal.dto.auth.LoginRequest;
import com.frenos_el_control.principal.dto.auth.RefreshRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(request.getName());
        String accessToken = jwtService.getToken(user);
        String refreshToken = jwtService.getRefreshToken(user);

        return new AuthResponse(accessToken, refreshToken);
    }

    public Optional<AuthResponse> refresh(RefreshRequest request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtService.getUserNameFromToken(refreshToken);

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (jwtService.isRefreshTokenValid(refreshToken, user)) {
            String newAccessToken = jwtService.getToken(user);
            return Optional.of(new AuthResponse(newAccessToken,refreshToken));
        }
        return Optional.empty();
    }

}
