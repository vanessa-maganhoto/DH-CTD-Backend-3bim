DROP TABLE medicamentos;

CREATE TABLE IF NOT EXISTS medicamentos(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(64),
    laboratorio VARCHAR (64),
    quantidade INT,
    preco DOUBLE
);