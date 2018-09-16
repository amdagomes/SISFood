
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
fotoPerfil bytea NOT NULL,
PRIMARY KEY(idUsuario)  );


CREATE TABLE Estabelecimento(
idEstabelecimento serial,
idUsuario int ,
nome varchar(200) NOT NULL,
telefone varchar(20),
fotoEstabelecimento bytea NOT NULL,
cartegoria varchar (50) NOT NULL,
nota numeric(1,1),
descricao varchar(200),
rua varchar(200) NOT NULL,
estado varchar(10) NOT NULL,
cidade varchar(50) NOT NULL,
cep varchar(10) ,
dia varchar(30) NOT NULL,
horaAbre TIME NOT NULL,
horaFecha TIME NOT NULL,
PRIMARY KEY(idEstabelecimento),
FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)



);




CREATE TABLE Comida(
    idComida serial,
    descricao varchar(300) NOT NULL,
    nota numeric(1,1),
    preco float NOT NULL,
    nome varchar(200) NOT NULL,
    idEstabelecimento int,
    PRIMARY KEY(idComida),
    FOREIGN KEY(idEstabelecimento) REFERENCES Estabelecimento(idEstabelecimento)
    
);


CREATE TABLE Chekin(
    idChekin serial,
    horario TIMESTAMP,
    dia DATE,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    PRIMARY KEY(idChekin),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento)
);

CREATE TABLE AvaliarEstabelecimento(
    idAvaliacao serial,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    nota numeric(1,1) NOT NULL,
    comentario varchar(500),
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento)
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
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento)
);

CREATE TABLE AvaliarComida(
    idAvaliacao serial,
    consumidor int NOT NULL,
    estabelecimento int NOT NULL,
    nota numeric(1,1) NOT NULL,
    comentario varchar(500),
    comida int,
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento),
    FOREIGN KEY(comida) REFERENCES Comida(idComida)
);

CREATE TABLE RecomendarComida(
    idRecomendacao serial,
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


