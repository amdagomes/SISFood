/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.security.Timestamp;
import java.util.Objects;



/**
 *
 * @author Cliente
 */
public class Mensagem {
   private int idMensagem;
   private int remetente;
   private int destinatario;
   private String mensagem;
   private Timestamp horario;

    public Mensagem(int remetente, int destinatario, String mensagem, Timestamp horario) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.horario = horario;
    }

    public int getIdMensagem() {
        return idMensagem;
    }

    public int getRemetente() {
        return remetente;
    }

    public int getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Timestamp getHorario() {
        return horario;
    }

    
   

   

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idMensagem;
        hash = 17 * hash + this.remetente;
        hash = 17 * hash + this.destinatario;
        hash = 17 * hash + Objects.hashCode(this.mensagem);
        hash = 17 * hash + Objects.hashCode(this.horario);
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
        final Mensagem other = (Mensagem) obj;
        if (this.idMensagem != other.idMensagem) {
            return false;
        }
        if (this.remetente != other.remetente) {
            return false;
        }
        if (this.destinatario != other.destinatario) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "idMensagem=" + idMensagem + ", remetente=" + remetente + ", destinatario=" + destinatario + ", mensagem=" + mensagem + ", horario=" + horario + '}';
    }
   
}
