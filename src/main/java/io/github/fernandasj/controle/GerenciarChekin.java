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
import io.github.fernandasj.connection.DaoFactoryIF;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Cliente
 */
public class GerenciarChekin {
    
    private DaoFactoryIF fabrica = null;
    private ChekinDao chekindao = new ChekinDao();
    
    public boolean adiciona( int consumidor, int estabelecimento)throws Exception{
        Chekin chekin = new Chekin(consumidor,estabelecimento);
        return chekindao.salvar(chekin);     
    }
      public boolean Deletar(int chekin) throws Exception {
        return chekindao.deletar(chekin);
    }
   public Chekin Buscar(int chekin) throws SQLException {
        return chekindao.buscar(chekin);
    }
}
