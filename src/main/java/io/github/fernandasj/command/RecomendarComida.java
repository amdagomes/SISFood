package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.modelo.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernanda
 */
public class RecomendarComida implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        int idDestinatario;
        int remetente = usuario.getId();
        String emailDestinatario = request.getParameter("destinatario");
        String comida = request.getParameter("idComida");
        String comentario = request.getParameter("comentario");
        
        try { 
            GerenciadorUsuario gu = new GerenciadorUsuario();
            Usuario user = gu.buscaUsuario(emailDestinatario);
            if(user != null){
                idDestinatario = user.getId();
                GerenciadorComida g = new GerenciadorComida();
                g.recomendarComida(Integer.parseInt(comida), remetente, idDestinatario, comentario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("cardapio-visitante.jsp");
                dispatcher.forward(request, response);
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }    
}
