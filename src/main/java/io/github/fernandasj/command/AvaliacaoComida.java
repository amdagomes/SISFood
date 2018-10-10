package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.modelo.AvaliarComida;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernanda
 */
public class AvaliacaoComida implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
         
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        int idComida = Integer.parseInt(request.getParameter("idComida"));
        float nota = Float.parseFloat(request.getParameter("nota"));
        String comentario = request.getParameter("comentario");
        int idUsuario = usuario.getId();
        
        AvaliarComida avaliacao = new AvaliarComida();
            avaliacao.setComida(idComida);
            avaliacao.setConsumidor(idUsuario);
            avaliacao.setComentario(comentario);
            avaliacao.setNota(nota);
        
        try {
            GerenciadorComida g = new GerenciadorComida();            
            g.avaliarComida(avaliacao);
            response.sendRedirect("cardapio-visitante.jsp");
            
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(AvaliacaoComida.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
}
