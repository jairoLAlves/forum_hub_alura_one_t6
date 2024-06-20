package br.com.th4mz0.forum_hub.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity
                .badRequest()
                .body(erros.stream().map(DadosErrorValidacao::new).toList());
    }

    private record DadosErrorValidacao(
            String campo,
            String mensagem
    ){
        public DadosErrorValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }


    }

}
