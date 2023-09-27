CREATE TABLE tb_chamado (
    id BIGSERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    assunto VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    atendente VARCHAR(255) NOT NULL,
    dataHora VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id)
);