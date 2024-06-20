package br.com.th4mz0.forum_hub.domain.curso.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}