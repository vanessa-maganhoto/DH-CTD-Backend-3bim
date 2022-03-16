--DROP TABLE IF EXISTS filial;
CREATE TABLE IF NOT EXISTS filial (
    id int auto_increment primary key,
    nomeFilial VARCHAR(64),
    logradouro VARCHAR(64),
    numero VARCHAR(8),
    cidade VARCHAR(32),
    estado VARCHAR(32),
    e5Estrelas BOOLEAN
    );






