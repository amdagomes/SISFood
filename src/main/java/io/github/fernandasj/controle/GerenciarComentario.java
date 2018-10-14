/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.controle;

import io.github.fernandasj.dao.ComentarioDao;
import io.github.fernandasj.dao.ComentarioEstabelecimentoDao;
import io.github.fernandasj.modelo.Comentario;
import io.github.fernandasj.connection.DaoFactoryIF;
import java.sql.SQLException;

/**
 *
 * @author Cliente
 */
public class GerenciarComentario {
     private DaoFactoryIF fabrica = null;
    private ComentarioDao Dao = new  ComentarioDao();
    private ComentarioEstabelecimentoDao dao = new ComentarioEstabelecimentoDao();
    
    
    public boolean adiciona(String comentario,int comentarista,int idPublicacao) throws Exception{
        Comentario c= new Comentario( comentarista,comentario,idPublicacao);
        return Dao.salvar(c);
    }
    
    public Comentario Busca(int idComentario) throws SQLException{
        return Dao.buscar(idComentario);
    }
    public boolean adicionaComentario(String comentario,int comentarista,int idPublicacao) throws Exception{
        Comentario c= new Comentario( comentarista,comentario,idPublicacao);
        return dao.salvar(c);
    }
    
}
