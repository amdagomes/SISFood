 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class AtualizaPerfil implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        String dataNascimento = request.getParameter("dataNascimento");
        String rua = request.getParameter("rua");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String numeroCasa = request.getParameter("numeroCasa");
        String estado = request.getParameter("estado");
        String profissao = request.getParameter("profissao");
        String telefone = request.getParameter("telefone");
        String descricao = request.getParameter("descricao");
        
        Usuario u = new Usuario(id, email, senha, nome, telefone, sexo, profissao, LocalDate.parse(dataNascimento), descricao, rua, numeroCasa, estado, cidade, cep);

        try {
            GerenciadorUsuario userDao = new GerenciadorUsuario();
            
            userDao.atualizar(u);
            if(request.getPart("fotoPerfil").getSize() != 0){
                System.out.println("entrou");
                Imagem.setImage(id, request.getPart("fotoPerfil"), "user");
            }
              
            HttpSession session = request.getSession();
            
            session.removeAttribute("usuario");
            
            session.setAttribute("usuario", userDao.buscaUsuario(email));
            response.sendRedirect("perfil-usuario.jsp");
            //request.getRequestDispatcher("perfil-usuario.jsp").forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        } 

    }

}
