package io.github.fernandasj.repository;

import io.github.fernandasj.modelo.Consumidor;
import java.sql.SQLException;

public class DaoFactoryBD implements DaoFactoryIF {

    @Override
    public Consumidor criaConsumidorDao() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
