package br.com.th4mz0.forum_hub.domain.topico.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.topico.PostTopicoDTO;
import br.com.th4mz0.forum_hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTituloExistente implements ValidacoesTopico{
    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Record dados) {
        PostTopicoDTO postTopicoDTO = dados instanceof PostTopicoDTO ? ((PostTopicoDTO) dados) : null;

        assert postTopicoDTO != null;
        if(topicoRepository.existsByTitulo(postTopicoDTO.titulo())){
            throw new ValidacaoException("Já existe um tópico com esse título");
        }
    }
}
