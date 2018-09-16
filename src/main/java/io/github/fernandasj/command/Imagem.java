/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.command;

import io.github.fernandasj.controle.GerenciadorUsuario;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Amanda
 */
public class Imagem implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        GerenciadorUsuario userDao = new GerenciadorUsuario();

        try {

            Part foto = request.getPart("fotoPerfil");
            InputStream input = foto.getInputStream();
            BufferedImage imagem = ImageIO.read(input);

            File diretorio = new File(request.getServletContext().getRealPath("") + "upload_images/");
            String caminho = diretorio + "/" + id + ".jpg";
            System.out.println("Diretorio: " + diretorio);

            if (!diretorio.exists()) {
                diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
            }
            ImageIO.write(imagem, "jpg", new File(diretorio + "/" + id + ".jpg"));
            if (userDao.setFoto(id, caminho)) {
                System.out.println("ATUALIZOU!");
            } else {
                System.out.println("NÃO AtUALIZOU");
            }

            response.sendRedirect("index.jsp");
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
