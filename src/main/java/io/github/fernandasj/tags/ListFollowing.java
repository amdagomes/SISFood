package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorSeguirPagina;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class ListFollowing extends SimpleTagSupport{
    
    private int usuario;
    
    @Override
    public void doTag(){
        try {
            GerenciadorSeguirPagina gSeguir = new GerenciadorSeguirPagina();
            getJspContext().setAttribute("seguindo", gSeguir.listFollowing(usuario));
        } catch (Exception ex) {
          ex.printStackTrace();
        } 
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    
}
