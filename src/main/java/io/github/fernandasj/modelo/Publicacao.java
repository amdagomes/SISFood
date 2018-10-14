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
    private String datahora;
    private int idEstabelecimento;
    public  Publicacao(){
    }

    public Publicacao(int idPublicacao, int idUsuario, String texto, String datahora) {
        this.idPublicacao = idPublicacao;
        this.idUsuario = idUsuario;
        this.texto = texto;
       
        this.datahora=datahora;
    }

    public Publicacao(int idPublicacao, int idUsuario, String texto,  String datahora, int idEstabelecimento) {
        this.idPublicacao = idPublicacao;
        this.idUsuario = idUsuario;
        this.texto = texto;
      
        this.datahora = datahora;
        this.idEstabelecimento = idEstabelecimento;
    }

    public Publicacao(int idPublicacao, String texto, int idEstabelecimento,String datahora) {
        this.idPublicacao = idPublicacao;
        
        this.texto = texto;
       
        this.datahora = datahora;
        this.idEstabelecimento = idEstabelecimento;
    }
public Publicacao(int idUsuario){
    this.idUsuario=idUsuario;
  
}

  
 public Publicacao( int idUsuario, String texto, String foto, String datahora) {
        this.idUsuario = idUsuario;
        this.texto = texto;
       
         this.datahora=datahora;
    }
  public Publicacao(  String texto, int idEstabelecimento,String foto, String datahora) {
        this.idEstabelecimento=idEstabelecimento;
        this.texto = texto;
        
         this.datahora=datahora;
    }


    public Publicacao(int idUsuario, String texto) {
        this.idUsuario = idUsuario;
        this.texto = texto;
    }
     
    public Publicacao ( int idUsuario, String texto, String foto) {
        this.idUsuario = idUsuario;
        this.texto = texto;
       
    }

    public Publicacao(String texto, int idEstabelecimento) {
        this.texto=texto;
        this.idEstabelecimento=idEstabelecimento;
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

   

    public  String getDatahora() {
        return datahora;
    }

    public void setDatahora( String datahora) {
        this.datahora = datahora;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idPublicacao;
        hash = 67 * hash + this.idUsuario;
        hash = 67 * hash + Objects.hashCode(this.texto);
       
        hash = 67 * hash + Objects.hashCode(this.datahora);
        hash = 67 * hash + this.idEstabelecimento;
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
        if (this.idEstabelecimento != other.idEstabelecimento) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
       
        if (!Objects.equals(this.datahora, other.datahora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "idPublicacao=" + idPublicacao + ", idUsuario=" + idUsuario + ", "
                + "texto=" + texto +  ", datahora=" + datahora + ", idEstabelecimento="
                + idEstabelecimento + '}';
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

      

