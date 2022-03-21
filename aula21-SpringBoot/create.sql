--DROP TABLE IF EXISTS filial;
CREATE TABLE IF NOT EXISTS dentista (
    id int auto_increment primary key,
    nome VARCHAR(64),
    sobrenome VARCHAR(64),
    matricula int(10)
    );

CREATE TABLE IF NOT EXISTS endereco (
    id int auto_increment primary key,
    rua VARCHAR(64),
    numero VARCHAR(10),
    cidade VARCHAR(64),
    bairro VARCHAR(64)
    );
