/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;


import io.github.fernandasj.dao.AvaliarComidaDao;
import io.github.fernandasj.dao.ComidaDao;
import io.github.fernandasj.modelo.AvaliarComida;
import io.github.fernandasj.modelo.Comida;
import io.github.fernandasj.connection.DaoFactory;
import io.github.fernandasj.connection.DaoFactoryIF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class GerenciadorComida {
    private DaoFactoryIF fabrica = null;
    private ComidaDao dao = null;
    private AvaliarComidaDao daoAvalia = null;
    
    public GerenciadorComida() throws SQLException, ClassNotFoundException{
        fabrica = DaoFactory.createFactory();
        dao = fabrica.criaComidaDao();
        daoAvalia = fabrica.criaAvaliarComidaDao();
    }
    
    public boolean Adicionar (int idEstabelecimento, String descricao,float preco, String nome, String foto) throws Exception{
        Comida comida = new Comida(idEstabelecimento, descricao, preco, nome, foto);
        return dao.salvar(comida);
    }
    
    public List<Comida> buscaPorEstabelecimento(int id) throws SQLException, ClassNotFoundException{
        return dao.buscarPorEstabelecimento(id);
    }
    
    public Comida buscaComida(int id) throws SQLException{
        return dao.buscar(id);
    }
    
    public boolean Deletar (int idComida) throws Exception{
        return dao.deletar(idComida);
    }
  
    public boolean atualizar (Comida comida) throws SQLException{
        return dao.atualizar(comida);
    }
    
    public boolean avaliarComida(AvaliarComida avaliacao) throws Exception{
        return daoAvalia.salvar(avaliacao);
    }
    
    public List<AvaliarComida> listAvaliacoesComida(int idComida) throws SQLException{
        return daoAvalia.listAvaliacoes(idComida);
    }
    
}
