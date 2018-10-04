/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import io.github.fernandasj.modelo.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class CadastroUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        String dataNascimento = request.getParameter("dataNascimento");
        String rua = request.getParameter("rua");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String numeroCasa = request.getParameter("numeroCasa");
        String estado = request.getParameter("estado");

        try {
            GerenciadorUsuario gerenciador = new GerenciadorUsuario();
            LocalDate data = LocalDate.parse(dataNascimento);
            LocalDate dataRequerida = LocalDate.of(2008, 01, 01);
            if (dataRequerida.isBefore(data)) {
                response.sendRedirect("cadastro.jsp?erroCadastroUsuario=1");
            } else if (gerenciador.buscaUsuario(email) != null) {
                response.sendRedirect("cadastro.jsp?erroCadastroUsuario=2");
            } else if (gerenciador.adiciona(email, senha, nome, sexo, data, rua, numeroCasa, estado, cidade, cep)) {
                Usuario user = gerenciador.buscaUsuario(email);
                Imagem.setImage(user.getId(), request.getPart("fotoPerfil"), "user");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
