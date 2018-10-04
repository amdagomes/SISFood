/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;


import io.github.fernandasj.dao.PublicacaoDao;
import io.github.fernandasj.modelo.Publicacao;
import io.github.fernandasj.repository.DaoFactoryIF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class GerenciarPublicacao {
    private DaoFactoryIF fabrica = null;
    private PublicacaoDao Dao = new PublicacaoDao();

     public boolean adiciona(int idUsuario,String texto) throws Exception{
        Publicacao p = new Publicacao(idUsuario,texto);
        return Dao.salvar(p);
    }
     public Publicacao BuscaPublicacao(int idPublicacao) throws SQLException{
        return Dao.buscar(idPublicacao);
    }
     public boolean Deletar (int idPublicacao) throws Exception{
        return Dao.deletar(idPublicacao);
    }
     
     }

