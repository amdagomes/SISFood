/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class Publicacao implements Comparable <Publicacao>{

    private int idPublicacao;
    private int idUsuario;
    private String texto;
    private String foto;
    private String datahora;
    public  Publicacao(){
    }

    public Publicacao(int idPublicacao, int idUsuario, String texto, String foto, String datahora) {
        this.idPublicacao = idPublicacao;
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.foto = foto;
        this.datahora=datahora;
    }

   
public Publicacao(int idUsuario){
    this.idUsuario=idUsuario;
}
  
 public Publicacao( int idUsuario, String texto, String foto, String datahora) {
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.foto = foto;
         this.datahora=datahora;
    }

    public Publicacao(int idUsuario, String texto) {
        this.idUsuario = idUsuario;
        this.texto = texto;
    }

    public Publicacao ( int idUsuario, String texto, String foto) {
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.foto = foto;
    }

    public int getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public  String getDatahora() {
        return datahora;
    }

    public void setDatahora( String datahora) {
        this.datahora = datahora;
    }

  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idPublicacao;
        hash = 17 * hash + this.idUsuario;
        hash = 17 * hash + Objects.hashCode(this.texto);
        hash = 17 * hash + Objects.hashCode(this.foto);
        hash = 17 * hash + Objects.hashCode(this.datahora);
       
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
        final Publicacao other = (Publicacao) obj;
        if (this.idPublicacao != other.idPublicacao) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.datahora, other.datahora)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "idPublicacao=" + idPublicacao + ", idUsuario=" + idUsuario + ","
                + " texto=" + texto + ", foto=" + foto + ", data=" + datahora + '}';
    }

    @Override
    public int compareTo(Publicacao p) {
         if (this.idPublicacao > p.idPublicacao) {
            return -1;
        }
        if (this.idPublicacao < p.idPublicacao) {
            return 1;
        }
        return 0;
    }
    }

      

