/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorAmizade;
import io.github.fernandasj.controle.GerenciadorUsuario;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class BuscaUsuario extends SimpleTagSupport{
    
    private int user;
    
    @Override
    public void doTag(){
        try {
            GerenciadorUsuario gUser = new GerenciadorUsuario();
            getJspContext().setAttribute("userBuscado", gUser.buscaPorId(user));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
}
