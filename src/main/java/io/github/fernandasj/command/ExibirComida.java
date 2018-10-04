/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.modelo.Comida;
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
 * @author fernanda
 */
public class ExibirComida implements Command {
    
    ComidaDao dao = new ComidaDao();
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int idComida = Integer.parseInt(request.getParameter("idComida"));
        
        try {
            Comida comida = dao.buscar(idComida);
            request.setAttribute("comida", comida);
            RequestDispatcher dispatcher = request.getRequestDispatcher("comida.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ExibirComida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
