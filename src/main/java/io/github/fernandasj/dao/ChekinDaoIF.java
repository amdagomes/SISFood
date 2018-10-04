/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Chekin;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface ChekinDaoIF <T> {
     boolean salvar(Chekin obj) throws SQLException, Exception;
     Chekin buscar(int obj) throws SQLException;
    boolean atualizar(Chekin obj) throws SQLException;
    boolean deletar( int obj) throws SQLException;
    List<T> listar(LocalDate obj) throws SQLException;
}

