CREATE TABLE pessoas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    cargo VARCHAR(80),
    salario DECIMAL(10,2),
    data_contratacao DATE,
    PRIMARY KEY (id)
);
