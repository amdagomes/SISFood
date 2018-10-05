/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amanda
 */
public interface AmizadeDaoIF<T>{
    
    public boolean solicitaAmizade(int remetente, int destintario) throws ClassNotFoundException, SQLException;
    public boolean desfazerAmizade(int remetente, int destintario) throws ClassNotFoundException, SQLException;
    public boolean isAmigo(int remetente, int destintario) throws ClassNotFoundException, SQLException;
    public List<T> listarAmigos(int id) throws ClassNotFoundException, SQLException;
    
}
