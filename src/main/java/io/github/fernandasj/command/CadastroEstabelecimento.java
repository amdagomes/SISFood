/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Cliente
 */
public class CadastroEstabelecimento implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String cartegoria = request.getParameter("telefone");
        String nota = request.getParameter("nota");
        String descricao = request.getParameter("descricao");
        String rua = request.getParameter("rua");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String dia = request.getParameter("dia");
        String horaAbre = request.getParameter("horaAbre");
        String horaFecha = request.getParameter("horaFecha");
        Part part = null;
        try {

            byte[] foto = new byte[(int) part.getSize()];
            InputStream stream = part.getInputStream();
            stream.read(foto);
            stream.close();
            GerenciadorEstabelecimento gerenciador = new GerenciadorEstabelecimento();
            gerenciador.Adicionar(usuario.getId(), nome, telefone, foto, cartegoria, Float.parseFloat(nota),
                    descricao, rua, estado, cidade, cep, dia, Time.valueOf(horaAbre),
                    Time.valueOf(horaFecha));

        } catch (IOException ex) {
            Logger.getLogger(CadastroEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
