/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
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
        String cartegoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        String rua = request.getParameter("rua");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        //String dia = request.getParameter("dia");
        String horaAbre = request.getParameter("horaAbre");
        String horaFecha = request.getParameter("horaFecha");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date abre = sdf.parse(horaAbre);
            Date fecha = sdf.parse(horaFecha);
            Time hrabre = new Time(abre.getTime());
            Time hrfecha = new Time(fecha.getTime());

            Part foto = request.getPart("foto");

            GerenciadorEstabelecimento gerenciador = new GerenciadorEstabelecimento();
            gerenciador.adicionar(usuario.getId(), nome, telefone, Imagem.setImg(foto, nome, "estbl"), cartegoria,
                    descricao, rua, estado, cidade, cep, null, hrabre, hrfecha);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(CadastroEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroEstabelecimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
