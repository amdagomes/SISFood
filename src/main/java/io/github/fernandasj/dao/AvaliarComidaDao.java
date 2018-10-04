/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.AvaliarComida;
import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class AvaliarComidaDao {

    private Connection con;

    public boolean salvar(AvaliarComida obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO AvaliarComida(consumidor,estabelecimento,nota,comentario,comida)"
                + " VALUES(?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, obj.getConsumidor());
            stmt.setInt(2, obj.getEstabelecimento());
            stmt.setFloat(3, obj.getNota());
            stmt.setString(4, obj.getComentario());
            stmt.setInt(5, obj.getComida());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public AvaliarComida buscar(int IdAvaliacao) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM AvaliarComida WHERE idAvaliacao= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, IdAvaliacao);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            AvaliarComida Av = new AvaliarComida(resultado.getInt("consumidor"), resultado.getInt("estabelecimento"),
                    resultado.getFloat("nota"), resultado.getString("Comentario"), resultado.getInt("Comida"));

            resultado.close();
            stmt.close();
            con.close();
            return Av;
        }
        resultado.close();
        stmt.close();
        con.close();

        return null;
    }

    public boolean atualizar(AvaliarComida obj) throws SQLException {

        AvaliarComida av = buscar(obj.getIdAvaliacao());
        if (av == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE AvaliarComida SET Nota=?,Comentario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setFloat(1, obj.getNota());
            stmt.setString(2, obj.getComentario());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    public boolean deletar(int idAvaliacao) throws SQLException {
        if (buscar(idAvaliacao) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "DELETE FROM AvaliarComida WHERE idAvaliacao= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idAvaliacao);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

}
