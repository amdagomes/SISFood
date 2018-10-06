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

public class VisitarPag implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        String tipo = request.getParameter("t");
        String pag = request.getParameter("pag");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            GerenciadorEstabelecimento gEstbl = new GerenciadorEstabelecimento();
            GerenciadorUsuario gUsuario = new GerenciadorUsuario();

            if (tipo.equals("u")) {
                session.setAttribute("visita", gUsuario.buscaPorId(id));
                if (pag.equals("user")) {
                    request.getRequestDispatcher("visita-user.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("cardapio-visitante.jsp").forward(request, response);
                }
            } else {
                session.setAttribute("visita", gEstbl.buscarPorId(id));
                if (pag.equals("estbl")) {
                    request.getRequestDispatcher("visita-estbl.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("cardapio-visitante.jsp").forward(request, response);
                } 
            }
        } catch (Exception ex) {
            Logger.getLogger(VisitarPag.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
