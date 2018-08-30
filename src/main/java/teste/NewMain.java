/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import io.github.fernandasj.dao.UsuarioDao;
import io.github.fernandasj.modelo.Usuario;
import java.time.LocalDate;

/**
 *
 * @author Cliente
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuario.setNome("teste");
        usuario.setEmail("testes@gmail.com");
        usuario.setDataNascimento(LocalDate.now());
        usuario.setProfissao("estudante");
        usuario.setCidade("cz");
        usuario.setRua("rua");
        usuario.setDescricao("descricao");
        usuario.setSexo("feminino");
        usuario.setSenha("123");
        usuario.setEstado("pb");
        usuario.setTipoUsuario("consumidor");
        usuario.setTelefone("233333333");
        usuario.setCep("00000000");
        usuario.setCartegoriaEstabelecimento("teste");
        usuario.setNota((float) 0.9);
        //dao.salvar(usuario);
        

        //System.out.println(dao.autenticar("testess@gmail.com", "123"));

    }

}
