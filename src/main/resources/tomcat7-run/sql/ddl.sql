DROP ALL OBJECTS;

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade TIMESTAMP,
    sexo VARCHAR(10)
);

CREATE TABLE endereco (
      id SERIAL PRIMARY KEY,
      cidade VARCHAR(255) NOT NULL,
      estado VARCHAR(255) NOT NULL,
      logradouro VARCHAR(255) NOT NULL,
      numero INTEGER NOT NULL,
      cep VARCHAR(20) NOT NULL,
      pessoa_id BIGINT,
      FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
