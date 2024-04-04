-- Creación de la tabla Pais
CREATE TABLE pais (
    id VARCHAR(2) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- Creación de la tabla Persona
CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    pais_id VARCHAR(2),
    PRIMARY KEY (id),
    CONSTRAINT fk_persona_pais FOREIGN KEY (pais_id) REFERENCES pais (id)
);
