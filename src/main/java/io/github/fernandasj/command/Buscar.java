package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.controle.GerenciadorUsuario;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class Buscar implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        String nome = request.getParameter("search");
        try {
            GerenciadorEstabelecimento gEstbl = new GerenciadorEstabelecimento();
            GerenciadorUsuario gUser = new GerenciadorUsuario();
            
            session.setAttribute("buscaE", gEstbl.listarPorNome(nome));
            session.setAttribute("buscaU", gUser.listarPorNome(nome));
            
            request.getRequestDispatcher("resultado-busca.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
