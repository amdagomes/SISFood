package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Consumidor;
import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class ConsumidorDao implements Dao<Consumidor> {

    private Connection con;

    @Override
    public boolean salvar(Consumidor obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consumidor buscar(Object obj) throws SQLException {

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM consumidor WHERE email= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1, obj);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Consumidor u = new Consumidor(resultado.getString("email"),
                    resultado.getString("senha"), resultado.getString("nome"),
                    resultado.getBytes("foto"), resultado.getString("telefone"), resultado.getString("sexo"), resultado.getString("profissão"),
                    resultado.getDate("nascimento").toLocalDate(), resultado.getString("descricao"), resultado.getString("rua"), resultado.getString("estado"), resultado.getString("cidade"), resultado.getString("cep"));
            resultado.close();
            stmt.close();
            con.close();
            return u;
        }
        resultado.close();
        stmt.close();
        con.close();
        
        return null;
    }

    @Override
    public boolean atualizar(Consumidor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean autenticar(String email, String senha) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConsumidorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM consumidor WHERE email = ? AND senha = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, sql);
        if (stmt.executeQuery().next()) {
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }
}
