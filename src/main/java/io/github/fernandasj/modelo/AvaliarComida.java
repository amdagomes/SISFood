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
    private int estabelecimento;
    private float nota;
    private String comentario;
    private int comida;

    public AvaliarComida(int consumidor, int estabelecimento, float nota, String comentario, int comida) {
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
        this.nota = nota;
        this.comentario = comentario;
        this.comida = comida;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public int getConsumidor() {
        return consumidor;
    }

    public int getEstabelecimento() {
        return estabelecimento;
    }

    public float getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public int getComida() {
        return comida;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public void setConsumidor(int consumidor) {
        this.consumidor = consumidor;
    }

    public void setEstabelecimento(int estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idAvaliacao;
        hash = 73 * hash + this.consumidor;
        hash = 73 * hash + this.estabelecimento;
        hash = 73 * hash + Float.floatToIntBits(this.nota);
        hash = 73 * hash + Objects.hashCode(this.comentario);
        hash = 73 * hash + this.comida;
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
        if (this.consumidor != other.consumidor) {
            return false;
        }
        if (this.estabelecimento != other.estabelecimento) {
            return false;
        }
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (this.comida != other.comida) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AvaliarComida{" + "idAvaliacao=" + idAvaliacao + ", consumidor=" + consumidor + ", estabelecimento=" + estabelecimento + ", nota=" + nota + ", comentario=" + comentario + ", comida=" + comida + '}';
    }
    
}
