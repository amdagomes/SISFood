/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.AmizadeDao;
import io.github.fernandasj.modelo.SolicitaAmizade;
import io.github.fernandasj.repository.DaoFactory;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public class GerenciadorAmizade {
    
    private DaoFactoryIF fabrica = null;
    private AmizadeDao dao = null;
    
    public GerenciadorAmizade() throws SQLException, ClassNotFoundException{
        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaAmizadeDao();
    }
    
    public boolean solicitaAmizade(int remetente, int destinatario) throws SQLException, ClassNotFoundException{
        return dao.solicitaAmizade(remetente, destinatario);
    }
    
    public boolean adiciona(int remetente, int destinatario) throws SQLException, ClassNotFoundException{
        return dao.aceitaSolicitacao(remetente, destinatario);
    }
    
    public boolean remove(int remetente, int destinatario) throws ClassNotFoundException, SQLException{
        return dao.desfazerAmizade(remetente, destinatario);
    }
    
    public int countPNotificacoes(int id) throws ClassNotFoundException, SQLException{
        return dao.countPSolicitacoes(id);
    }
    
    public List listaSolicitacoes(int id) throws SQLException, ClassNotFoundException{
        return dao.listaSolicitacoes(id);
    }
    
    public SolicitaAmizade verificaSituacao(int remetente, int destinatario) throws ClassNotFoundException, SQLException{
        return dao.isAmigo(remetente, destinatario);
    }
    
    public List listaAmigos(int id) throws ClassNotFoundException, SQLException{
        return dao.listarAmigos(id);
    }
}
