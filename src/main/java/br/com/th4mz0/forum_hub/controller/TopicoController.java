package br.com.th4mz0.forum_hub.controller;


import br.com.th4mz0.forum_hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<TopicoInfoAllDTO> postTopico(@RequestBody @Valid PostTopicoDTO postTopicoDTO){
        TopicoInfoAllDTO topicoInfo = topicoService.save(postTopicoDTO);
        return ResponseEntity.ok(topicoInfo);
    }


    //  GET ALL Topicos rota /topicos exibir os 10 primerios topicos pela data de criação em ordem ASC
    @GetMapping
    public ResponseEntity<Page<TopicoInfoDTO>> getAllTopico(
            @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC)
            Pageable pageable
    ){

        Page<TopicoInfoDTO> page = topicoRepository.findAll(pageable).map(TopicoInfoDTO::new);

        return ResponseEntity.ok(page);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        // TODO - Verificar e apagar depedentes de topico como resposta
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity getTopico(@PathVariable Long id){
        // TODO - Verificar
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new TopicoInfoAllDTO(topico));

    }

    @PutMapping
    @Transactional
    public ResponseEntity putTopico(@RequestBody @Valid PutTopicosDTO dados)  {

        var topico = topicoService.update(dados);

        return ResponseEntity.ok(new TopicoInfoAllDTO(topico));

    }




}
