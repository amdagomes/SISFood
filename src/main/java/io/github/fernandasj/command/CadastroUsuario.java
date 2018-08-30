/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
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
        String rua = request.getParameter("rua");
        String numeroCasa = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
       try {
            LocalDate data = LocalDate.parse(dataNascimento);
            LocalDate dataRequerida = LocalDate.of(2008, 01, 01);
            System.out.println(dataRequerida.isBefore(data));
            if(dataRequerida.isBefore(data)){
                response.sendRedirect("cadastro.jsp?erroCadastroUsuario=1");
            }else if(gerenciador.buscaUsuario(email) != null){
                 response.sendRedirect("cadastro.jsp?erroCadastroUsuario=2");
            } else{
                gerenciador.adiciona(nome, email, senha, LocalDate.parse(dataNascimento), rua, numeroCasa, cidade, cep, estado);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                 
             }
      

    }
    

