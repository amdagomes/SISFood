package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class BuscaEstabelecimento extends SimpleTagSupport{
    
    private int id;
    
    @Override
    public void doTag(){
        try {
            GerenciadorEstabelecimento g = new GerenciadorEstabelecimento();
            getJspContext().setAttribute("estblBuscado", g.buscarPorId(id));
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
