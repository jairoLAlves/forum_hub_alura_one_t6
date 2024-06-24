package br.com.th4mz0.forum_hub.domain.topico;

import br.com.th4mz0.forum_hub.domain.curso.DadosGetInfoCursoDTO;
import br.com.th4mz0.forum_hub.domain.usuario.DadosUsuarioInfoDTO;

import java.time.LocalDateTime;

public record TopicoInfoDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean status,
        Long autor,
        Long curso
        //List<Resposta> respostas;
)
{

    public TopicoInfoDTO(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        );
    }
}