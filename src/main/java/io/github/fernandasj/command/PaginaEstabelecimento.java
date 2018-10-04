/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Estabelecimento;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class PaginaEstabelecimento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            GerenciadorEstabelecimento gEstbl = new GerenciadorEstabelecimento();
            Estabelecimento e = gEstbl.buscarPorId(id);

            HttpSession session = request.getSession();
            session.setAttribute("estabelecimento", e);
            
            request.getRequestDispatcher("estabelecimento.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } 
        
    }
    
}
