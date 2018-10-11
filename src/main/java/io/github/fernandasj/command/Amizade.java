package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorAmizade;
import io.github.fernandasj.modelo.Usuario;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class Amizade implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        String metodo = request.getParameter("met");
        int remetente = u.getId();
        int destinatario = Integer.parseInt(request.getParameter("dest"));
        String pag = request.getParameter("pag"); //pagina para qual deve ser redirecionada

        try {
            GerenciadorAmizade gAmizade = new GerenciadorAmizade();

            if(metodo.equals("solicita")) {
                gAmizade.solicitaAmizade(remetente, destinatario);
            } else if(metodo.equals("adiciona")){
                gAmizade.adiciona(remetente, destinatario);
            } else{
                gAmizade.remove(remetente, destinatario);
            }
            
            request.getRequestDispatcher(pag + ".jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
