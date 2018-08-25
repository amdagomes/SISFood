/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class CadastroUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");
        ;
        String rua = request.getParameter("rua");
        String numeroCasa = request.getParameter("numero");

        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String username = request.getParameter("username");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
       try {
            boolean cadastrar = gerenciador.Adiciona(nome, username, email, senha, LocalDate.parse(dataNascimento), rua, numeroCasa, cidade, cep, estado);
             
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      

    }
    
  
}
