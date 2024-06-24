package br.com.th4mz0.forum_hub.domain.topico;


import br.com.th4mz0.forum_hub.domain.curso.Curso;
import br.com.th4mz0.forum_hub.domain.curso.CursoRepository;
import br.com.th4mz0.forum_hub.domain.topico.validacoes.ValidacoesTopico;
import br.com.th4mz0.forum_hub.domain.usuario.Usuario;
import br.com.th4mz0.forum_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidacoesTopico> validacoesTopico;

    public TopicoInfoAllDTO save(PostTopicoDTO dados){

        // titulo e mensagem são unicas
        validacoesTopico.forEach(v->v.validar(dados));


        Curso curso = cursoRepository.getReferenceById(dados.curso());

        Usuario auth = usuarioRepository.getReferenceById(dados.curso());

        var topico = new Topico(auth, curso, dados.titulo(), dados.mensagem());

         topicoRepository.save(topico);


        return new TopicoInfoAllDTO(topico);
    }
}
