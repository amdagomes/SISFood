/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Estabelecimento;
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
public class EstabelecimentoDao implements Dao<Estabelecimento> {

    private Connection con;

    @Override
    public boolean salvar(Estabelecimento obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = " INSERT INTO Estabelecimento (idUsuario, nome, telefone, categoria, "
                + "descricao, rua, estado, cidade, cep, horaAbre, HoraFecha, fotoEstabelecimento)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdUsuario());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCategoria());
            stmt.setString(5, obj.getDescricao());
            stmt.setString(6, obj.getRua());
            stmt.setString(7, obj.getEstado());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getCep());
            stmt.setTime(10, obj.getHoraAbre());
            stmt.setTime(11, obj.getHoraFecha());
            stmt.setString(12, obj.getFoto());
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

        String sql = "SELECT * Estabelecimento WHERE nome = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Estabelecimento e = new Estabelecimento(resultado.getString("nome"), resultado.getString("Telefone"),
                    resultado.getString("fotoEstabelecimeto"), resultado.getString("cartegoria"), resultado.getFloat("nota"),
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
            String sql = "UPDATE Estabelecimento SET nome = ?, telefone = ?, fotoEstabelecimento = ?, categoria = ?,"
                    + "nota = ?, descricao = ?, rua = ?, estado = ?, cidade = ?, cep = ?, dia = ?, horaAbre = ?, horaFecha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getCategoria());
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
    
    public List<Estabelecimento> listMeusEstabelecimentos(int id) throws SQLException{
        Statement stmt;
        try {
            con = ConnectionFactory.getConnection();
             con = ConnectionFactory.getConnection();
            
            stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY, 
                    ResultSet.CLOSE_CURSORS_AT_COMMIT
            );
            
            String sql = "SELECT * FROM estabelecimento WHERE idUsuario = " + id;
        
            ResultSet r = stmt.executeQuery(sql);
            
            List<Estabelecimento> meusEstabelecimentos = new ArrayList<>();
        
            while(r.next()){
                Estabelecimento e = new Estabelecimento(r.getInt("idestabelecimento"), r.getInt("idusuario"), 
                        r.getString("nome"), r.getString("telefone"), r.getString("fotoestabelecimento"), r.getString("categoria"),
                        r.getFloat("nota"), r.getString("descricao"), r.getString("rua"), r.getString("estado"), r.getString("cidade"),
                        r.getString("cep"), null, r.getTime("horaabre"), r.getTime("horafecha"));
                meusEstabelecimentos.add(e);
            }
            r.close();
            return meusEstabelecimentos;
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Estabelecimento buscarPorId(int id) throws SQLException {
       try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM estabelecimento WHERE idEstabelecimento = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        if (r.next()) {
            Estabelecimento e = new Estabelecimento(r.getInt("idestabelecimento"), r.getInt("idusuario"), 
                        r.getString("nome"), r.getString("telefone"), r.getString("fotoestabelecimento"), r.getString("categoria"),
                        r.getFloat("nota"), r.getString("descricao"), r.getString("rua"), r.getString("estado"), r.getString("cidade"),
                        r.getString("cep"), null, r.getTime("horaabre"), r.getTime("horafecha"));
            r.close();
            stmt.close();
            con.close();
            return e;
        }
        r.close();
        stmt.close();
        con.close();

        return null;
    }
}

