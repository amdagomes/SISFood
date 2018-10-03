/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import io.github.fernandasj.modelo.Estabelecimento;
import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Amanda
 */
public class AtualizaPerfilEstbl implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String cartegoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        String rua = request.getParameter("rua");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String horaAbre = request.getParameter("horaAbre");
        String horaFecha = request.getParameter("horaFecha");
        Part foto = null;

        Estabelecimento e = new Estabelecimento();

        e.setId(id);
        e.setNome(nome);
        e.setCategoria(cartegoria);
        e.setCep(cep);
        e.setCidade(cidade);
        e.setDescricao(descricao);
        e.setEstado(estado);
        e.setRua(rua);
        e.setTelefone(telefone);

        try {
            foto = request.getPart("foto");

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date abre = sdf.parse(horaAbre);
            Date fecha = sdf.parse(horaFecha);
            Time hrabre = new Time(abre.getTime());
            Time hrfecha = new Time(fecha.getTime());

            System.out.println("Foto AtualizaPerfilEstbls: " + foto);
            if (foto != null) {
                e.setFoto(Imagem.setImg(foto, nome, "comida"));
            } else {
                Estabelecimento estbl = (Estabelecimento) session.getAttribute("estabelecimento");
                e.setFoto(estbl.getFoto());
            }

            e.setHoraAbre(hrabre);
            e.setHoraFecha(hrfecha);

            GerenciadorEstabelecimento g = new GerenciadorEstabelecimento();
            g.atualizarPerfil(e);

            session.setAttribute("estabelecimento", e);
            
            response.sendRedirect("perfil-estabelecimento.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
