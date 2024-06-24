package br.com.th4mz0.forum_hub.domain.curso;

import br.com.th4mz0.forum_hub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


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

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;


    public Curso(DadosPostCursoDTO dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void update(DadosPutCursoDTO c){
        if (c.categoria() != null && !c.categoria().isBlank()){
            this.categoria = c.categoria();
        }
        if (c.nome() != null && !c.nome().isBlank()){
            this.nome = c.nome();
        }

    }
}
