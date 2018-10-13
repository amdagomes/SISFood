/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.AvaliarEstabelecimentoDao;
import io.github.fernandasj.dao.EstabelecimentoDao;
import io.github.fernandasj.modelo.Estabelecimento;
import io.github.fernandasj.modelo.avaliarEstabelecimento;
import io.github.fernandasj.repository.DaoFactory;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class GerenciadorEstabelecimento {

    private DaoFactoryIF fabrica = null;
    private EstabelecimentoDao estabelecimentoDao = null;
    private AvaliarEstabelecimentoDao avaliarDao = null;
    
    public GerenciadorEstabelecimento() throws SQLException, ClassNotFoundException{
        fabrica = DaoFactory.createFactory();
        estabelecimentoDao = fabrica.criaEstabelecimentoDao();
        avaliarDao = fabrica.criaAvaliaEstabelecimentoDao();
    }
    
    public boolean adicionar (int idUsuario,String nome, String telefone, String foto, String cartegoria, 
            String descricao, String rua,String estado, String cidade, String cep, 
            String dia, Time horaAbre, Time horaFecha) throws Exception{
        Estabelecimento estabelecimento = new Estabelecimento(idUsuario,nome,telefone,foto,cartegoria,descricao,rua,estado,cidade,cep,dia,horaAbre,horaFecha);
        return estabelecimentoDao.salvar(estabelecimento);    
    }
    
    public List meusEstabelecimentos(int id) throws SQLException{
        return estabelecimentoDao.listMeusEstabelecimentos(id);
    }
    
    public Estabelecimento buscarPorId(int id) throws SQLException{
        return estabelecimentoDao.buscarPorId(id);
    }
    
    public List listarPorNome(String nome) throws SQLException{
        return estabelecimentoDao.listarPorNome(nome);
    }
    
    public boolean atualizarPerfil(Estabelecimento obj) throws SQLException{
        return estabelecimentoDao.atualizar(obj);
    }
    
    public boolean deletar(int id) throws SQLException{
        return estabelecimentoDao.deletar(id);
    }
    
    public boolean avaliarEstabelecimento(avaliarEstabelecimento avaliacao) throws Exception{
        return avaliarDao.salvar(avaliacao);
    }

}
