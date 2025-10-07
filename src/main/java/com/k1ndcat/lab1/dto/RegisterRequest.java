package com.k1ndcat.lab1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "RegisterRequest", description = "Данные для регистрации нового пользователя")
@Data
public class RegisterRequest {

    @Schema(description = "Уникальное имя пользователя", example = "john_doe", nullable = false)
    @NotBlank
    private String username;

    @Schema(description = "Пароль пользователя", example = "P@ssw0rd", nullable = false)
    @NotBlank @Size(min = 6, max = 100)
    private String password;
}