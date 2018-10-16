/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.controle.GerenciarChekin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.github.fernandasj.modelo.Chekin;
import io.github.fernandasj.modelo.Estabelecimento;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Cliente
 */
public class ExibirCheckin implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        int chekin = Integer.parseInt(request.getParameter("idChekin"));
        
        
        try {
            GerenciadorEstabelecimento gE = new GerenciadorEstabelecimento();
            GerenciarChekin gC = new GerenciarChekin();
            
            Chekin c = gC.Buscar(chekin);
            request.setAttribute("c", c);
          System.out.println(c);
          System.out.println(chekin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("checkin.jsp");
            dispatcher.forward(request, response);
                
            

        } catch (SQLException ex) {
            Logger.getLogger(ExibirCheckin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExibirCheckin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExibirCheckin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
