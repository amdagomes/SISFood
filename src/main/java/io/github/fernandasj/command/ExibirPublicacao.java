/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.command.Command;
import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.controle.GerenciarPublicacao;
import io.github.fernandasj.dao.PublicacaoDao;
import io.github.fernandasj.modelo.Publicacao;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cliente
 */
public class ExibirPublicacao implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
            int idUsuario =Integer.parseInt(request.getParameter("idUsuario"));
            
            GerenciarPublicacao gP= new GerenciarPublicacao();
            GerenciadorUsuario gU = new GerenciadorUsuario();
           
            try {
                
                Publicacao publicacao = gP.BuscaPublicacao(idPublicacao);
                request.setAttribute("publicacao", publicacao);
                Usuario user = gU.buscaPorId(idUsuario);
                 
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
                 System.out.println(publicacao.getIdUsuario());
            } catch (SQLException ex) {
                Logger.getLogger(ExibirPublicacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExibirPublicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibirPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExibirPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

     
}
