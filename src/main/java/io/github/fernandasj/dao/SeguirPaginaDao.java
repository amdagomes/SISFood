package io.github.fernandasj.dao;

import io.github.fernandasj.connection.ConnectionFactory;
import io.github.fernandasj.modelo.SeguirPagina;
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
 * @author Amanda
 */
public class SeguirPaginaDao {

    private Connection con;

    public boolean followPagina(int usuario, int pagina) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO seguirPaginas(seguidor, pagina, situacao) VALUES(?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, usuario);
            stmt.setInt(2, pagina);
            stmt.setString(3, "seguindo");
            
            stmt.execute();
            stmt.close();          
        }
        
        con.close();
        return true;
    }

    public boolean unfollowPagina(int usuario, int pagina) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "DELETE FROM seguirPaginas WHERE seguidor = ? AND pagina = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, usuario);
            stmt.setInt(2, pagina);

            stmt.execute();
            stmt.close();
            con.close();
        }

        return true;
    }

    public boolean followingPagina(int usuario, int pagina) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT pagina FROM seguirPaginas WHERE seguidor = ? AND pagina = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuario);
        stmt.setInt(2, pagina);
        
        System.out.println("Entrou following: seguidor: "+usuario+ " pagina: " +pagina);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            stmt.close();
            con.close();
            return true;
        }

        stmt.close();
        con.close();
        return false;
    }
    
    public List listFollowing(int seguidor) throws SQLException{
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeguirPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "SELECT * FROM seguirPaginas WHERE seguidor = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, seguidor);
        
        ResultSet rs = stmt.executeQuery();
        List listPaginas = new ArrayList();
        
        while(rs.next()){
            SeguirPagina sp = new SeguirPagina(rs.getInt("idSeguir"), rs.getInt("seguidor"), 
                                               rs.getInt("pagina"), rs.getString("situacao"));
            
            listPaginas.add(sp);
        }
        
        con.close();
        return listPaginas;
    }
}
