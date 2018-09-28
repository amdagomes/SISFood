/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.modelo.Estabelecimento;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Cliente
 */
public class CadastroComida implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         HttpSession session = request.getSession();
         
        Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("estabelecimento");
         
        
        String descricao = request.getParameter("descricao");
        String preco = request.getParameter("preco");
        //alterar quando o calculo de nota estiver pronto
        String nota = "2.5";
         
        String nome = request.getParameter("nome");
                  
        try { 
            Part foto = request.getPart("foto");
            
            GerenciadorComida g = new GerenciadorComida();
            g.Adicionar(estabelecimento.getId(), descricao, Float.parseFloat(preco), nome, Imagem.setImg(foto, nome, "comida"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("cardapio.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
    
}
