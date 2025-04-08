package com.frenos_el_control.principal.controller.auth;


import com.frenos_el_control.principal.dto.auth.AuthResponse;
import com.frenos_el_control.principal.dto.auth.LoginRequest;
import com.frenos_el_control.principal.dto.auth.RefreshRequest;
import com.frenos_el_control.principal.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;


    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest request) {
        Optional<AuthResponse> response = service.refresh(request);
        return response
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


}

