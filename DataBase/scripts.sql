
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
dia varchar(30) NOT NULL,
horaAbre TIME NOT NULL,
horaFecha TIME NOT NULL,
PRIMARY KEY(idEstabelecimento),
FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)



);
-- inserir estabelecimento para testar cardapio
insert into estabelecimento (idUsuario, nome, telefone, fotoEstabelecimento,
    categoria, nota, descricao, rua,estado, cidade, cep, dia, horaAbre, horaFecha) values (1,
    'Subway', '35352101', 'foto', 'lanchonete', 4.5, 'descricao', 'rua','pb', 'cz', 58900000,
    'segunda', SYSDATETIME(), SYSDATETIME())



CREATE TABLE Comida(
    idComida serial,
    descricao varchar(300) NOT NULL,
    nota numeric(5,2),
    preco float NOT NULL,
    nome varchar(200) NOT NULL,
    idEstabelecimento int,
    foto varchar(255),	
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
    nota numeric(5,2) NOT NULL,
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
    nota numeric(5,2) NOT NULL,
    comentario int,
    comida int,
    PRIMARY KEY(idAvaliacao),
    FOREIGN KEY(consumidor) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(estabelecimento) REFERENCES Estabelecimento(idEstabelecimento),
    FOREIGN KEY(comentario) REFERENCES ComentarComida(idComentario),
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


CREATE TABLE ComentarComida(
    idComentario serial,
    usuario int,
    comida int,
    comentario varchar(255),
    PRIMARY KEY(idComentario),
    FOREIGN KEY(usuario) REFERENCES Usuario(idUsuario)
);
    
    
                                                                                           

