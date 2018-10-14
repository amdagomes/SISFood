package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorSeguirPagina;
import io.github.fernandasj.modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class SeguirEstabelecimento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        int estbl = Integer.parseInt(request.getParameter("estbl"));
        String metodo = request.getParameter("met");
        String pagina = request.getParameter("pag");
        
        System.out.println("Pagina de retorno: " + pagina);
        
        try {
            GerenciadorSeguirPagina gSeguir = new GerenciadorSeguirPagina();
            
            if(metodo.equals("follow")){
                gSeguir.follow(u.getId(), estbl);                
            } else{
                gSeguir.unfollow(u.getId(), estbl);               
            }
            
            //response.sendRedirect(pagina+".jsp");
            request.getRequestDispatcher(pagina + ".jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
