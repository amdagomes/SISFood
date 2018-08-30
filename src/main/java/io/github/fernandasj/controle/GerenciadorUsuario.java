package io.github.fernandasj.controle;

import io.github.fernandasj.dao.UsuarioDao;
import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Amanda
 */
public class GerenciadorUsuario {

    private DaoFactoryIF fabrica = null;
    private UsuarioDao userDao = new UsuarioDao();

    public boolean autenticar(String email, String senha) throws SQLException, ClassNotFoundException {
        return userDao.autenticar(email, senha);
    }

    public boolean adiciona(String nome,String email,String senha, LocalDate dataNascimento,
            String rua,String numeroCasa,String cidade,String cep,String estado) throws Exception{
        Usuario usuario = new Usuario (nome,email,senha,dataNascimento,rua,numeroCasa,cidade,cep,estado);
        return userDao.salvar(usuario);
        
    }
    
    
    

    public Usuario buscaUsuario(String email) throws SQLException {
        return userDao.buscar(email);
    }
}
