package io.github.fernandasj.dao;

import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean deletar(int id) throws SQLException {
        if (buscarPorId(id) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Usuario WHERE idusuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
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
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?,"
                    + "sexo = ?, dataNascimento = ?, rua = ?, cidade = ?, cep = ?,"
                    + "numeroCasa = ?, estado = ?, telefone = ?, profissao = ?, descricao = ? WHERE idUsuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
             
            stmt.setString(1, obj.getNome());         
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getSexo());
            stmt.setDate(5, Date.valueOf(obj.getDataNascimento()));
            stmt.setString(6, obj.getRua());
            stmt.setString(7, obj.getCidade());
            stmt.setString(8, obj.getCep());
            stmt.setString(9, obj.getNumeroCasa());
            stmt.setString(10, obj.getEstado());
            stmt.setString(11, obj.getTelefone());
            stmt.setString(12, obj.getProfissao());
            stmt.setString(13, obj.getDescricao());
            stmt.setInt(14, obj.getId());
            
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

        String sql = "SELECT * FROM usuario WHERE nome = ?";
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
    
    public List<Usuario> listarPorNome(String nome) throws SQLException{
        
        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        String sql = "SELECT idusuario, nome, descricao, fotoPerfil FROM usuario WHERE nome ilike ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%"+nome+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        List<Usuario> lista = new ArrayList<>();
        Usuario u = new Usuario();
        
        while(rs.next()){
            u.setId(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setDescricao(rs.getString("descricao"));
            u.setFotoPerfil(rs.getString("fotoPerfil"));
            
            lista.add(u);
        }
        
        con.close();
        return lista;
    }
}
