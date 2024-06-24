package br.com.th4mz0.forum_hub.domain.usuario;

public record DadosUsuarioInfoDTO(
         Long id,
         String nome,
         String email
) {
    public DadosUsuarioInfoDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getNome());
    }
}
