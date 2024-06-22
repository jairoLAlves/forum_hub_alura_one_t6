package br.com.th4mz0.forum_hub.controller;


import br.com.th4mz0.forum_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;


    @PostMapping
    public ResponseEntity<TopicoInfoAllDTO> postTopico(@RequestBody @Valid PostTopicoDTO postTopicoDTO){
        var topicoInfo = topicoService.save(postTopicoDTO);
        return ResponseEntity.ok(topicoInfo);
    }


    // TODO GET ALL Topicos rota /topicos exibir os 10 primerios topicos pela data de criação em ordem ASC

    // TODO - DELETE  Topico  rota /topicos/{id}

    // TODO - GET  Topico  rota /topicos/{id}

    // TODO - PUT  Topico  rota /topicos/{id}




}
