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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
        String sql = " INSERT INTO chekin (Consumidor,establecimento,horario,dia)"
                + "VALUES(?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getConsumidor());
            stmt.setInt(2, obj.getEstabelecimento());
            stmt.setTimestamp(3, obj.getHorario());
            stmt.setDate(4, Date.valueOf(obj.getDia()));

        }
        con.close();
        return true;
    }

    @Override
    public boolean atualizar(Chekin obj) throws SQLException {

        Chekin chekin = buscar(obj.getChekin());
        if (chekin == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(ChekinDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE CHEKIN SET dia =?,horario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(obj.getDia()));
            stmt.setTimestamp(15, obj.getHorario());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }

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
            Chekin c = new Chekin(resultado.getTimestamp("horario"), resultado.getDate("dia").toLocalDate());
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
    public List<Chekin> listar(LocalDate data) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChekinDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT nome,horario, from Usuario u ,Chekin c where c.consumidor=u.idUsuario and c.dia = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setDate(1, Date.valueOf(data));
        List<Chekin> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Usuario u = new Usuario();
            Chekin c = new Chekin();
            u.setNome(rs.getString("nome"));
            c.setHorario(rs.getTimestamp("horario"));
            lista.addAll((Collection<? extends Chekin>) u);
            lista.add(c);

        }
        rs.close();
        stmt.close();
        return lista;
    }

}
