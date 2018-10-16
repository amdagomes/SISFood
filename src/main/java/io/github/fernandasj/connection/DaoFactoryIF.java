package io.github.fernandasj.connection;

import io.github.fernandasj.dao.AmizadeDao;
import io.github.fernandasj.dao.AvaliarComidaDao;
import io.github.fernandasj.dao.AvaliarEstabelecimentoDao;
import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.dao.EstabelecimentoDao;
import io.github.fernandasj.dao.RecomendacaoDao;
import io.github.fernandasj.dao.SeguirPaginaDao;
import io.github.fernandasj.dao.UsuarioDao;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public interface DaoFactoryIF {
     
    public UsuarioDao criaUsuarioDao()  throws SQLException, ClassNotFoundException;
     
    public EstabelecimentoDao criaEstabelecimentoDao() throws SQLException, ClassNotFoundException; 
    
    public ComidaDao criaComidaDao() throws SQLException, ClassNotFoundException;
    
    public AvaliarComidaDao criaAvaliarComidaDao() throws SQLException, ClassNotFoundException;
    
    public AvaliarEstabelecimentoDao criaAvaliaEstabelecimentoDao() throws SQLException, ClassNotFoundException;
    
    public AmizadeDao criaAmizadeDao() throws SQLException, ClassNotFoundException;
    
    public SeguirPaginaDao criaSeguirPaginaDao() throws SQLException, ClassNotFoundException;
    
    public RecomendacaoDao criaRecomendacaoDao() throws SQLException, ClassNotFoundException;
    
}
