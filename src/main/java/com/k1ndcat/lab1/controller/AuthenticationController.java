package com.k1ndcat.lab1.controller;

import com.k1ndcat.lab1.dto.AuthenticationRequest;
import com.k1ndcat.lab1.dto.AuthenticationResponse;
import com.k1ndcat.lab1.dto.RegisterRequest;
import com.k1ndcat.lab1.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Методы регистрации и входа в систему")
public class AuthenticationController {

    private final AuthenticationService authService;

    @Operation(summary = "Регистрация пользователя", description = "Создает нового пользователя и возвращает JWT токен доступа")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь зарегистрирован"),
            @ApiResponse(responseCode = "400", description = "Пользователь с таким username уже существует"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody @Valid RegisterRequest request) {
        return authService.register(request);
    }

    @Operation(summary = "Вход пользователя", description = "Аутентифицирует пользователя и возвращает JWT токен доступа")
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) {
        return authService.authenticate(request);
    }
}
