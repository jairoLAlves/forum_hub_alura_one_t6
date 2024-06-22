
CREATE TABLE perfil (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


ALTER TABLE usuarios
ADD COLUMN perfis BIGINT;

ALTER TABLE usuarios
ADD CONSTRAINT fk_perfil
FOREIGN KEY (perfis) REFERENCES perfil(id);


CREATE TABLE usuario_perfil (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);


CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensagem VARCHAR(255) NOT NULL UNIQUE,
    dataCriacao DATETIME NOT NULL,
    autor BIGINT,
    curso BIGINT,
    FOREIGN KEY (autor) REFERENCES usuarios(id),
    FOREIGN KEY (curso) REFERENCES cursos(id),
    primary key(id)
);

CREATE TABLE respostas (
	id BIGINT NOT NULL AUTO_INCREMENT,
    topico BIGINT,
    dataCriacao DATETIME NOT NULL,
    autor BIGINT,
    resposta TEXT,
    solucao TINYINT,
    FOREIGN KEY (topico) REFERENCES topicos(id),
    FOREIGN KEY (autor) REFERENCES usuarios(id),
    primary key(id)
);



