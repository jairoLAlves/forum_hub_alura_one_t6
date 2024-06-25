package br.com.th4mz0.forum_hub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PutTopicosDTO(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        Boolean status,
        Long autor,
        Long curso
) {
}
