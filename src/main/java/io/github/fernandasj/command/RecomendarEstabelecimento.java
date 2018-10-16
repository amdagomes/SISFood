package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorRecomendacao;
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
public class RecomendarEstabelecimento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        int idDestinatario;
        int remetente = usuario.getId();
        String emailDestinatario = request.getParameter("destinatario");
        String comida = request.getParameter("idEstabelecimento");
        String comentario = request.getParameter("comentario");
        
        try { 
            GerenciadorUsuario gu = new GerenciadorUsuario();
            Usuario user = gu.buscaUsuario(emailDestinatario);
            if(user != null){
                idDestinatario = user.getId();
                GerenciadorRecomendacao g = new GerenciadorRecomendacao();
                g.recomendaEstabelecimento(Integer.parseInt(comida), remetente, idDestinatario, comentario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("visita-estbl.jsp");
                dispatcher.forward(request, response);
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }   
}
