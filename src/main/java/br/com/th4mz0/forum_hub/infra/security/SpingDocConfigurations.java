package br.com.th4mz0.forum_hub.infra.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpingDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Fórum Hub API")
                        .description("""
                                Fórum Hub  é um espaço onde todos os participantes de uma plataforma podem colocar
                                suas perguntas sobre determinados assuntos.
                                """)
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("jairoauves@gmail.com"))

                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://th4mz0.com/forumhub/api/licenca")));
    }
}
