package br.com.th4mz0.forum_hub.domain.perfil;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PerfisTest {

    @Test
    void getPerfil() {
        var pf = Perfis.fromValue("admin");

        assertThat(pf.getPerfil()).isEqualTo("ADMIN");

    }
    @Test
    void getNome(){
        var pf = Perfis.fromValue("admin");

        assertThat(pf.name()).isEqualTo("ROLE_ADMIN");
    }

    @Test
    void fromValue() {
    }

    @Test
    void values() {
    }
}