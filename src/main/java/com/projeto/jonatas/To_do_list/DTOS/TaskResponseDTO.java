package com.projeto.jonatas.To_do_list.DTOS;

import com.projeto.jonatas.To_do_list.model.Status;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        Status status
) {
}
