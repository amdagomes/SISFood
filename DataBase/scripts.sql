
CREATE TABLE Usuario (
idUsuario serial,
nome VARCHAR (200) NOT NULL,
email VARCHAR(200) NOT NULL UNIQUE,
senha VARCHAR(15) NOT NULL,
sexo VARCHAR (10),
dataNascimento DATE NOT NULL,
rua varchar(200),
cidade varchar(50),
cep varchar(20),
numeroCasa varchar(5),
estado varchar (10),
telefone varchar(15) ,
profissao varchar(100),
descricao varchar(255),
fotoPerfil varchar(255),
PRIMARY KEY(idUsuario)
);

CREATE TABLE Estabelecimento(
idEstabelecimento serial,
idUsuario int ,
nome varchar(200) NOT NULL,
telefone varchar(20),
fotoEstabelecimento varchar,
categoria varchar (50) NOT NULL,
nota numeric(5,2),
descricao varchar(200),
rua varchar(200) NOT NULL,
estado varchar(10) NOT NULL,
cidade varchar(50) NOT NULL,
cep varchar(10) ,
dia varchar(30),
horaAbre TIME NOT NULL,
horaFecha TIME NOT NULL,
PRIMARY KEY(idEstabelecimento),
FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);
CREATE TABLE Comida(
    idComida serial,
    descricao varchar(300) NOT NULL,
    nota numeric(5,2),
    preco float NOT NULL,
    nome varchar(200) NOT NULL,
    idEstabelecimento int,
    foto varchar(255),
    PRIMARY KEY(idComida),
    FOREIGN KEY(idEstabelecimento) REFERENCES Estabelecimento(idEstabelecimento) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Chekin(
    idChekin serial,
    horario TIMESTAMP,
    dia DATE,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    PRIMARY KEY(idChekin),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE AvaliarEstabelecimento(
    idAvaliacao serial,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    nota numeric(5,2) NOT NULL,
    comentario varchar(500),
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RecomendarEstabelecimento(
    idRecomendacao serial,
    estabelecimento int,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    comentario varchar(300),
    PRIMARY KEY(idRecomendacao),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE AvaliarComida(
    idAvaliacao serial,
    consumidor int NOT NULL,
    comentario VARCHAR(300),
    nota numeric(5,2) NOT NULL,
    comida int,
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(comida) REFERENCES Comida(idComida) ON UPDATE CASCADE ON DELETE CASCADE
);

-- CREATE TABLE ComentarComida(
--     idComentario serial,
--     usuario int,
--     comida int,
--     comentario varchar(255),
--     PRIMARY KEY(idComentario),
--     FOREIGN KEY(usuario) REFERENCES Usuario(idUsuario)
-- );

CREATE TABLE RecomendarComida(
    idRecomendacao serial,
    comida int NOT NULL,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    comentario varchar(300),
    PRIMARY KEY(idRecomendacao),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(comida) REFERENCES Comida(idComida) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Mensagem(
    idMensagem serial,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    mensagem varchar(500) NOT NULL,
    horario TIMESTAMP,
    PRIMARY KEY(idMensagem),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario)
);

CREATE TABLE SolicitaAmizade(
    idSolicitacao serial,
    remetente int NOT NULL,
    destinatario int NOT NULL,
    horario TIMESTAMP,
    situacao varchar(15),
    PRIMARY KEY(idSolicitacao),
    FOREIGN KEY(destinatario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(remetente) REFERENCES Usuario(idUsuario)
);
