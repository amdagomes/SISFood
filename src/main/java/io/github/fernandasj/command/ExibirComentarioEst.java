/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.controle.GerenciarComentario;
import io.github.fernandasj.modelo.Comentario;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
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
public class ExibirComentarioEst implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
          
        try {
            int idComentario = Integer.parseInt(request.getParameter("Comentario"));
            int idUsuario =Integer.parseInt(request.getParameter("idUsuario"));
            GerenciarComentario gC= new GerenciarComentario();
            GerenciadorUsuario gU = new GerenciadorUsuario();
            try {
                Comentario comentario = gC.Busca(idComentario);
                request.setAttribute("comentario", comentario);
                Usuario user = gU.buscaPorId(idUsuario);
                request.setAttribute("userComentarista", idUsuario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("estabelecimento.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ExibirComentario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExibirComentario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExibirComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExibirComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

