/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciarChekin;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class Chekin  implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         String dia = request.getParameter("dia");
        String horario = request.getParameter("horario");
        String consumidor = request.getParameter("consumidor");
        String estabelecimento = request.getParameter("estabelecimento");
        
        GerenciarChekin gerenciador = new GerenciarChekin();
        try {
            gerenciador.adiciona(Timestamp.valueOf(horario), LocalDate.parse(dia),  Integer.parseInt(consumidor), Integer.parseInt(estabelecimento));
        } catch (Exception ex) {
            Logger.getLogger(Chekin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
}
}
