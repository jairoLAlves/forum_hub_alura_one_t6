package br.com.th4mz0.forum_hub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Curso")
@Table(name = "cursos")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;


    public Curso(DadosPostCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void update(DadosPutCurso c){
        if (c.categoria() != null && !c.categoria().isBlank()){
            this.categoria = c.categoria();
        }
        if (c.nome() != null && !c.nome().isBlank()){
            this.nome = c.nome();
        }

    }
}
