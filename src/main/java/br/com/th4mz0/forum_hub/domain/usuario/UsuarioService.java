package br.com.th4mz0.forum_hub.domain.usuario;


import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import br.com.th4mz0.forum_hub.domain.perfil.Perfil;
import br.com.th4mz0.forum_hub.domain.perfil.PerfilRepository;
import br.com.th4mz0.forum_hub.domain.perfil.Perfis;
import br.com.th4mz0.forum_hub.domain.Validadores;
import br.com.th4mz0.forum_hub.domain.perfil.validacoes.ValidadoresPerfil;
import br.com.th4mz0.forum_hub.domain.usuario.validacoes.ValidadorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    private List<ValidadorUsuario> validadores;
    @Autowired
    private List<ValidadoresPerfil> validadoresPerfil;


    public void save(PostRegisterDTO dados) {

        // Verificar se o usuario ja existe no banco de dados, se existir retornar um Exception

        validadores.forEach(v->v.validar(dados));
        validadoresPerfil.forEach(v->v.validar(dados));

        var nome = dados.nome();
        var email = dados.email();

        // criptografar a senha para BCryptPasswordEncoder
        var senha = new BCryptPasswordEncoder().encode(dados.senha());


        // Verificar as os Perfis passados
        var perfis = new ArrayList<Perfil>();

         for (String pf : dados.perfis()){

            var perfil = Perfis.fromValue(pf);

            var p = perfilRepository.getReferenceByNome(perfil);

            if(p != null){
                perfis.add(p);
            }else{
                // TODO - deve ser retirado so podendo adicionar perfis já existentes no DB
                 p = new Perfil(perfil);
                perfilRepository.save(p);
                perfis.add(p);
            }

        }


        // Criar um novo Usuario com os seus Perfis
        var usuario = new Usuario(nome, email, senha, perfis);

        // Salvar usuario
        usuarioRepository.save(usuario);

    }
}
