/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.AmizadeDao;
import io.github.fernandasj.repository.DaoFactory;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;

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
    
    public boolean adiciona(int remetente, int destinatario) throws SQLException, ClassNotFoundException{
        return dao.solicitaAmizade(remetente, destinatario);
    }
    
    public int countPNotificacoes(int id) throws ClassNotFoundException, SQLException{
        return dao.countPSolicitacoes(id);
    }
}
