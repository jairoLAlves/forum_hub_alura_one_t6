package br.com.th4mz0.forum_hub.domain.perfil;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Perfis {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_MODERATOR("MODERATOR"),
    ROLE_GUEST("GUEST");

    private String perfil;

    Perfis(String perfil){
        this.perfil = perfil;
    }

    @JsonValue
    public String getPerfil(){
        return this.perfil;
    }

    @JsonCreator
    public static Perfis fromValue(String value) {
        for (Perfis perfil : Perfis.values()) {
            if (perfil.perfil.equalsIgnoreCase(value)) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Não existe um Perfil do tipo: " + value);
    }
}
