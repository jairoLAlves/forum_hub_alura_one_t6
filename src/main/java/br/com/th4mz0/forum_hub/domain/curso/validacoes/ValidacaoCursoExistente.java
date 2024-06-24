package br.com.th4mz0.forum_hub.domain.curso.validacoes;

import br.com.th4mz0.forum_hub.domain.ValidacaoException;
import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.curso.CursoRepository;
import br.com.th4mz0.forum_hub.domain.curso.DadosPostCursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidacaoCursoExistente")
public class ValidacaoCursoExistente implements ValidadoresCurso {

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public void validar(DadosPostCursoDTO dados) {

        if(cursoRepository.existsByNome(dados.nome())){
            throw new ValidacaoException("Já existe um curso com esse nome. ");
        }
    }
}
