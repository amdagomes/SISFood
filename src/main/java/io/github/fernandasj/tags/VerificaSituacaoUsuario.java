package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorAmizade;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class VerificaSituacaoUsuario extends SimpleTagSupport{
    private int remetente;
    private int destinatario;
    
    @Override
    public void doTag(){
        try {
            GerenciadorAmizade gAmizade = new GerenciadorAmizade();
            getJspContext().setAttribute("situacaoAmizade", gAmizade.verificaSituacao(remetente, destinatario));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getRemetente() {
        return remetente;
    }

    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }

    public int getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(int destinatario) {
        this.destinatario = destinatario;
    }
 
}
