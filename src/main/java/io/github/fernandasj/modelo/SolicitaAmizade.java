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
public class SolicitaAmizade{
    private int idSolicitacao;
    private int remetente;
    private int destinatario;
    private String solicitacao;
    private Timestamp horario;
    
    public SolicitaAmizade(){
        
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
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

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
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
        hash = 67 * hash + this.idSolicitacao;
        hash = 67 * hash + this.remetente;
        hash = 67 * hash + this.destinatario;
        hash = 67 * hash + Objects.hashCode(this.solicitacao);
        hash = 67 * hash + Objects.hashCode(this.horario);
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
        final SolicitaAmizade other = (SolicitaAmizade) obj;
        if (this.idSolicitacao != other.idSolicitacao) {
            return false;
        }
        if (this.remetente != other.remetente) {
            return false;
        }
        if (this.destinatario != other.destinatario) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitaAmizade{" + "idSolicitacao=" + idSolicitacao + ", remetente=" + remetente + ", "
                + "destinatario=" + destinatario + ", solicitacao=" + solicitacao + ", horario=" + horario + '}';
    } 
    
}
