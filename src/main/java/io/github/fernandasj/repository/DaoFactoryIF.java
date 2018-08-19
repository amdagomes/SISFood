/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.repository;

import io.github.fernandasj.modelo.Consumidor;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public interface DaoFactoryIF {
     public Consumidor criaConsumidorDao()  throws SQLException, ClassNotFoundException;
}
