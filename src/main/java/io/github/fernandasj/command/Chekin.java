/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciarChekin;
import io.github.fernandasj.modelo.Usuario;
import java.sql.Timestamp;
import java.time.LocalDate;
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
public class Chekin  implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        HttpSession session = request.getSession();
        String idUsuario = request.getParameter("user");
        String estabelecimento= request.getParameter("estbl");
        GerenciarChekin gerenciador = new GerenciarChekin();
        try {
            gerenciador.adiciona(Integer.parseInt(idUsuario),Integer.parseInt(estabelecimento));
            RequestDispatcher dispatcher = request.getRequestDispatcher("visita-estbl.jsp");
                dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Chekin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
}
}
