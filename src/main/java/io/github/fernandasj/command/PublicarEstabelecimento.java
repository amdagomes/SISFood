/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciarPublicacao;
import io.github.fernandasj.modelo.Estabelecimento;
import java.io.IOException;
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
public class PublicarEstabelecimento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       HttpSession session = request.getSession();
       String idEstabelecimento= request.getParameter("idEstabelecimento");
        String texto = request.getParameter("texto");
        GerenciarPublicacao gp = new GerenciarPublicacao();

        try {
            if(gp.adicionaEst(texto,Integer.parseInt (idEstabelecimento))){
               request.getRequestDispatcher("estabelecimento.jsp").forward(request, response);
             
            }
            else{
                 response.sendRedirect("index.jsp");
            }
           
            System.out.println(texto);
        } catch (IOException ex) {
            Logger.getLogger(PublicarEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PublicarEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    }
    

