package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.modelo.Comida;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernanda
 */
public class AtualizarComida implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int idComida = Integer.parseInt(request.getParameter("idComida"));
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        float preco = Float.parseFloat(request.getParameter("preco"));
        
        GerenciadorComida g = new GerenciadorComida();
        Comida comida = new Comida();
        comida.setIdComida(idComida);
        comida.setDescricao(descricao);
        comida.setNome(nome);
        comida.setPreco(preco);

        try {
            g.Atualizar(comida);
            response.sendRedirect("cardapio.jsp");
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
