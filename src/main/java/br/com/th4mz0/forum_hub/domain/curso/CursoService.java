package br.com.th4mz0.forum_hub.domain.curso;

import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.curso.validacoes.ValidadoresCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadoresCurso> validadores;

    public Curso save(DadosPostCursoDTO dados){
        validadores.forEach(v->v.validar(dados));

        var curso = new Curso(dados);

        cursoRepository.save(curso);

        return curso;
    }

}
