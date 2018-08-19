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
public class avaliarEstabelecimento {
    private int idAvaliacao;
    private int consumidr;
    private int estabelecimento;
    private float nota;
    private String comentario;

    public avaliarEstabelecimento(int consumidr, int estabelecimento, float nota, String comentario) {
        this.consumidr = consumidr;
        this.estabelecimento = estabelecimento;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public int getConsumidr() {
        return consumidr;
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

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public void setConsumidr(int consumidr) {
        this.consumidr = consumidr;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idAvaliacao;
        hash = 67 * hash + this.consumidr;
        hash = 67 * hash + this.estabelecimento;
        hash = 67 * hash + Float.floatToIntBits(this.nota);
        hash = 67 * hash + Objects.hashCode(this.comentario);
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
        final avaliarEstabelecimento other = (avaliarEstabelecimento) obj;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        if (this.consumidr != other.consumidr) {
            return false;
        }
        if (this.estabelecimento != other.estabelecimento) {
            return false;
        }
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "avaliarEstabelecimento{" + "idAvaliacao=" + idAvaliacao + ", consumidr=" + consumidr + ", estabelecimento=" + estabelecimento + ", nota=" + nota + ", comentario=" + comentario + '}';
    }
    
}
