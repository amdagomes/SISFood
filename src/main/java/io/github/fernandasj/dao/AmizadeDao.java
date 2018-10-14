package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.SolicitaAmizade;
import io.github.fernandasj.modelo.StatusAmizade;
import io.github.fernandasj.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amanda
 */
public class AmizadeDao implements AmizadeDaoIF<SolicitaAmizade>{
    private Connection con;

    @Override
    public boolean solicitaAmizade(int remetente, int destintario) throws ClassNotFoundException, SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO solicitaAmizade(remetente, destinatario, horario, situacao) "
                    + "VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, remetente);
        stmt.setInt(2, destintario);
        stmt.setTime(3, Time.valueOf(LocalTime.now()));
        stmt.setString(4, StatusAmizade.SOLICITADO.getStatus());
        
        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        
        return retorno;
    }

    @Override
    public boolean desfazerAmizade(int remetente, int destintario) throws ClassNotFoundException, SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM solicitaamizade WHERE (remetente = ? AND destinatario = ?) OR (remetente = ? AND destinatario = ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, remetente);
        stmt.setInt(2, destintario);
        stmt.setInt(3, destintario);
        stmt.setInt(4, remetente);
        
        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        
        return retorno;
    }

    @Override
    public SolicitaAmizade isAmigo(int remetente, int destinatario) throws ClassNotFoundException, SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM solicitaamizade WHERE (remetente = ? AND destinatario = ?) OR (remetente = ? AND destinatario = ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, remetente);
        stmt.setInt(2, destinatario);
        stmt.setInt(3, destinatario);
        stmt.setInt(4, remetente);
        
        ResultSet rs = stmt.executeQuery();
        
        SolicitaAmizade sa = new SolicitaAmizade();
        
        if(rs.next()){
            sa.setDestinatario(rs.getInt("destinatario"));
            sa.setRemetente(rs.getInt("remetente"));
            sa.setSolicitacao(rs.getString("situacao"));
            sa.setIdSolicitacao(rs.getInt("idsolicitacao"));
            return sa;
        }
        
        con.close();
        return null;
    }
    
    public boolean aceitaSolicitacao(int remetente, int destinatario) throws SQLException, ClassNotFoundException{
        con = ConnectionFactory.getConnection();
        
        String sql = "UPDATE solicitaamizade SET situacao = ? WHERE (remetente = ? AND destinatario = ?) OR (remetente = ? AND destinatario = ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, StatusAmizade.AMIGO.getStatus());
        stmt.setInt(2, remetente);
        stmt.setInt(3, destinatario);
        stmt.setInt(4, destinatario);
        stmt.setInt(5, remetente);
        
        stmt.execute();
        stmt.close();
        con.close();
        
        return true;
    }

    @Override
    public List<SolicitaAmizade> listarAmigos(int id) throws ClassNotFoundException, SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM solicitaamizade WHERE (remetente = ? OR destinatario = ?) AND situacao = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setInt(2, id);
        stmt.setString(3, "amigo");
        
        ResultSet rs = stmt.executeQuery();
        
        List<SolicitaAmizade> lista = new ArrayList<>();
        
        while(rs.next()){
            SolicitaAmizade sa = new SolicitaAmizade();
            sa.setIdSolicitacao(rs.getInt("idsolicitacao"));
            sa.setRemetente(rs.getInt("remetente"));
            sa.setDestinatario(rs.getInt("destinatario"));
            sa.setSolicitacao(rs.getString("situacao"));
            
            lista.add(sa);
        }

        con.close();
        
        return lista;
    }
    
    public int countPSolicitacoes(int id) throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT COUNT(*) FROM solicitaamizade WHERE destinatario = ? AND situacao = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, StatusAmizade.SOLICITADO.getStatus());
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return rs.getInt(1);
        } else {
            con.close();
            return 0;
        }
    }
    
    public List listaSolicitacoes(int id) throws SQLException, ClassNotFoundException{
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM solicitaamizade WHERE destinatario = ? AND situacao = ?";
        PreparedStatement stmt = con.prepareStatement(sql); 
        stmt.setInt(1, id);
        stmt.setString(2, StatusAmizade.SOLICITADO.getStatus());
        
        ResultSet rs = stmt.executeQuery();
        
        List lista = new ArrayList();
          
        while(rs.next()){
            SolicitaAmizade sa = new SolicitaAmizade();
            sa.setIdSolicitacao(rs.getInt("idsolicitacao"));
            sa.setRemetente(rs.getInt("remetente"));
            sa.setDestinatario(rs.getInt("destinatario"));
            lista.add(sa);
        }
        
        con.close();
        
        return lista;
    }
}
