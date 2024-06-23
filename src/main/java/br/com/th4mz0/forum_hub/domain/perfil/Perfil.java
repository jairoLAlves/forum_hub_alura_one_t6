package br.com.th4mz0.forum_hub.domain.perfil;

import br.com.th4mz0.forum_hub.domain.usuario.Usuario;
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
@Entity(name = "Perfil")
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Perfis nome;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    public Perfil(Perfis perfis){
        this.nome = perfis;
    }

}
