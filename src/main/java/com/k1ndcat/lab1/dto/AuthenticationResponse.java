package com.k1ndcat.lab1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(name = "AuthenticationResponse", description = "Ответ с JWT токеном")
@Builder
@Data
public class AuthenticationResponse {

    @Schema(description = "JWT токен доступа", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", nullable = false)
    private String accessToken;
}