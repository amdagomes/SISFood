/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Comentario;
import io.github.fernandasj.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class ComentarioDao {

    private Connection con;

    public boolean salvar(Comentario obj) throws SQLException, Exception {

        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO COMENTARIO(comentario,comentarista,datahora,idPublicacao)"
                + " VALUES(?,? ,CURRENT_TIMESTAMP,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, obj.getComentario());
            stmt.setInt(2, obj.getComentarista());

            stmt.setInt(3, obj.getIdPublicacao());

            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public Comentario buscar(int idComentario) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM comentario WHERE idComentario= ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idComentario);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Timestamp datahora = resultado.getTimestamp("datahora");

            String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(datahora.getTime());
            Comentario c = new Comentario(resultado.getInt("idComentario"), resultado.getInt("idPublicacao"), resultado.getInt("comentarista"),
                    resultado.getString("comentario"), dataHora);
            resultado.close();
            stmt.close();
            con.close();
            return c;
        }
        resultado.close();
        stmt.close();
        con.close();

        return null;
    }

    public List<Comentario> listar(int idPublicacao) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT idComentario from Comentario WHERE idPublicacao = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idPublicacao);
        ResultSet resultado = stmt.executeQuery();

        List<Comentario> c = new ArrayList<>();

        while (resultado.next()) {
            Comentario coments = buscar(resultado.getInt("idComentario"));
            c.add(coments);

        }
        resultado.close();
        stmt.close();
        con.close();

        return c;
    }

}
