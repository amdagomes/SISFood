/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Estabelecimento;
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

        String sql = "SELECT * Estabelecimento WHERE nome = %?%";
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
        if (obj == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE Estabelecimento SET nome = ?, telefone = ?, fotoEstabelecimento = ?, categoria = ?,"
                    + "descricao = ?, rua = ?, estado = ?, cidade = ?, cep = ?, horaAbre = ?, horaFecha = ? "
                    + "WHERE idestabelecimento = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getFoto());
            stmt.setString(4, obj.getCategoria());
            stmt.setString(5, obj.getDescricao());
            stmt.setString(6, obj.getRua());
            stmt.setString(7, obj.getEstado());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getCep());
            stmt.setTime(10, obj.getHoraAbre());
            stmt.setTime(11, obj.getHoraFecha());
            stmt.setInt(12, obj.getId());
            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    @Override
    public boolean deletar(int id) throws SQLException {

        if (buscarPorId(id) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Estabelecimento WHERE idestabelecimento = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }
    
     public void recomendaEstabelecimento(int estabelecimento, int remetente, int destinatario, String comentario)
            throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO RecomendarEstabelecimento (estabelecimento, remetente,destinatario,comentario) "
                + "values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, estabelecimento);
        stmt.setInt(2, remetente);
        stmt.setInt(3, destinatario);
        stmt.setString(4, comentario);
        stmt.execute();

        stmt.close();
        con.close();
    }

     public List listarPorNome(String nome) throws SQLException{
         
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        String sql = "SELECT * FROM estabelecimento WHERE nome ilike ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%"+nome+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        Estabelecimento e = new Estabelecimento();
        List estbls = new ArrayList();
        
        while(rs.next()){
            e.setId(rs.getInt("idestabelecimento"));
            e.setIdUsuario(rs.getInt("idusuario"));
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
            e.setFoto(rs.getString("fotoEstabelecimento"));
            
            estbls.add(e);
        }
         return estbls;
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

