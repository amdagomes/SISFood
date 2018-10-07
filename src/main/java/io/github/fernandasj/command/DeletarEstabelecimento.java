package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Estabelecimento;
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
public class DeletarEstabelecimento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Estabelecimento estbl = (Estabelecimento) session.getAttribute("estabelecimento");
        
        try {
            GerenciadorEstabelecimento g = new GerenciadorEstabelecimento();
            g.deletar(estbl.getId());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DeletarEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
