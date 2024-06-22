package br.com.th4mz0.forum_hub.domain.topico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topicoRepository;

    public TopicoInfoAllDTO save(PostTopicoDTO postRegisterDTO){

        // TODO - Verificar os campos
       // TODO - Criar um novo Topico
       // TODO - Retornar  TopicoInfoAllDTO

        return null;
    }
}
