/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Comida;

import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class ComidaDao implements ComidaDaoIF {

    private Connection con;

    @Override
    public boolean salvar(Comida obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO COMIDA(idEstabelecimento,descricao, nota,preco,nome)"
                + " VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdEstabelecimento());
            stmt.setString(2, obj.getDescricao());
            stmt.setDouble(3, obj.getNota());
            stmt.setDouble(4, obj.getPreco());
            stmt.setString(5, obj.getNome());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    @Override
    public Comida buscar(int idComida) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM comida WHERE idComida= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idComida);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Comida c = new Comida(resultado.getInt("idComida"), resultado.getString("descricao"), resultado.getFloat("nota"), resultado.getFloat("preco"), resultado.getString("nome"), resultado.getInt("idEstabelecimento"));
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
    public boolean atualizar(Comida obj) throws SQLException {
        Comida c = buscar(obj.getIdComida());
        if (c == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE COMIDA SET descricao =?, nome = ?, preco = ? WHERE idComida = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setString(2, obj.getNome());
            stmt.setDouble(3, obj.getPreco());
            stmt.setInt(4, obj.getIdComida());
            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    @Override
    public boolean deletar(int idComida) throws SQLException {
        if (buscar(idComida) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Comida WHERE idComida= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idComida);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

    @Override
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

    @Override
    public List<Comida> ListarRecomendados(int id) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT comida from RecomendarComida WHERE remetente = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Comida> rc = new ArrayList<>();

        while (rs.next()) {
            Comida comida = buscar(rs.getInt("comida"));
            rc.add(comida);

        }
        rs.close();
        stmt.close();
        con.close();

        return rc;
    }
    
    public List<Comida> buscarPorEstabelecimento(int idEstabelecimento) throws SQLException, ClassNotFoundException {
        Statement stmt;
        try {
            con = ConnectionFactory.getConnection();
            
            stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY, 
                    ResultSet.CLOSE_CURSORS_AT_COMMIT
            );
            
            String sql = "SELECT * FROM comida WHERE idEstabelecimento= "+idEstabelecimento;
                        
            ResultSet resultado = stmt.executeQuery(sql);

            List<Comida> comidas = new ArrayList<>();
            while (resultado.next()){
                Comida c = new Comida(resultado.getInt("idcomida"),
                        resultado.getString("descricao"), 
                        resultado.getDouble("nota"), 
                        resultado.getDouble("preco"), 
                        resultado.getString("nome"),
                        resultado.getInt("idEstabelecimento"));
                comidas.add(c);
            }
            resultado.close();
            stmt.close();
            return comidas;
                
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        con.close();
        return null;
    }
}


