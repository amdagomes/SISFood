/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Comida;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface ComidaDaoIF {

    public boolean salvar(Comida obj) throws SQLException, Exception;

    public Comida buscar(int obj) throws SQLException;

    public boolean atualizar(Comida obj) throws SQLException;

    public boolean deletar(int obj) throws SQLException;

    public void recomendaComida(int remetente, int destinatario, int comida, String comentario) throws SQLException;
     public List<Comida>  ListarRecomendados(int id) throws SQLException;

}
