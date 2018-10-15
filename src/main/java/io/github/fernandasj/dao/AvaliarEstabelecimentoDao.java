/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;


import io.github.fernandasj.modelo.AvaliarEstabelecimento;
import io.github.fernandasj.connection.ConnectionFactory;
import java.io.Serializable;
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
public class AvaliarEstabelecimentoDao{
    private Connection con;

    public boolean salvar(AvaliarEstabelecimento obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO AvaliarEstabelecimento(consumidor,estabelecimento,nota,comentario)"
                + " VALUES(?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, obj.getConsumidor());
            stmt.setInt(2, obj.getEstabelecimento());
            stmt.setFloat(3, obj.getNota());
            stmt.setString(4, obj.getComentario());
            
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public AvaliarEstabelecimento buscar(int IdAvaliacao) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(AvaliarEstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM AvaliarEstabelecimento WHERE idAvaliacao= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, IdAvaliacao);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            AvaliarEstabelecimento Av = new AvaliarEstabelecimento(resultado.getInt("consumidor"), resultado.getInt("estabelecimento"),
                    resultado.getFloat("nota"), resultado.getString("Comentario"));

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

    public boolean atualizar(AvaliarEstabelecimento obj) throws SQLException {

    AvaliarEstabelecimento av = buscar(obj.getIdAvaliacao());
        if (av == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE avaliarEstabelecimento SET Nota=?,Comentario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setFloat(1, obj.getNota());
            stmt.setString(2, obj.getComentario());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    public List<AvaliarEstabelecimento> listAvaliacoes(int idEstabelecimento) throws SQLException{
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String sql = "SELECT * FROM AvaliarEstabelecimento WHERE estabelecimento = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idEstabelecimento);
        ResultSet rs = stmt.executeQuery();

        List<AvaliarEstabelecimento> avaliacoes = new ArrayList<>();

        while(rs.next()){
             AvaliarEstabelecimento avl = new AvaliarEstabelecimento();
             avl.setConsumidor(rs.getInt("consumidor"));
             avl.setNota(rs.getFloat("nota"));
             avl.setComentario(rs.getString("comentario"));
             avaliacoes.add(avl);
        }

        con.close();
        return avaliacoes;
    }
    
    public boolean deletar(int idAvaliacao) throws SQLException {
        if (buscar(idAvaliacao) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(AvaliarEstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "DELETE FROM avaliarEstabelecimento WHERE idAvaliacao= ?";
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
