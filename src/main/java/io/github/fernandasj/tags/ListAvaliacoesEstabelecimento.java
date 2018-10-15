package io.github.fernandasj.tags;
import io.github.fernandasj.controle.GerenciadorEstabelecimento;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author fernanda
 */
public class ListAvaliacoesEstabelecimento extends SimpleTagSupport{
      
    private int idEstabelecimento;
   
    @Override
    public void doTag(){
        try {
            GerenciadorEstabelecimento g = new GerenciadorEstabelecimento();
            getJspContext().setAttribute("avaliacoes", g.listAvaliacoesEstabelecimento(idEstabelecimento));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
    
}

