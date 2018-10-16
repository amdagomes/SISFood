package io.github.fernandasj.controle;

import io.github.fernandasj.connection.DaoFactory;
import io.github.fernandasj.connection.DaoFactoryIF;
import io.github.fernandasj.modelo.Recomendacao;
import io.github.fernandasj.dao.RecomendacaoDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public class GerenciadorRecomendacao {

    private DaoFactoryIF fabrica = null;
    private RecomendacaoDao dao = null;

    public GerenciadorRecomendacao() throws SQLException, ClassNotFoundException {
        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaRecomendacaoDao();
    }
    
    public void recomendaComida(int remetente, int destinatario, int comida, String comentario) throws SQLException{
        dao.recomendaComida(remetente, destinatario, comida, comentario);
    }
    
    public void recomendaEstabelecimento(int estabelecimento, int remetente, int destinatario, String comentario) throws SQLException{
        dao.recomendaEstabelecimento(estabelecimento, remetente, destinatario, comentario);
    }
    
    public List<Recomendacao> listRecomendacaoComida(int destinatario) throws SQLException{
        return dao.ListarRecomendacaoComida(destinatario);
    }
    
    public List<Recomendacao> listRecomendacaoEstabelecimento(int destinatario) throws SQLException{
        return dao.ListarRecomendacoesEstabelecimento(destinatario);
    }
    
}
