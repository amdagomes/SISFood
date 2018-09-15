/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.EstabelecimentoDao;
import io.github.fernandasj.modelo.Estabelecimento;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.Time;

/**
 *
 * @author Cliente
 */
public class GerenciadorEstabelecimento {

    private DaoFactoryIF fabrica = null;
    private EstabelecimentoDao estabelecimentoDao = new EstabelecimentoDao();
    
    public boolean Adicionar (int idUsuario,String nome, String telefone, byte[] foto, String cartegoria, 
            float nota, String descricao, String rua,String estado, String cidade, String cep, 
            String dia, Time horaAbre, Time horaFecha) throws Exception{
        Estabelecimento estabelecimento =new Estabelecimento(idUsuario,nome,telefone,foto,cartegoria,nota,descricao,rua,estado,cidade,cep,dia,horaAbre,horaFecha);
        return estabelecimentoDao.salvar(estabelecimento);
        
        
    }
}
