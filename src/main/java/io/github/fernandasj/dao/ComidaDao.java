/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Comida;

import io.github.fernandasj.connection.ConnectionFactory;
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
        String sql = "INSERT INTO COMIDA(idEstabelecimento,descricao, preco, nome, foto)"
                + " VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdEstabelecimento());
            stmt.setString(2, obj.getDescricao());
            stmt.setDouble(3, obj.getPreco());
            stmt.setString(4, obj.getNome());
            stmt.setString(5, obj.getFoto());
            
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

        String sql = "SELECT * FROM comida WHERE idComida = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idComida);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Comida c = new Comida(resultado.getInt("idComida"), resultado.getString("descricao"), 
                    resultado.getFloat("nota"), resultado.getFloat("preco"), resultado.getString("nome"), 
                    resultado.getInt("idEstabelecimento"), resultado.getString("foto"));

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

            String sql = "UPDATE comida SET descricao = ?, nome = ?, preco = ?, foto = ? WHERE idcomida = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setString(2, obj.getNome());
            stmt.setDouble(3, obj.getPreco());
            stmt.setString(4, obj.getFoto());
            stmt.setInt(5, obj.getIdComida());
            System.out.println("Foto da atualização: " + obj.getFoto());
            
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
                        resultado.getInt("idEstabelecimento"),
                        resultado.getString("foto"));
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
