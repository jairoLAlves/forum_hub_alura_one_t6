package br.com.th4mz0.forum_hub.domain.topico;


import br.com.th4mz0.forum_hub.domain.curso.DadosGetInfoCursoDTO;
import br.com.th4mz0.forum_hub.domain.usuario.DadosUsuarioInfoDTO;

import java.time.LocalDateTime;

public record TopicoInfoAllDTO(
     Long id,
     String titulo,
     String mensagem,
     LocalDateTime dataCriacao,
     Boolean status,
     DadosUsuarioInfoDTO autor,
     DadosGetInfoCursoDTO curso
    //List<Resposta> respostas;
)
{

    public TopicoInfoAllDTO(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                 new DadosUsuarioInfoDTO(topico.getAutor()),
                new DadosGetInfoCursoDTO(topico.getCurso())
        );
    }
}
