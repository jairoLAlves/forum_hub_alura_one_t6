package br.com.th4mz0.forum_hub.domain.perfil;

public enum Perfis {
    ROLE_ADMIN("admin"),
    ROLE_USER("user");
   // ROLE_MODERATOR("MODERATOR"),
   // ROLE_GUEST("GUEST")

    private String perfil;

    Perfis(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return this.perfil;
    }
}
