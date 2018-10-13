package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorComida;
import io.github.fernandasj.controle.GerenciadorUsuario;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class ListAvaliacoesComida extends SimpleTagSupport{
    
    private int idComida;
   
    @Override
    public void doTag(){
        try {
            GerenciadorComida g = new GerenciadorComida();
            getJspContext().setAttribute("avaliacoes", g.listAvaliacoesComida(idComida)); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }
    
}
