/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorUsuario;
import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class InfoUser extends SimpleTagSupport {

    private String email;

    @Override
    public void doTag() {

        GerenciadorUsuario userDao = new GerenciadorUsuario();
        try {
            getJspContext().setAttribute("user", userDao.buscaUsuario(email));
        } catch (SQLException  ex) {
            ex.printStackTrace();
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
