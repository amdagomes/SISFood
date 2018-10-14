package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorSeguirPagina;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class VerificaSeguePagina extends SimpleTagSupport {
    
    private int seguidor;
    private int pagina;
    
    @Override
    public void doTag(){
        try {
            GerenciadorSeguirPagina gSegue = new GerenciadorSeguirPagina();
            getJspContext().setAttribute("seguePagina", gSegue.following(seguidor, pagina));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(int seguidor) {
        this.seguidor = seguidor;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
    
}
