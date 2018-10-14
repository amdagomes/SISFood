/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.command.Command;
import io.github.fernandasj.controle.GerenciarPublicacao;
import io.github.fernandasj.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cliente
 */
public class Publicar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String texto = request.getParameter("texto");
        GerenciarPublicacao gp = new GerenciarPublicacao();

        try {
            if(gp.adiciona(usuario.getId(), texto)){
               request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else{
                 response.sendRedirect("index.jsp");
            }
           
          
        } catch (Exception ex) {
            Logger.getLogger(Publicar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
