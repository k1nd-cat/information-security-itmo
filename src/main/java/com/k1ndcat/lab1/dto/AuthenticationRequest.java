package com.k1ndcat.lab1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(name = "AuthenticationRequest", description = "Данные для входа пользователя")
@Data
public class AuthenticationRequest {

    @Schema(description = "Имя пользователя", example = "john_doe", nullable = false)
    @NotBlank
    private String username;

    @Schema(description = "Пароль пользователя", example = "P@ssw0rd", nullable = false)
    @NotBlank
    private String password;
}