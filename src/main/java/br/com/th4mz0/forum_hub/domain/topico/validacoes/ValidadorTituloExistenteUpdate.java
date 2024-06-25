package br.com.th4mz0.forum_hub.domain.topico.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import br.com.th4mz0.forum_hub.domain.topico.PostTopicoDTO;
import br.com.th4mz0.forum_hub.domain.topico.PutTopicosDTO;
import br.com.th4mz0.forum_hub.domain.topico.TopicoRepository;
import br.com.th4mz0.forum_hub.domain.usuario.validacoes.ValidadorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTituloExistenteUpdate implements ValidadoresUpdateTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Record dados) {
        PutTopicosDTO postTopicoDTO = dados instanceof PutTopicosDTO ? ((PutTopicosDTO) dados) : null;

        assert postTopicoDTO != null;

        if(topicoRepository.existsByTitulo(postTopicoDTO.titulo())){
            throw new ValidacaoException("Já existe um tópico com esse título");
        }

    }
}
