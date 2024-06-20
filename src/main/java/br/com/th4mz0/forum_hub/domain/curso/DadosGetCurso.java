package br.com.th4mz0.forum_hub.domain.curso;

public record DadosGetCurso(
        String nome,
        String categoria

) {
   public DadosGetCurso(Curso curso){
        this(curso.getNome(), curso.getCategoria());
    }
}
