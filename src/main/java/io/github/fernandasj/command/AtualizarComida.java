package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.modelo.Comida;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author fernanda
 */
public class AtualizarComida implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        System.out.println("ENTROU ATUALIZAR COMIDA");
        
        int idComida = Integer.parseInt(request.getParameter("idComida"));
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");  

        Comida comida = new Comida();
            comida.setIdComida(idComida);
            comida.setNome(nome);
            comida.setDescricao(descricao);
            comida.setPreco(Float.parseFloat(preco));
        
        try {
            GerenciadorComida g = new GerenciadorComida();
            
            Part foto = request.getPart("foto");
            comida.setFoto(Imagem.setImg(foto, nome, "comida"));
            System.out.println("NOVA COMIDA: " + comida.toString());
            
            g.atualizar(comida);
            response.sendRedirect("cardapio.jsp");
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    
}
