package br.com.th4mz0.forum_hub.domain.topico;


import br.com.th4mz0.forum_hub.domain.curso.Curso;
import br.com.th4mz0.forum_hub.domain.curso.CursoRepository;
import br.com.th4mz0.forum_hub.domain.topico.validacoes.ValidacoesTopico;
import br.com.th4mz0.forum_hub.domain.topico.validacoes.ValidadoresUpdateTopico;
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

    @Autowired
    private List<ValidadoresUpdateTopico> validadoresUpdate;

    public TopicoInfoAllDTO save(PostTopicoDTO dados){

        // titulo e mensagem são unicas
        validacoesTopico.forEach(v->v.validar(dados));


        Curso curso = cursoRepository.getReferenceById(dados.curso());

        Usuario auth = usuarioRepository.getReferenceById(dados.curso());

        var topico = new Topico(auth, curso, dados.titulo(), dados.mensagem());

         topicoRepository.save(topico);


        return new TopicoInfoAllDTO(topico);
    }

    public Topico update(PutTopicosDTO dados) {

        validadoresUpdate.forEach(v->v.validar(dados));

        Topico topico = topicoRepository.getReferenceById(dados.id());

        if(dados.titulo() != null && !dados.titulo().isBlank()){
            topico.setTitulo(dados.titulo());
        }

        if(dados.status() != null){
            topico.setStatus(dados.status());
        }

        // TODO - Setter outros parametros


        return topico;



    }
}
