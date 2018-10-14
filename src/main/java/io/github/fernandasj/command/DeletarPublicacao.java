/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciarPublicacao;
import java.io.IOException;
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
public class DeletarPublicacao implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       HttpSession session = request.getSession();
       String idPublicacao = request.getParameter("idPublicacao");
        
        try {
            GerenciarPublicacao gP = new GerenciarPublicacao();
        gP. Deletar(Integer.parseInt(idPublicacao));
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(DeletarPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DeletarPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
