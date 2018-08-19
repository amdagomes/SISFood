/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class RecomendarComida {
    private int idRecomendacao;
    private int comida;
    private int remetente;
    private int destinatario;
    private String comentario;

    public RecomendarComida(int comida, int remetente, int destinatario, String comentario) {
        this.comida = comida;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.comentario = comentario;
    }

    public int getIdRecomendacao() {
        return idRecomendacao;
    }

    public void setIdRecomendacao(int idRecomendacao) {
        this.idRecomendacao = idRecomendacao;
    }

    public int getComida() {
        return comida;
    }

   
    public int getRemetente() {
        return remetente;
    }

   

    public int getDestinatario() {
        return destinatario;
    }

   
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idRecomendacao;
        hash = 83 * hash + this.comida;
        hash = 83 * hash + this.remetente;
        hash = 83 * hash + this.destinatario;
        hash = 83 * hash + Objects.hashCode(this.comentario);
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
        final RecomendarComida other = (RecomendarComida) obj;
        if (this.idRecomendacao != other.idRecomendacao) {
            return false;
        }
        if (this.comida != other.comida) {
            return false;
        }
        if (this.remetente != other.remetente) {
            return false;
        }
        if (this.destinatario != other.destinatario) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecomendarComida{" + "idRecomendacao=" + idRecomendacao + ", comida=" + comida + ", remetente=" + remetente + ", destinatario=" + destinatario + ", comentario=" + comentario + '}';
    }
    
    
}
