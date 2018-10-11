CREATE OR REPLACE FUNCTION CalcularNotaMediaComida()
RETURNS TRIGGER AS $$
DECLARE
    media Comida.nota%type;
BEGIN
    SELECT INTO media AVG(A.nota) FROM AvaliarComida A WHERE comida = NEW.comida;
    UPDATE Comida SET nota = media WHERE idComida = NEW.comida;
    RETURN NEW;
END $$ LANGUAGE plpgsql;

CREATE TRIGGER CalcularNotaMediaComida
BEFORE INSERT OR UPDATE ON AvaliarComida
FOR EACH ROW
    EXECUTE PROCEDURE CalcularNotaMediaComida();


CREATE OR REPLACE FUNCTION CalcularNotaMediaEstabelecimento()
RETURNS TRIGGER AS $$
DECLARE
    media Estabelecimento.nota%type;
BEGIN
    SELECT INTO media AVG(A.nota) FROM AvaliarEstabelecimento A WHERE estabelecimento = NEW.estabelecimento;
    UPDATE Estabelecimento SET nota = media WHERE idEstabelecimento = NEW.estabelecimento;
    RETURN NEW;
END $$ LANGUAGE plpgsql;

CREATE TRIGGER CalcularNotaMediaEstabelecimento
BEFORE INSERT OR UPDATE ON AvaliarEstabelecimento
FOR EACH ROW
    EXECUTE PROCEDURE CalcularNotaMediaEstabelecimento();
