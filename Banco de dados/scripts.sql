CREATE TABLE Consumidor(
    id serial,
    nome varchar(200),
    fotoPerfil varchar(200),
    telefone varchar(15),
    sexo varchar(15),
    profissao varchar(100),
    dataNascimento DATE,
    descricao varchar(300),
    rua varchar(200),
    estado varchar(200),
    cidade varchar(200),
    cep varchar(15),
    senha varchar(200) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Estabelecimento(
    id serial,
    nome varchar(200),
    fotoPerfil varchar(200),
    telefone varchar(15),
    categoria varchar(100),
    nota float(1,1),
    descricao varchar(300),
    rua varchar(200),
    estado varchar(200),
    cidade varchar(200),
    cep varchar(15),
    senha varchar(200) NOT NULL,
    PRIMARY KEY(id),
);

CREATE TABLE Comida(
    id serial,
    descricao varchar(300),
    nota float(1,1),
    preco float,
    nome varchar(200),
    idEstabelecimento int,
    PRIMARY KEY(id),
    FOREIGN KEY(idEstabelecimento) REFERENCES Estabelecimento(id)
);

CREATE TABLE horaFuncionamento(
    idComida serial,
    idEstabelecimento int,
    dia varchar(30);
    horaAbre DATE,
    horaFecha DATE,
    PRIMARY KEY(id),
    FOREIGN KEY(idEstabelecimento) REFERENCES Estabelecimento(id),
    FOREIGN KEY(idComida) REFERENCES Comida(id)
);

CREATE TABLE Chekin(
    id serial,
    horario TIMESTAMP,
    consumidor int,
    estabelecimento int,
    PRIMARY KEY(idChekin),
    FOREIGN KEY(consumidor) REFERENCES Consumidor(id),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(id)
);

CREATE TABLE AvaliarEstabelecimento(
    id serial,
    consumidor int,
    estabelecimento int,
    nota float(1,1),
    comentario varchar(500),
    PRIMARY KEY(id),
    FOREIGN KEY(consumidor) REFERENCES Consumidor(id),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(id)
);

CREATE TABLE AvaliarComida(
    id int,
    consumidor serial,
    estabelecimento int,
    nota float(1,1),
    comentario varchar(500),
    comida int,
    PRIMARY KEY(id),
    FOREIGN KEY(consumidor) REFERENCES Consumidor(id),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(id),
    FOREIGN KEY(comida) REFERENCES Comida(id)
);

CREATE TABLE RecomendarComida(
    id serial,
    comida int,
    remetente int,
    destinatario int,
    comentario varchar(300),
    PRIMARY KEY(id),
    FOREIGN KEY(destinatario) REFERENCES Consumidor(id),
    FOREIGN KEY(remetente) REFERENCES Estabelecimento(id),
    FOREIGN KEY(comida) REFERENCES Comida(id)
);

CREATE TABLE Mensagem(
    id serial
    remetente int,
    destinatario int,
    mensagem varchar(500),
    horario TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(destinatario) REFERENCES Consumidor(id),
    FOREIGN KEY(remetente) REFERENCES Estabelecimento(id
);

CREATE TABLE SolicitaAmizade(
    id serial
    remetente int,
    destinatario int,
    horario TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(destinatario) REFERENCES Consumidor(id),
    FOREIGN KEY(remetente) REFERENCES Estabelecimento(id)
);


