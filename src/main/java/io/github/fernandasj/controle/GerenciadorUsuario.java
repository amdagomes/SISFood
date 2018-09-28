package io.github.fernandasj.controle;

import io.github.fernandasj.dao.UsuarioDao;
import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.repository.DaoFactory;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Amanda
 */
public class GerenciadorUsuario {

    private DaoFactoryIF fabrica = null;
    private UsuarioDao userDao = null;
    
    public GerenciadorUsuario() throws SQLException, ClassNotFoundException{
        fabrica = DaoFactory.createFactory();
        userDao = fabrica.criaUsuarioDao();
    }

    public boolean autenticar(String email, String senha) throws SQLException, ClassNotFoundException {
        return userDao.autenticar(email, senha);
    }

    public boolean adiciona(String email, String senha, String nome, String sexo, LocalDate dataNascimento, String rua, 
                            String numeroCasa, String estado, String cidade, String cep) throws Exception{
        Usuario usuario = new Usuario(email,senha,nome,sexo,dataNascimento, rua, numeroCasa,estado, cidade,cep);
        return userDao.salvar(usuario);     
    }
    
    public boolean setFoto(int id, String foto) throws SQLException{
        return userDao.setFoto(id, foto);
    }
    
    public Usuario buscaUsuario(String email) throws SQLException {
        return userDao.buscar(email);
    }
    
    public boolean atualizar(Usuario obj) throws SQLException{
        return userDao.atualizar(obj);
    }
}
