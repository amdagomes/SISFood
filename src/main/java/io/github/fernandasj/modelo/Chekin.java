/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Chekin implements Comparable<Chekin> {

    private int idchekin;
    private String datahora;
    private int consumidor;
    private int estabelecimento;

     public Chekin(int consumidor, int estabelecimento) {
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
    }
    public Chekin(int idchekin,  int consumidor, int estabelecimento,String datahora) {
        this.idchekin = idchekin;
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
        this.datahora = datahora;
    }

    public Chekin() {
    }

   
    public Chekin(int idchekin) {
        this.idchekin=idchekin;
    }
   

    public int getIdChekin() {
        return idchekin;
    }

    public void setChekin(int chekin) {
        this.idchekin = chekin;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public int getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(int consumidor) {
        this.consumidor = consumidor;
    }

    public int getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(int estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idchekin;
        hash = 71 * hash + Objects.hashCode(this.datahora);
        hash = 71 * hash + this.consumidor;
        hash = 71 * hash + this.estabelecimento;
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
        final Chekin other = (Chekin) obj;
        if (this.idchekin != other.idchekin) {
            return false;
        }
        if (this.consumidor != other.consumidor) {
            return false;
        }
        if (this.estabelecimento != other.estabelecimento) {
            return false;
        }
        if (!Objects.equals(this.datahora, other.datahora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chekin{" + "chekin=" + idchekin + ", datahora=" + datahora + ", consumidor=" + consumidor + ", estabelecimento="
                + estabelecimento + '}';
    }

    @Override
    public int compareTo(Chekin c) {
        if (this.idchekin > c.idchekin) {
            return -1;
        }
        if (this.idchekin < c.idchekin) {
            return 1;
        }
        return 0;
    }

}
