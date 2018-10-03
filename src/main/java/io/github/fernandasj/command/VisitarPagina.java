package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.controle.GerenciadorUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VisitarPagina implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        String tipo = request.getParameter("t");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Tipo: " + tipo);
        System.out.println("Id: " + id);
        try {
            GerenciadorEstabelecimento gEstbl = new GerenciadorEstabelecimento();
            GerenciadorUsuario gUsuario = new GerenciadorUsuario();
            
            if(tipo.equals("u")){
                session.setAttribute("visita", gUsuario.buscaPorId(id));
                request.getRequestDispatcher("cardapio-visitante.jsp").forward(request, response);
            } else{
                session.setAttribute("visita", gEstbl.buscarPorId(id));
                request.getRequestDispatcher("cardapio-visitante.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(VisitarPagina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
