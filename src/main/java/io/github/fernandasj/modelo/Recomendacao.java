package io.github.fernandasj.modelo;

import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class Recomendacao {

    private int id;
    private int recomendacao;
    private int remetente;
    private int destinatario;
    private String comentario;

    public Recomendacao() {
    }

    public Recomendacao(int id, int recomendacao, int remetente, int destinatario, String comentario) {
        this.id = id;
        this.recomendacao = recomendacao;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(int recomendacao) {
        this.recomendacao = recomendacao;
    }

    public int getRemetente() {
        return remetente;
    }

    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }

    public int getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(int destinatario) {
        this.destinatario = destinatario;
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
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.recomendacao;
        hash = 67 * hash + this.remetente;
        hash = 67 * hash + this.destinatario;
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
        final Recomendacao other = (Recomendacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.recomendacao != other.recomendacao) {
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
        return "Recomendacao{" + "id=" + id + ", recomendacao=" + recomendacao 
                + ", remetente=" + remetente + ", destinatario=" + destinatario + ", comentario=" + comentario + '}';
    }

}
