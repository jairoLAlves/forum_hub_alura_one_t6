package br.com.th4mz0.forum_hub.domain.perfil.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import br.com.th4mz0.forum_hub.domain.perfil.Perfis;
import br.com.th4mz0.forum_hub.domain.usuario.validacoes.ValidadorUsuario;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPerfil implements ValidadorUsuario {
    @Override
    public void validar(PostRegisterDTO postRegisterDTO) {
        var perfilsString  = postRegisterDTO.perfis();

        for (String pf : perfilsString){
            try {
                Perfis.fromValue(pf);
            }catch (IllegalArgumentException ex){
               throw  new ValidacaoException(ex.getMessage());
            }
        }
    }
}
