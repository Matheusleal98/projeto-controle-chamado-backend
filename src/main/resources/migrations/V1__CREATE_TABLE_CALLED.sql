CREATE TABLE tb_chamado (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nomeCliente VARCHAR(255) NOT NULL,
                            assunto VARCHAR(255) NOT NULL,
                            status VARCHAR(255) NOT NULL,
                            atendente VARCHAR(255) NOT NULL,
                            dataHora VARCHAR(255) NOT NULL
);