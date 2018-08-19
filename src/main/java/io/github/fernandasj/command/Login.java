package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorConsumidor;
import io.github.fernandasj.modelo.Consumidor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class Login implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        GerenciadorConsumidor g = new GerenciadorConsumidor();
        HttpSession session = request.getSession();
        Consumidor c = (Consumidor) session.getAttribute("usuario");

        try {
            if (g.autenticar(request.getParameter("email"), request.getParameter("senha"))) {

                Consumidor atual;
                atual = g.buscaConsumidor(request.getParameter("email"));
                session.setAttribute("usuario", atual);

                RequestDispatcher dispatcher = request.getRequestDispatcher("front?command=Inicio&email=" + atual.getEmail());
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
