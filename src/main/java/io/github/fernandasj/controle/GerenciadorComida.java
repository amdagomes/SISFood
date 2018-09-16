/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;


import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.modelo.Comida;
import io.github.fernandasj.repository.DaoFactoryIF;

/**
 *
 * @author Cliente
 */
public class GerenciadorComida {
    private DaoFactoryIF fabrica = null;
    private ComidaDao dao = new ComidaDao();
    public boolean Adicionar (int idUsuario,String descricao,float preco,float nota,String nome) throws Exception{
        Comida comida= new Comida(idUsuario,descricao,preco,nota,nome);
        return dao.salvar(comida);
    }
}
