/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciarComentario;
import io.github.fernandasj.modelo.Publicacao;
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
public class Comentar implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
      
        String comentario = request.getParameter("comentario");
        String idPublicacao = request.getParameter("idPublicacao");
         String pagina = request.getParameter("pagina");
        GerenciarComentario gC = new GerenciarComentario();
        try {
            
            if(gC.adiciona( comentario,usuario.getId(),Integer.parseInt(idPublicacao))){
               //request.getRequestDispatcher("home.jsp").forward(request, response);
               request.getRequestDispatcher(pagina + ".jsp").forward(request, response);
            }
            else{
                 response.sendRedirect("index.jsp");
            }
           
            
      
        } catch (Exception ex) {
            Logger.getLogger(Comentar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
