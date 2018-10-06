package io.github.fernandasj.repository;

import io.github.fernandasj.dao.AmizadeDao;
import io.github.fernandasj.dao.AvaliarComidaDao;
import io.github.fernandasj.dao.AvaliarEstabelecimentoDao;
import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.dao.EstabelecimentoDao;
import io.github.fernandasj.dao.UsuarioDao;
import java.sql.SQLException;

public class DaoFactoryBD implements DaoFactoryIF {
    
    public DaoFactoryBD(){
        
    }

    @Override
    public UsuarioDao criaUsuarioDao() throws SQLException, ClassNotFoundException {
        return new UsuarioDao();
    }

    @Override
    public EstabelecimentoDao criaEstabelecimentoDao() throws SQLException, ClassNotFoundException {
        return new EstabelecimentoDao();
    }

    @Override
    public ComidaDao criaComidaDao() throws SQLException, ClassNotFoundException{
        return new ComidaDao();
    }

    @Override
    public AvaliarComidaDao criaAvaliarComidaDao() throws SQLException, ClassNotFoundException{
        return new AvaliarComidaDao();
    }

    @Override
    public AvaliarEstabelecimentoDao criaAvaliaEstabelecimentoDao() throws SQLException, ClassNotFoundException{
        return new AvaliarEstabelecimentoDao();
    }

    @Override
    public AmizadeDao criaAmizadeDao() throws SQLException, ClassNotFoundException {
        return new AmizadeDao();
    }

}
