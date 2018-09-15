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
public class Comida {
    private int idComida;
    private String descricao;
    private float nota;
    private float preco;
    private String nome;
    private String comentario;
   
    private int idEstabelecimento;
   
    
    public Comida(){}

    public Comida(int idComida, String descricao, float nota, float preco, String nome, int idEstabelecimento) {
        this.idComida = idComida;
        this.descricao = descricao;
        this.nota = nota;
        this.preco = preco;
        this.nome = nome;
        this.idEstabelecimento = idEstabelecimento;
       
    }

    public Comida( int idEstabelecimento,String descricao, float nota, float preco, String nome) {
        this.idEstabelecimento = idEstabelecimento;
        this.descricao = descricao;
        this.nota = nota;
        this.preco = preco;
        this.nome = nome;
        
    }

   public Comida(String descricao, float nota, float preco, String nome) {
        this.descricao = descricao;
        this.nota = nota;
        this.preco = preco;
        this.nome = nome;
        
    }


    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idComida;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Float.floatToIntBits(this.nota);
        hash = 53 * hash + Float.floatToIntBits(this.preco);
        hash = 53 * hash + Objects.hashCode(this.nome);
       
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
        final Comida other = (Comida) obj;
        if (this.idComida != other.idComida) {
            return false;
        }
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
      
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", descricao=" + descricao + ", nota=" + nota + ", preco=" + preco + ", "
                + "nome=" + nome + ", "
                + "idEstabelecimento=" + idEstabelecimento + '}';
    }

    

    
    
    
}
