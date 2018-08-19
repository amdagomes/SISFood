/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class horaFuncionamento {

    private int idFuncionamento;
    private int idUsuario;
    private String dia;
    private LocalDate horaAbre;
    private LocalDate horaFecha;

    public horaFuncionamento(String dia, LocalDate horaAbre, LocalDate horaFecha) {
        this.idUsuario = idUsuario;
        this.dia = dia;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalDate getHoraAbre() {
        return horaAbre;
    }

    public void setHoraAbre(LocalDate horaAbre) {
        this.horaAbre = horaAbre;
    }

    public LocalDate getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(LocalDate horaFecha) {
        this.horaFecha = horaFecha;
    }

    public int getIdFuncionamento() {
        return idFuncionamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idFuncionamento;
        hash = 17 * hash + this.idUsuario;
        hash = 17 * hash + Objects.hashCode(this.dia);
        hash = 17 * hash + Objects.hashCode(this.horaAbre);
        hash = 17 * hash + Objects.hashCode(this.horaFecha);
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
        final horaFuncionamento other = (horaFuncionamento) obj;
        if (this.idFuncionamento != other.idFuncionamento) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.horaAbre, other.horaAbre)) {
            return false;
        }
        if (!Objects.equals(this.horaFecha, other.horaFecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "horaFuncionamento{" + "idFuncionamento=" + idFuncionamento + ", idUsuario=" + idUsuario + ", dia=" + dia + ", horaAbre=" + horaAbre + ", horaFecha=" + horaFecha + '}';
    }

}
