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
import javax.servlet.http.Part;

/**
 *
 * @author Amanda
 */
public class Imagem {

    public static boolean setImage(int id, Part foto, String prefix) throws ServletException {
        System.out.println("id: " + id);
        GerenciadorUsuario userDao = new GerenciadorUsuario();

        try {
            InputStream input = foto.getInputStream();
            BufferedImage imagem = ImageIO.read(input);

            File diretorio = new File("C:\\Users\\Amanda\\Documents\\Amanda\\ADS\\SISFood\\src\\main\\webapp\\upload_images");
            
            System.out.println("Diretorio: " + diretorio);
            
            if (!diretorio.exists()) {
                diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
            }
            ImageIO.write(imagem, "jpg", new File(diretorio + "\\" + prefix + "-" + id + ".jpg"));
            
            userDao.setFoto(id, "upload_images\\" + prefix + "-" + id + ".jpg");

        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return true;
    }

}
