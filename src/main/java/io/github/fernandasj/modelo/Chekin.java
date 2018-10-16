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

    private int chekin;
    private String datahora;
    private int consumidor;
    private int estabelecimento;

     public Chekin(int consumidor, int estabelecimento) {
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
    }
    public Chekin(int chekin, String datahora, int consumidor, int estabelecimento) {
        this.chekin = chekin;
        this.datahora = datahora;
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
    }

    public Chekin() {
    }

   
   

    public int getChekin() {
        return chekin;
    }

    public void setChekin(int chekin) {
        this.chekin = chekin;
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
        hash = 71 * hash + this.chekin;
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
        if (this.chekin != other.chekin) {
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
        return "Chekin{" + "chekin=" + chekin + ", datahora=" + datahora + ", consumidor=" + consumidor + ", estabelecimento="
                + estabelecimento + '}';
    }

    @Override
    public int compareTo(Chekin c) {
        if (this.chekin > c.chekin) {
            return -1;
        }
        if (this.chekin < c.chekin) {
            return 1;
        }
        return 0;
    }

}
