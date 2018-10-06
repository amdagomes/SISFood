package io.github.fernandasj.tags;

import io.github.fernandasj.controle.GerenciadorAmizade;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Amanda
 */
public class BuscaNotificacao extends SimpleTagSupport{
    
    private int user;
    
    @Override
    public void doTag(){
        try {
            GerenciadorAmizade gAmizade = new GerenciadorAmizade();
            getJspContext().setAttribute("notificacoes", gAmizade.countPNotificacoes(user));
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
