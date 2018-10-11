package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.modelo.avaliarEstabelecimento;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernanda
 */
public class AvaliacaoEstabelecimento implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        int consumidor = usuario.getId();
        int estabelecimento = Integer.parseInt(request.getParameter("idEstabelecimento"));
        float nota = Float.parseFloat(request.getParameter("nota"));
        String comentario = request.getParameter("comentario");

        avaliarEstabelecimento avaliacao = new avaliarEstabelecimento(consumidor, estabelecimento, nota, comentario);

        try {
            GerenciadorEstabelecimento g = new GerenciadorEstabelecimento();            
            g.avaliarEstabelecimento(avaliacao);
            response.sendRedirect("visita-estbl.jsp");

        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    }
}
