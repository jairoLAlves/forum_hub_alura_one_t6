package br.com.th4mz0.forum_hub.domain.topico.validacoes;

import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.topico.PostTopicoDTO;

public interface ValidacoesTopico extends Validadores<PostTopicoDTO> {

     void validar(PostTopicoDTO dados);
}
