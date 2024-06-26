package br.com.th4mz0.forum_hub.domain.topico.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.curso.CursoRepository;
import br.com.th4mz0.forum_hub.domain.curso.CursoService;
import br.com.th4mz0.forum_hub.domain.topico.PostTopicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidacaoCursoExistenteEmTopico")
public class ValidacaoCursoExistente implements ValidacoesTopico {

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public void validar(Record dados) {
        PostTopicoDTO postTopicoDTO = dados instanceof PostTopicoDTO ? ((PostTopicoDTO) dados) : null;

        assert postTopicoDTO != null;
        if(!cursoRepository.existsById(postTopicoDTO.curso())){
            throw new ValidacaoException("Esse curso não existe");
        }


    }
}
