/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;

import io.github.fernandasj.controle.GerenciarPublicacao;
import io.github.fernandasj.modelo.Estabelecimento;
import io.github.fernandasj.modelo.Publicacao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class ExibirPublicacaoEstabelecimento implements Command {
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
            int idEstabelecimento =Integer.parseInt(request.getParameter("idEstabelecimento"));
            
            GerenciarPublicacao gP= new GerenciarPublicacao();
              GerenciadorEstabelecimento gE = new  GerenciadorEstabelecimento();
           
            try {
                
                Publicacao publicacao = gP.BuscaPublicacao(idPublicacao);
                request.setAttribute("publicacao", publicacao);
                Estabelecimento estabelecimento = gE.buscarPorId(idEstabelecimento);
                 
                request.setAttribute("estab", estabelecimento);
                response.sendRedirect("FeedPaginas.jsp");
                response.sendRedirect("estabelecimento.jsp");
                
                
               
            } catch (IOException ex) {
                Logger.getLogger(ExibirPublicacaoEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
            } 
}       catch (SQLException ex) {
            Logger.getLogger(ExibirPublicacaoEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExibirPublicacaoEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
