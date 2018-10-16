/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Chekin;

import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class ChekinDao implements ChekinDaoIF {

    private Connection con;

    @Override
    public boolean salvar(Chekin obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = " INSERT INTO chekin (consumidor,estabelecimento,datahora)"
                + "VALUES(?,?,CURRENT_TIMESTAMP)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getConsumidor());
            stmt.setInt(2, obj.getEstabelecimento());
              stmt.execute();
            stmt.close();

        }
        con.close();
        return true;
    }

   
    

    @Override
    public Chekin buscar(int idChekin) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChekinDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * from Chekin c where c.idChekin =  ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idChekin);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
             Timestamp datahora = resultado.getTimestamp("datahora");

            String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(datahora.getTime());
            Chekin c = new Chekin(resultado.getInt(idChekin),dataHora,resultado.getInt("consumidor"),resultado.getInt("estabelecimento"));
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

    @Override
    public boolean deletar(int idChekin) throws SQLException {

        if (buscar(idChekin) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(ChekinDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "DELETE FROM Chekin WHERE idChekin= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idChekin);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

   @Override 
    public List<Chekin> listar(int estabelecimento) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChekinDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT idChekin from estabelecimento =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1,estabelecimento );
        List<Chekin> c = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        Chekin chekin = buscar(rs.getInt("estabelecimento"));
        c.add(chekin);
       
            

        }
          rs.close();
        stmt.close();
        con.close();
        Collections.sort(c);
        return null;
    }

    

    
    
   
}
