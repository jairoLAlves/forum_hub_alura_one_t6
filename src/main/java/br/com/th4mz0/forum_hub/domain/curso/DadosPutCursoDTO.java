package br.com.th4mz0.forum_hub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosPutCursoDTO(
        @NotNull
        Long id,
        String nome,
        String categoria
) {
}
