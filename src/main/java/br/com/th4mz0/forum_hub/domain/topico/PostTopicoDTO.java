package br.com.th4mz0.forum_hub.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostTopicoDTO(
        @NotBlank
        String mensagem,

        @NotNull
        Long autor,

        @NotNull
        Long curso

) {
}
