Professor, tudo bem?

É necessário adicionar o usuário e a senha nos arquivos GerarRelatorioCliente.java e GerarRelatorioProduto.java. Consegui gerar os relatórios, mas me esqueci de que o senhor havia criado outro banco de dados. O sistema consegue rodar sobre esse banco de dados. Espero que seja aceito, por favor.

Atenciosamente,
Ariel Luiz Biondo

CREATE TABLE usuario (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    senha VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    telefone CHAR(11),
    genero CHAR(10),
    PRIMARY KEY (id)
);

CREATE TABLE produto (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    valor DOUBLE,
    quantidade INT(11),
    fabricante VARCHAR(255),
    descricao VARCHAR(255),
    PRIMARY KEY (id)
);