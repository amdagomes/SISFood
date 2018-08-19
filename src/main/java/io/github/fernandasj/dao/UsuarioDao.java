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
//Falta adicionar a foto
    @Override
    public boolean salvar(Usuario obj) throws SQLException, Exception {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO USUARIO(tipoUsuario,nome,telefone,sexo,email,profissao,dataNascimento,cartegoriaEstabelecimento,nota,descricao,"
                + "rua,estado,cidade,cep,username,senha)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, obj.getTipoUsuario());
        stmt.setString(2, obj.getNome());
        stmt.setString(3, obj.getTelefone());
        stmt.setString(4, obj.getSexo());
        stmt.setString(5, obj.getEmail());
        stmt.setString(6, obj.getProfissao());
        stmt.setDate(7, Date.valueOf(obj.getDataNascimento()));
        stmt.setString(8, obj.getCartegoriaEstabelecimento());
        stmt.setFloat(9, obj.getNota());
        stmt.setString(10, obj.getDescricao());
        stmt.setString(11, obj.getRua());
        stmt.setString(12, obj.getEstado());
        stmt.setString(13, obj.getCidade());
        stmt.setString(14, obj.getCep());
        stmt.setString(15, obj.getUsername());
        stmt.setString(16, obj.getSenha());
        stmt.execute();
        stmt.close();
        con.close();

        return true;

    }

    @Override
    public Usuario buscar(Object obj) throws SQLException {

        try {
            con = ConnectionFactory.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM usuario WHERE email= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1, obj);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Usuario u = new Usuario(resultado.getString("tipoUsuario"), resultado.getString("email"),
                    resultado.getString("senha"), resultado.getString("nome"), resultado.getString("telefone"), resultado.getString("sexo"),
                    resultado.getString("profissao"), resultado.getDate("dataNascimento"), resultado.getString("cartegoriaEstabelecimento"),
                    resultado.getFloat("nota"), resultado.getString("descricao"), resultado.getString("rua"),
                    resultado.getString("estado"), resultado.getString("cidade"), resultado.getString("cep"), resultado.getString("username"));
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
    public boolean deletar(Object obj) throws SQLException {
        if (buscar(obj) != null) {

            try {
                con = ConnectionFactory.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "DELETE FROM Usuario WHERE email= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, obj);
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
        stmt.setString(2, sql);
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
            String sql = "UPDATE USUARIO SET tipoUsuario =?,email =?,nome = ?"
                    + "telefone = ?,sexo = ? profissao = ?,dataNascimento = ?,cartegoriaEstabelecimento =?"
                    + "nota = ?,descricao =?,rua = ?,estado = ? cidade =?,cep =? username =? senha =? WHERE email= ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getTipoUsuario());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getSexo());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getProfissao());
            stmt.setDate(7, Date.valueOf(obj.getDataNascimento()));
            stmt.setString(8, obj.getCartegoriaEstabelecimento());
            stmt.setFloat(9, obj.getNota());
            stmt.setString(10, obj.getDescricao());
            stmt.setString(11, obj.getRua());
            stmt.setString(12, obj.getEstado());
            stmt.setString(13, obj.getCidade());
            stmt.setString(14, obj.getCep());
            stmt.setString(15, obj.getUsername());
            stmt.setString(15, obj.getSenha());

            stmt.execute();

            stmt.close();
            con.close();
           
            
            return true;
        }
    }

}


