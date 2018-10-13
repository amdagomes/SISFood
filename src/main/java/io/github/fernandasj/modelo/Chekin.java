/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;


public class Chekin {
   private int chekin;
   private Timestamp horario;
   private LocalDate dia;
   private int consumidor;
   private int estabelecimento;

    public Chekin(int chekin, Timestamp horario) {
        this.chekin = chekin;
        this.horario = horario;
    }

    public Chekin(){}
    
    public Chekin(Timestamp horario, LocalDate dia, int consumidor, int estabelecimento) {
        this.horario = horario;
        this.dia = dia;
        this.consumidor = consumidor;
        this.estabelecimento = estabelecimento;
    }

    public Chekin (Timestamp horario, LocalDate dia){
        this.horario = horario;
        this.dia = dia;
    }
    

    public int getChekin() {
        return chekin;
    }

    public Timestamp getHorario() {
        return horario;
    }

    public int getConsumidor() {
        return consumidor;
    }

    public int getEstabelecimento() {
        return estabelecimento;
    }

    public void setChekin(int chekin) {
        this.chekin = chekin;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }

    public LocalDate getDia() {
        return dia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.chekin;
        hash = 11 * hash + Objects.hashCode(this.horario);
        hash = 11 * hash + this.consumidor;
        hash = 11 * hash + this.estabelecimento;
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
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chekin{" + "chekin=" + chekin + ", horario=" + horario + ", consumidor=" + consumidor + ", estabelecimento=" + estabelecimento + '}';
    }
   
}
