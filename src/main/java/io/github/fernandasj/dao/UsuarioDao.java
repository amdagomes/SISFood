package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao implements Dao<Usuario> {

    private Connection con;

    @Override
    public boolean salvar(Usuario obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO USUARIO(email,senha,nome,sexo,dataNascimento, rua, numeroCasa,estado, cidade,cep)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, obj.getEmail());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getNome());
            stmt.setString(4, obj.getSexo());
            stmt.setDate(5, Date.valueOf(obj.getDataNascimento()));
            stmt.setString(6, obj.getRua());
            stmt.setString(7, obj.getNumeroCasa());
            stmt.setString(8, obj.getEstado());
            stmt.setString(9, obj.getCidade());
            stmt.setString(10, obj.getCep());
            stmt.execute();
            stmt.close();
        }
        con.close();
        return true;
    }

    public Usuario buscarPorId(int id) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM usuario WHERE idUsuario= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("email"), resultado.getString("senha"),
                    resultado.getString("nome"), resultado.getString("telefone"), resultado.getString("sexo"),
                    resultado.getString("profissao"), resultado.getDate("dataNascimento").toLocalDate(),
                    resultado.getString("descricao"), resultado.getString("rua"), resultado.getString("numeroCasa"),
                    resultado.getString("estado"), resultado.getString("cidade"), resultado.getString("cep"),
                    resultado.getString("fotoPerfil"));
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
    public boolean deletar(String email) throws SQLException {
        if (buscar(email) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Usuario WHERE email= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

    public boolean autenticar(String email, String senha) throws SQLException, ClassNotFoundException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);
        if (stmt.executeQuery().next()) {
            stmt.close();
            con.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean atualizar(Usuario obj) throws SQLException {
        Usuario usuario = buscar(obj.getEmail());
        if (usuario == null) {
            return false;
        } else {

            try {
                con = ConnectionFactory.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE USUARIO SET email =?,nome = ?"
                    + "telefone = ?,sexo = ? profissao = ?,dataNascimento = ?"
                    + "rua = ?,estado = ? cidade =?,cep =?, senha =? WHERE email= ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getSexo());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getProfissao());
            stmt.setDate(7, Date.valueOf(obj.getDataNascimento()));
            stmt.setString(11, obj.getRua());
            stmt.setString(12, obj.getEstado());
            stmt.setString(13, obj.getCidade());
            stmt.setString(14, obj.getCep());
            stmt.setString(15, obj.getSenha());

            stmt.execute();

            stmt.close();
            con.close();

            return true;
        }
    }

    public Usuario BuscarPorNome(String nome) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM usuario WHERE nome= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("email"), resultado.getString("nome"),
                    resultado.getString("senha"), resultado.getString("sexo"),
                    resultado.getDate("dataNascimento").toLocalDate(), resultado.getString("descricao"),
                    resultado.getString("rua"),
                    resultado.getString("estado"), resultado.getString("cidade"), resultado.getString("cep"),
                    resultado.getString("numeroCasa"), resultado.getString("fotoPerfil"));
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

    public Usuario buscar(String email) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM usuario WHERE email= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nome"), resultado.getString("email"),
                    resultado.getString("senha"), resultado.getString("sexo"),
                    resultado.getDate("dataNascimento").toLocalDate(), resultado.getString("descricao"),
                    resultado.getString("rua"),
                    resultado.getString("numeroCasa"), resultado.getString("cidade"), resultado.getString("cep"),
                    resultado.getString("estado"), resultado.getString("fotoPerfil"));
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

    public boolean setFoto(int id, String foto) throws SQLException {
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String sql = "UPDATE usuario SET fotoPerfil = ? WHERE idUsuario = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, foto);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        con.close();

        return true;
    }
}
