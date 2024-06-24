package br.com.th4mz0.forum_hub.controller;

import br.com.th4mz0.forum_hub.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursosController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;


    @GetMapping
    public ResponseEntity<Page<DadosGetCursoDTO>> getCursos(Pageable pageable){
        Page<DadosGetCursoDTO> pageCursos = cursoRepository.findAll(pageable).map(DadosGetCursoDTO::new);
        return ResponseEntity.ok(pageCursos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postCurso(@RequestBody @Valid DadosPostCursoDTO dados){

        Curso curso = cursoService.save(dados);
        var cursoInfoDTO = new DadosGetInfoCursoDTO(curso);

        return ResponseEntity.ok().body(cursoInfoDTO);

    }

    @PutMapping
    @Transactional
    public ResponseEntity putCurso(@RequestBody @Valid DadosPutCursoDTO dados){

        Curso curso = cursoRepository.getReferenceById(dados.id());

        curso.update(dados);


        return ResponseEntity.ok().body(new DadosGetCursoDTO(curso));

    }


    @GetMapping("/{id}")
    public ResponseEntity getCurso(@PathVariable Long id){
        // TODO - Verificar
        var curso =  cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosGetInfoCursoDTO(curso));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteCurso(@PathVariable Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
