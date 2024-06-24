package br.com.th4mz0.forum_hub.domain.curso;



public record DadosGetInfoCursoDTO(
        Long id,
        String nome,
        String categoria
) {
    public DadosGetInfoCursoDTO(Curso c){
        this(
                c.getId(),
                c.getNome(),
                c.getCategoria()
        );

    }
}
