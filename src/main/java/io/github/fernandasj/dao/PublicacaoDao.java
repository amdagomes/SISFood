/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;


import io.github.fernandasj.modelo.Publicacao;
import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class PublicacaoDao {

    private Connection con;

    public boolean salvar(Publicacao obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO publicacao(texto,foto,dataHora,idUsuario)"
                + " VALUES(?,?, CURRENT_TIMESTAMP,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, obj.getTexto());
            stmt.setString(2, obj.getFoto());
            stmt.setInt(3, obj.getIdUsuario());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public Publicacao buscar(int idPublicacao) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM publicacao WHERE idPublicacao= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idPublicacao);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Timestamp datahora= resultado.getTimestamp("datahora");
            
            String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(datahora.getTime());
                    Publicacao p = new Publicacao(resultado.getInt("idPublicacao"), resultado.getInt("idUsuario"),
                    resultado.getString("texto"), resultado.getString("foto"), dataHora);
            resultado.close();
            stmt.close();
            con.close();
            return p;
        }
        resultado.close();
        stmt.close();
        con.close();

        return null;
    }

    public List<Publicacao> listar(int idUsuario) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT idPublicacao from publicacao WHERE idUsuario = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet resultado = stmt.executeQuery();

        List<Publicacao> p = new ArrayList<>();

        while (resultado.next()) {
            Publicacao publicacao = buscar(resultado.getInt("idPublicacao"));
            p.add(publicacao);

        }
        resultado.close();
        stmt.close();
        con.close();
        Collections.sort(p);
    return p;
    }

  

    public boolean deletar(int idPublicacao) throws SQLException {
        if (buscar(idPublicacao) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM publicacao WHERE idPublicacao= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPublicacao);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

}
