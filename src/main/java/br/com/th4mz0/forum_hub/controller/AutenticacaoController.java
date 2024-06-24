package br.com.th4mz0.forum_hub.controller;


import br.com.th4mz0.forum_hub.domain.auth.PostRegisterDTO;
import br.com.th4mz0.forum_hub.domain.usuario.DadosAutenticacao;
import br.com.th4mz0.forum_hub.domain.usuario.Usuario;
import br.com.th4mz0.forum_hub.domain.usuario.UsuarioRepository;
import br.com.th4mz0.forum_hub.domain.usuario.UsuarioService;
import br.com.th4mz0.forum_hub.infra.security.DadosTokenJWT;
import br.com.th4mz0.forum_hub.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired

    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados){
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

            var authentication = manager.authenticate(authenticationToken);

            var user = (Usuario) authentication.getPrincipal();
            var tokenJWT = tokenService.gerarToken(user);

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PostRegisterDTO postRegisterDTO ){
        usuarioService.save(postRegisterDTO);
        return  ResponseEntity.ok().build();
    }


}
