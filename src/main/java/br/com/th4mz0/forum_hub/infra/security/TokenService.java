package br.com.th4mz0.forum_hub.infra.security;

import br.com.th4mz0.forum_hub.domain.usuario.Usuario;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private static final String ISSUER = "Forum hub alura_one_t6";

    @Value("${api.security.token.secret}")
    private String secret;



    public String gerarToken(Usuario user){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getEmail())
                    //.withClaim("nome", user.getNome())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);


            return token;

        }catch (JWTVerificationException e){
            throw new RuntimeException("Erro ao gerar token jwt", e);
        }


    }

    public String getSubject(String tokenJWT){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        }catch (JWTVerificationException e){

            throw new RuntimeException("Token JWT inválido ou expirado: " + tokenJWT);
        }


    }



    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
