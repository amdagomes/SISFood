package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.modelo.Usuario;
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
        GerenciadorUsuario g = new GerenciadorUsuario();
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        try {
            try {
                if (g.autenticar(request.getParameter("email"), request.getParameter("senha"))) {
                    
                    Usuario atual;
                    atual = g.buscaUsuario(request.getParameter("email"));
                    session.setAttribute("usuario", atual);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp" );
                    dispatcher.forward(request, response);
                    response.sendRedirect("home.jsp");
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
