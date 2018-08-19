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

    public boolean adiciona(String tipoUsuario, String email, String senha, String nome, String telefone, String sexo, String profissao,
            LocalDate dataNascimento, String CartegoriaEstabelecimento, float nota, String descricao, String rua,
            String estado, String cidade, String cep, String username) throws Exception {

        Usuario usuario = new Usuario(tipoUsuario, email, senha, nome, telefone, sexo,
                profissao, dataNascimento, CartegoriaEstabelecimento, nota, descricao, rua, estado, cidade, cep, username);
        return userDao.salvar(usuario);
    }
    
    
    

    public Usuario buscaUsuario(String email) throws SQLException {
        return userDao.buscar(email);
    }
}
