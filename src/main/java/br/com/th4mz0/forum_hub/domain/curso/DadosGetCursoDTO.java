package br.com.th4mz0.forum_hub.domain.curso;

public record DadosGetCursoDTO(
        String nome,
        String categoria

) {
   public DadosGetCursoDTO(Curso curso){
        this(curso.getNome(), curso.getCategoria());
    }
}
