package br.com.th4mz0.forum_hub.domain.curso;



public record DadosGetInfoCurso(
        Long id,
        String nome,
        String categoria
) {
    public DadosGetInfoCurso(Curso c){
        this(
                c.getId(),
                c.getNome(),
                c.getCategoria()
        );

    }
}
