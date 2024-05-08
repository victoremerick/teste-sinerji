
INSERT INTO pessoa (id ,nome, idade, sexo) VALUES (1, 'João', '1990-05-15 10:00:00', 'MA');
INSERT INTO pessoa (id, nome, idade, sexo) VALUES (2, 'Maria', '1985-08-20 09:30:00', 'FE');
INSERT INTO pessoa (id, nome, idade, sexo) VALUES (3, 'Pedro', '2000-12-01 15:45:00', 'MA');

INSERT INTO endereco (cidade, estado, logradouro, numero, cep, pessoa_id)
VALUES ('São Paulo', 'SP', 'Av. Paulista', 1000, '01310-100', 1);

INSERT INTO endereco (cidade, estado, logradouro, numero, cep, pessoa_id)
VALUES ('Rio de Janeiro', 'RJ', 'Rua da Lapa', 500, '20021-010', 2);

INSERT INTO endereco (cidade, estado, logradouro, numero, cep, pessoa_id)
VALUES ('Belo Horizonte', 'MG', 'Av. Afonso Pena', 1500, '30130-007', 3);

INSERT INTO endereco (cidade, estado, logradouro, numero, cep, pessoa_id)
VALUES ('Brasília', 'DF', 'SQN 305 Bloco A', 200, '70736-010', 1);
