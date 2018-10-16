/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Recomendacao;
import io.github.fernandasj.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class RecomendacaoDao {

    private Connection con;

    public void recomendaComida(int remetente, int destinatario, int comida, String comentario)
            throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO RecomendarComida (remetente,destinatario,comida,comentario) "
                + "values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, remetente);
        stmt.setInt(2, destinatario);
        stmt.setInt(3, comida);
        stmt.setString(4, comentario);
        stmt.execute();

        stmt.close();
        con.close();
    }
    
    public void recomendaEstabelecimento(int estabelecimento, int remetente, int destinatario, String comentario)
            throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO RecomendarEstabelecimento (estabelecimento, remetente,destinatario,comentario) "
                + "values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, estabelecimento);
        stmt.setInt(2, remetente);
        stmt.setInt(3, destinatario);
        stmt.setString(4, comentario);
        stmt.execute();

        stmt.close();
        con.close();
    }

    public List<Recomendacao> ListarRecomendacaoComida(int id) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * from RecomendarComida WHERE destinatario = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Recomendacao> rc = new ArrayList<>();

        while (rs.next()) {
            Recomendacao recomendacao = new Recomendacao(rs.getInt("idRecomendacao"), rs.getInt("comida"), rs.getInt("remetente"), 
                    rs.getInt("destinatario"), rs.getString("comentario"));
            rc.add(recomendacao);
        }

        rs.close();
        stmt.close();
        con.close();

        return rc;
    }
    
    public List<Recomendacao> ListarRecomendacoesEstabelecimento(int id) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT estabelecimento from RecomendarEstabelecimento WHERE destinatario = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Recomendacao> rc = new ArrayList<>();

        while (rs.next()) {
            Recomendacao recomendacao = new Recomendacao(rs.getInt("idRecomendacao"), rs.getInt("estabelecimento"), 
                    rs.getInt("remetente"), rs.getInt("destinatario"), rs.getString("comentario"));
            rc.add(recomendacao);
        }
        rs.close();
        stmt.close();
        con.close();

        return rc;
    }
}
