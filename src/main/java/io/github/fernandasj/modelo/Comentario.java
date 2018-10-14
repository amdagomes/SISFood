/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class Comentario {

    private int idComentario;
    private int idPublicacao;
    private int comentarista;
    private String comentario;
    private String datahora;
    

    public Comentario() {
    }

    public Comentario(int idComentario, int idPublicacao, int comentarista,  String comentario, String datahora) {
        this.idComentario = idComentario;
        this.idPublicacao = idPublicacao;
        this.comentarista = comentarista;
        this.comentario = comentario;
        this.datahora = datahora;
       
    }

    public Comentario(int comentarista, String comentario,  int idPublicacao) {
        this.idPublicacao = idPublicacao;
        this.comentarista = comentarista;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public int getComentarista() {
        return comentarista;
    }

    public void setComentarista(int comentarista) {
        this.comentarista = comentarista;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idComentario;
        hash = 37 * hash + this.idPublicacao;
        hash = 37 * hash + this.comentarista;
        hash = 37 * hash + Objects.hashCode(this.comentario);
        hash = 37 * hash + Objects.hashCode(this.datahora);
       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (this.idComentario != other.idComentario) {
            return false;
        }
        if (this.idPublicacao != other.idPublicacao) {
            return false;
        }
        if (this.comentarista != other.comentarista) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.datahora, other.datahora)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", idPublicacao=" + idPublicacao + ", comentarista=" + comentarista + ", comentario=" + comentario + ", datahora=" + datahora + '}';
    }

}
