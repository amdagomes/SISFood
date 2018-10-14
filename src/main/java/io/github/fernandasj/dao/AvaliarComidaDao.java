package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.AvaliarComida;
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
public class AvaliarComidaDao {

    private Connection con;

    public boolean salvar(AvaliarComida obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO AvaliarComida(consumidor,comentario,nota,comida)"
                + " VALUES(?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, obj.getConsumidor());
            stmt.setString(2, obj.getComentario());
            stmt.setFloat(3, obj.getNota());
            stmt.setInt(4, obj.getComida());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public AvaliarComida buscar(int IdAvaliacao) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM AvaliarComida WHERE idAvaliacao= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, IdAvaliacao);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            AvaliarComida Av = new AvaliarComida(resultado.getInt("consumidor"),
                    resultado.getFloat("nota"), resultado.getString("Comentario"), resultado.getInt("Comida"));

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
       
    public List<AvaliarComida> listAvaliacoes(int idComida) throws SQLException{
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM AvaliarComida WHERE comida = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idComida);
        ResultSet rs = stmt.executeQuery();
            
        List<AvaliarComida> avaliacoes = new ArrayList();
        
        while(rs.next()){
             AvaliarComida avl = new AvaliarComida();
             avl.setConsumidor(rs.getInt("consumidor"));
             avl.setNota(rs.getFloat("nota"));
             avl.setComentario(rs.getString("comentario"));
             avaliacoes.add(avl);
        }
        
        con.close();
        return avaliacoes;
    }

    public boolean atualizar(AvaliarComida obj) throws SQLException {

        AvaliarComida av = buscar(obj.getIdAvaliacao());
        if (av == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE AvaliarComida SET Nota=?,Comentario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setFloat(1, obj.getNota());
            stmt.setString(2, obj.getComentario());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    public boolean deletar(int idAvaliacao) throws SQLException {
        if (buscar(idAvaliacao) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AvaliarComidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "DELETE FROM AvaliarComida WHERE idAvaliacao= ?";
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