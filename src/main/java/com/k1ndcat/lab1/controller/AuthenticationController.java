package com.k1ndcat.lab1.controller;

import com.k1ndcat.lab1.dto.AuthenticationRequest;
import com.k1ndcat.lab1.dto.AuthenticationResponse;
import com.k1ndcat.lab1.dto.RegisterRequest;
import com.k1ndcat.lab1.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody @Valid RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) {
        return authService.authenticate(request);
    }
}
