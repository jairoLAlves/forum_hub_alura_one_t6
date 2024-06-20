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


    @GetMapping
    public ResponseEntity<Page<DadosGetCurso>> getCursos(Pageable pageable){
        Page<DadosGetCurso> pageCursos = cursoRepository.findAll(pageable).map(DadosGetCurso::new);
        return ResponseEntity.ok(pageCursos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postCurso(@RequestBody @Valid DadosPostCurso dados){

        Curso curso = new Curso(dados);
        cursoRepository.save(curso);

        return ResponseEntity.ok().body(curso);

    }

    @PutMapping
    @Transactional
    public ResponseEntity putCurso(@RequestBody @Valid DadosPutCurso dados){

        Curso curso = cursoRepository.getReferenceById(dados.id());

        curso.update(dados);


        return ResponseEntity.ok().body(new DadosGetCurso(curso));

    }


    @GetMapping("/{id}")
    public ResponseEntity getCurso(@PathVariable Long id){
        var curso =  cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosGetInfoCurso(curso));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteCurso(@PathVariable Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
