package br.com.th4mz0.forum_hub.domain.topico.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.topico.PostTopicoDTO;
import br.com.th4mz0.forum_hub.domain.usuario.UsuarioRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorUsuarioExistenteTopico")
public class ValidadorUsuarioExistente  implements ValidacoesTopico{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(Record dados) {
        PostTopicoDTO postTopicoDTO = dados instanceof PostTopicoDTO ? ((PostTopicoDTO) dados) : null;
        assert postTopicoDTO != null;

        if(!usuarioRepository.existsById(postTopicoDTO.autor())){
            throw new ValidacaoException("Esse usuario não existe");
        }

    }
}
