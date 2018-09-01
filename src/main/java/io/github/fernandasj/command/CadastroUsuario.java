/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static jdk.nashorn.tools.ShellFunctions.input;

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

        Part part;
        try {
            part = request.getPart("fotoPerfil");
            byte[] fotoPerfil = new byte[(int) part.getSize()];
            InputStream stream = part.getInputStream();
            stream.read(fotoPerfil);
            stream.close();
            GerenciadorUsuario gerenciador = new GerenciadorUsuario();
            LocalDate data = LocalDate.parse(dataNascimento);
            LocalDate dataRequerida = LocalDate.of(2008, 01, 01);
            if (dataRequerida.isBefore(data)) {
                response.sendRedirect("cadastro.jsp?erroCadastroUsuario=1");
            } else if (gerenciador.buscaUsuario(email) != null) {
                response.sendRedirect("cadastro.jsp?erroCadastroUsuario=2");
            } else {
                gerenciador.adiciona(nome, email, senha, sexo, LocalDate.parse(dataNascimento), rua, numeroCasa, cidade, cep, estado, fotoPerfil);
                response.sendRedirect("index.jsp");
            }

        } catch (IOException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
