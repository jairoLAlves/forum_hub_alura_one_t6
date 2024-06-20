package br.com.th4mz0.forum_hub.controller;


import br.com.th4mz0.forum_hub.domain.curso.usuario.DadosAutenticacao;
import br.com.th4mz0.forum_hub.domain.curso.usuario.Usuario;
import br.com.th4mz0.forum_hub.infra.security.DadosTokenJWT;
import br.com.th4mz0.forum_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
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
}
