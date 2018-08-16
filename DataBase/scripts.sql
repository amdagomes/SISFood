CREATE TABLE usuario(
    idUsuario int,
    tipoUsuario varchar(20) NOT NULL,
    nome varchar(200) NOT NULL,
    fotoPerfil varchar(200) NOT NULL,
    telefone varchar(15),
    sexo varchar(15),
    email varchar(200) NOT NULL,
    profissao varchar(100),
    dataNascimento DATE,
    categoriaEstabelecimento varchar(100),
    nota numeric(1,1),
    descricao varchar(300),
    rua varchar(200) NOT NULL,
    estado varchar(200) NOT NULL,
    cidade varchar(200) NOT NULL,
    cep varchar(15) NOT NULL,
    username varchar(200) NOT NULL UNIQUE,
    senha varchar(200) NOT NULL,
    PRIMARY KEY(idUsuario)
);

CREATE TABLE horaFuncionamento(
    idFuncionamento int,
    idUsuario int NOT NULL,
    dia varchar(30) NOT NULL,
    horaAbre DATE NOT NULL,
    horaFecha DATE NOT NULL,
    PRIMARY KEY(idFuncionamento),
    FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Comida(
    idComida int,
    descricao varchar(300) NOT NULL,
    nota numeric(1,1),
    preco float NOT NULL,
    nome varchar(200) NOT NULL,
    idUsuario int,
    horaFuncionamento int,
    PRIMARY KEY(idComida),
    FOREIGN KEY(horaFuncionamento) REFERENCES horaFuncionamento(idFuncionamento),
    FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);


CREATE TABLE Chekin(
    idChekin int,
    horario TIMESTAMP,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    PRIMARY KEY(idChekin),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Usuario(idUsuario)
);

CREATE TABLE AvaliarEstabelecimento(
    idAvaliacao int,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    nota numeric(1,1) NOT NULL,
    comentario varchar(500),
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Usuario(idUsuario)
);

CREATE TABLE AvaliarComida(
    idAvaliacao int,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    nota numeric(1,1) NOT NULL,
    comentario varchar(500),
    comida int,
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(comida) REFERENCES Comida(idComida)
);

CREATE TABLE RecomendarComida(
    idRecomendacao int,
    comida int NOT NULL,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    comentario varchar(300),
    PRIMARY KEY(idRecomendacao),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(comida) REFERENCES Comida(idComida)
);

CREATE TABLE Mensagem(
    idMensagem int,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    mensagem varchar(500) NOT NULL,
    horario TIMESTAMP,
    PRIMARY KEY(idMensagem),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario)
);

CREATE TABLE SolicitaAmizade(
    idSolicitacao int,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    horario TIMESTAMP,
    PRIMARY KEY(idSolicitacao),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario)
);
