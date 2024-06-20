package br.com.th4mz0.forum_hub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPutCurso(
        @NotNull
        Long id,
        String nome,
        String categoria
) {
}
