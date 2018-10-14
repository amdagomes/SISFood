package io.github.fernandasj.controle;

import io.github.fernandasj.connection.DaoFactory;
import io.github.fernandasj.connection.DaoFactoryIF;
import io.github.fernandasj.dao.SeguirPaginaDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public class GerenciadorSeguirPagina {
    
    private DaoFactoryIF fabrica = null;
    private SeguirPaginaDao dao = null;

    public GerenciadorSeguirPagina() throws SQLException, ClassNotFoundException {
        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaSeguirPaginaDao();
    }
    
    public boolean follow(int seguidor, int pagina) throws SQLException{
        return dao.followPagina(seguidor, pagina);
    }
    
    public boolean unfollow(int seguidor, int pagina) throws SQLException{
        return dao.unfollowPagina(seguidor, pagina);
    }
    
    public boolean following(int seguidor, int pagina) throws SQLException{
        return dao.followingPagina(seguidor, pagina);
    }
    
    public List listFollowing(int seguidor) throws SQLException{
        return dao.listFollowing(seguidor);
    }
}
