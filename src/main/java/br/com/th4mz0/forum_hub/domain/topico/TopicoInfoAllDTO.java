package br.com.th4mz0.forum_hub.domain.topico;




public record TopicoInfoAllDTO(
     Long id,
     String mensagem,
     String dataCriacao,
     Boolean status,
     Long autor,
     Long curso
    //List<Resposta> respostas;
)
{

}
