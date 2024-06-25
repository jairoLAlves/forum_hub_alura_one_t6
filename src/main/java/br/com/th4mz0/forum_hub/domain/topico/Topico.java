package br.com.th4mz0.forum_hub.domain.topico;

import br.com.th4mz0.forum_hub.domain.curso.Curso;
import br.com.th4mz0.forum_hub.domain.resposta.Resposta;
import br.com.th4mz0.forum_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String mensagem;

    private String titulo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;


    public Topico(Usuario autor, Curso curso, String titulo, String mensagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.curso = curso;
        this.mensagem = mensagem;

    }



}
