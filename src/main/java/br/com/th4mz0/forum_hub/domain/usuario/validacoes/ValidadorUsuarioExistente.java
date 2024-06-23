package br.com.th4mz0.forum_hub.domain.usuario.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import br.com.th4mz0.forum_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorUsuarioExistente implements ValidadorUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(PostRegisterDTO postRegisterDTO) {

        if(usuarioRepository.existsByEmail(postRegisterDTO.email())){
            throw new ValidacaoException("Já existe um usuario com esse E-mail! ");
        }


    }
}
