package br.com.th4mz0.forum_hub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosPostCurso(
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
