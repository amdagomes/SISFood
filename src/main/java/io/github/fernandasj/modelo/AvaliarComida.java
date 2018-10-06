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
public class AvaliarComida {
    private int idAvaliacao;
    private int consumidor;
    private float nota;
    private String comentario;
    private int comida;

    public AvaliarComida(int consumidor, float nota, String comentario, int comida) {
        this.consumidor = consumidor;
        this.nota = nota;
        this.comentario = comentario;
        this.comida = comida;
    }

    public AvaliarComida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(int consumidor) {
        this.consumidor = consumidor;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idAvaliacao;
        hash = 97 * hash + this.consumidor;
        hash = 97 * hash + Float.floatToIntBits(this.nota);
        hash = 97 * hash + Objects.hashCode(this.comentario);
        hash = 97 * hash + this.comida;
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
        final AvaliarComida other = (AvaliarComida) obj;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AvaliarComida{" + "idAvaliacao=" + idAvaliacao + ", "
                + "consumidor=" + consumidor + ", nota=" + nota + ", "
                + "comentario=" + comentario + ", comida=" + comida + '}';
    }   
}
