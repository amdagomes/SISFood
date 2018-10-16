package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorRecomendacao;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class ListRecomendacaoEstabelecimento extends SimpleTagSupport{
    
    private int destinatario;
    
    @Override
    public void doTag(){
        try {
            GerenciadorRecomendacao g = new GerenciadorRecomendacao();
            getJspContext().setAttribute("recEstbl", g.listRecomendacaoEstabelecimento(destinatario));
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public int getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(int destinatario) {
        this.destinatario = destinatario;
    }
    
}
