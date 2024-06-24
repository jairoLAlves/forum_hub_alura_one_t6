package br.com.th4mz0.forum_hub.domain.perfil.validacoes;

import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;

public interface ValidadoresPerfil extends Validadores<PostRegisterDTO> {

     void validar(PostRegisterDTO dados);

}
