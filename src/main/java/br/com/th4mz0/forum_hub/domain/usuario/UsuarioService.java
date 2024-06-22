package br.com.th4mz0.forum_hub.domain.usuario;

import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public void save(PostRegisterDTO postRegisterDTO) {

        // TODO - Verificar se o usuario ja existe no banco de dados, se existir retornar um Exception do tipo UsuarioException
        // TODO - criptografar a senha para BCryptPasswordEncoder
        // TODO - Verificar as os Perfis passados
        // TODO - Criar um novo Usuario com os seus Perfis
        // TODO - Salvar usuario


    }
}
