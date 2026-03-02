package com.appfit.activities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivityRequestDTO(
        @NotNull(message = "O ID do usuário é Obrigatório")
        long userID,

        @NotBlank(message = "O título não pode estar vazio")
        String title,

        String description,

        Integer duration
){}
