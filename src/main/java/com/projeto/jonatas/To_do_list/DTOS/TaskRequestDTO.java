package com.projeto.jonatas.To_do_list.DTOS;

import com.projeto.jonatas.To_do_list.model.Status;
import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String title,
        String description,
        Status status
) {

}
