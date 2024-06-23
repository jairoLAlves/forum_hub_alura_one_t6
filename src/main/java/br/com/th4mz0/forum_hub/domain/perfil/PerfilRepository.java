package br.com.th4mz0.forum_hub.domain.perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil getReferenceByNome(Perfis nome);

}
