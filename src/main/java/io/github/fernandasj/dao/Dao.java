package io.github.fernandasj.dao;

import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public interface Dao<T> {   
    boolean salvar(T obj) throws SQLException, Exception;
    T buscar(Object obj) throws SQLException;
    boolean atualizar(T obj) throws SQLException;
    boolean deletar(Object obj) throws SQLException;
}