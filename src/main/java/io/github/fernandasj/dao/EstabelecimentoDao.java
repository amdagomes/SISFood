/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Comida;
import io.github.fernandasj.modelo.Estabelecimento;

import io.github.fernandasj.repository.ConnectionFactory;
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
 * @author Cliente
 */
public class EstabelecimentoDao implements Dao<Estabelecimento> {

    private Connection con;

    @Override
    public boolean salvar(Estabelecimento obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = " INSERT INTO Estabelecimento (idUsuario,nome,telefone,fotoEstabelecimento,cartegoria"
                + ",nota,descricao,rua,estado,cidade,cep,dia,horaAbre,HoraFecha)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdUsuario());
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setBytes(3, obj.getFoto());
            stmt.setString(4, obj.getCartegoria());
            stmt.setFloat(5, obj.getNota());
            stmt.setString(6, obj.getDescricao());
            stmt.setString(7, obj.getRua());
            stmt.setString(8, obj.getEstado());
            stmt.setString(9, obj.getCidade());
            stmt.setString(10, obj.getCep());
            stmt.setTime(11, obj.getHoraAbre());
            stmt.setTime(12, obj.getHoraFecha());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    @Override
    public Estabelecimento buscar(String nome) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * Estabelecimento WHERE nome= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Estabelecimento e = new Estabelecimento(resultado.getString("nome"), resultado.getString("Telefone"),
                    resultado.getBytes("foto"), resultado.getString("cartegoria"), resultado.getFloat("nota"),
                    resultado.getString("descricao"), resultado.getString("rua"), resultado.getString("estado"),
                    resultado.getString("cidade"), resultado.getString("cep"), resultado.getString("dia"),
                    resultado.getTime("horaAbre"), resultado.getTime("horaFecha"));
            resultado.close();
            stmt.close();
            con.close();
            return e;
        }
        resultado.close();
        stmt.close();
        con.close();

        return null;
    }

    @Override
    public boolean atualizar(Estabelecimento obj) throws SQLException {
        Estabelecimento e = buscar(obj.getNome());
        if (e == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE Estabelecimento SET nome =?,telefone=?,fotoEstabelecimento=?,cartegoria=?,nota=?,descricao=?,"
                    + "rua=?,estado=?,cidade=?,cep=?,dia=?,horaAbre=?,horaFecha=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getCartegoria());
            stmt.setFloat(4, obj.getNota());
            stmt.setString(5, obj.getDescricao());
            stmt.setString(6, obj.getRua());
            stmt.setString(7, obj.getEstado());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getCep());
            stmt.setString(10, obj.getDia());
            stmt.setTime(11, obj.getHoraAbre());
            stmt.setTime(12, obj.getHoraFecha());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    @Override
    public boolean deletar(String nome) throws SQLException {

        if (buscar(nome) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Estabelecimento WHERE nome= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }
     public void recomendaEstabelecimento(int remetente, int destinatario, String comentario)
            throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO RecomendarEstabelecimento (remetente,destinatario,comentario) "
                + "values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, remetente);
        stmt.setInt(2, destinatario);
       stmt.setString(3, comentario);
        stmt.execute();

        stmt.close();
        con.close();
    }

   
    public List<Estabelecimento> ListarRecomendados(int id) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT estabelecimento from RecomendarEstabelecimento WHERE remetente = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Estabelecimento> rc = new ArrayList<>();

        while (rs.next()) {
            Estabelecimento e = buscarPorId(rs.getInt("estabelecimento"));
            rc.add(e);

        }
        rs.close();
        stmt.close();
        con.close();

        return rc;
    }


    private Estabelecimento buscarPorId(int id) throws SQLException {
       try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * Estabelecimento WHERE idEstabelecimento= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Estabelecimento e = new Estabelecimento(resultado.getString("nome"), resultado.getString("Telefone"),
                    resultado.getBytes("foto"), resultado.getString("cartegoria"), resultado.getFloat("nota"),
                    resultado.getString("descricao"), resultado.getString("rua"), resultado.getString("estado"),
                    resultado.getString("cidade"), resultado.getString("cep"), resultado.getString("dia"),
                    resultado.getTime("horaAbre"), resultado.getTime("horaFecha"));
            resultado.close();
            stmt.close();
            con.close();
            return e;
        }
        resultado.close();
        stmt.close();
        con.close();

        return null;
    }
    }

