/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.ChekinDao;
import io.github.fernandasj.dao.UsuarioDao;
import io.github.fernandasj.modelo.Chekin;
import io.github.fernandasj.modelo.Usuario;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Cliente
 */
public class GerenciarChekin {
    
    private DaoFactoryIF fabrica = null;
    private ChekinDao userDao = new ChekinDao();
    
    public boolean adiciona(Timestamp horario, LocalDate dia, int consumidor, int estabelecimento)throws Exception{
        Chekin chekin = new Chekin(horario,dia,consumidor,estabelecimento);
        return userDao.salvar(chekin);     
    }
}
