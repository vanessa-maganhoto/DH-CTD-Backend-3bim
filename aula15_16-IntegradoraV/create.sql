DROP TABLE IF EXISTS enderecos;
CREATE TABLE IF NOT EXISTS enderecos (
    id int auto_increment primary key,
    rua VARCHAR(64),
    numero VARCHAR(8),
    cidade VARCHAR(32),
    bairro VARCHAR(32)
    );