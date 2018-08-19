package io.github.fernandasj.controle;

import io.github.fernandasj.dao.ConsumidorDao;
import io.github.fernandasj.modelo.Consumidor;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class GerenciadorConsumidor {
    private DaoFactoryIF fabrica = null;
    private ConsumidorDao userDao = null;
    
    public boolean autenticar(String email, String senha) throws SQLException {
        return userDao.autenticar(email, senha);
    }
    
    public Consumidor buscaConsumidor(String email) throws SQLException {
        return userDao.buscar(email);
    }
}
