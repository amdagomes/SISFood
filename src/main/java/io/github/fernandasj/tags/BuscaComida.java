package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorComida;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class BuscaComida extends SimpleTagSupport{
    
    private int comida;
    
    @Override
    public void doTag(){
        try {
            GerenciadorComida g = new GerenciadorComida();
            getJspContext().setAttribute("comidaBuscada", g.buscaComida(comida));
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }
    
}
