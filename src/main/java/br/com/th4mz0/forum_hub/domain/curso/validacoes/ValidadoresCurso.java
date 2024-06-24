package br.com.th4mz0.forum_hub.domain.curso.validacoes;

import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.curso.DadosPostCursoDTO;

public interface ValidadoresCurso extends Validadores<DadosPostCursoDTO> {

    void validar(DadosPostCursoDTO dados);
}
