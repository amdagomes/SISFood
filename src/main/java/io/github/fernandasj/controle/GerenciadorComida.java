/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;


import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.modelo.Comida;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class GerenciadorComida {
    private DaoFactoryIF fabrica = null;
    private ComidaDao dao = new ComidaDao();
    
    public boolean Adicionar (int idEstabelecimento, String descricao,float preco, String nome, String foto) throws Exception{
        Comida comida = new Comida(idEstabelecimento, descricao, preco, nome, foto);
        return dao.salvar(comida);
    }
    
    public List<Comida> buscaPorEstabelecimento(int id) throws SQLException, ClassNotFoundException{
        return dao.buscarPorEstabelecimento(id);
    }
    
    public boolean Deletar (int idComida) throws Exception{
        return dao.deletar(idComida);
    }

}
