CREATE TABLE pessoa(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo TINYINT(1) NOT NULL,
	logradouro VARCHAR(255),
	numero VARCHAR(10),
	complemento VARCHAR(255),
	bairro VARCHAR(50),
	cep VARCHAR(20),
	cidade VARCHAR(255),
	estado VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Albino', 1, 'Rua 20', '1035', 'Apt. 304', 'St. Central', '74.020-170', 'Goiânia', 'Goiás');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Bruna', 1, 'Rua 20', '1035', 'Apt. 304', 'St. Central', '74.020-170', 'Goiânia', 'Goiás');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Arthur', 1, 'Rua 20', '1035', 'Apt. 304', 'St. Central', '74.020-170', 'Goiânia', 'Goiás');