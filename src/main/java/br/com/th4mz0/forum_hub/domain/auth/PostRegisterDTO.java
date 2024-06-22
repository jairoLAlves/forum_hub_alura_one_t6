package br.com.th4mz0.forum_hub.domain.auth;

import br.com.th4mz0.forum_hub.domain.perfil.Perfis;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record PostRegisterDTO(
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        String senha,
        @NotEmpty
        List<Perfis> perfis

) {
}
