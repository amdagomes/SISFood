/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class Comida {
    private int idComida;
    private String descricao;
    private double nota;
    private double preco;
    private String nome;
    private String foto;
    private int idEstabelecimento;
   
    public Comida(){}

    public Comida(int idComida, String descricao, double nota, double preco, String nome, int idEstabelecimento, String foto) {
        this.idComida = idComida;
        this.descricao = descricao;
        this.nota = nota;
        this.preco = preco;
        this.nome = nome;
        this.idEstabelecimento = idEstabelecimento;
        this.foto = foto;
       
    }

    public Comida(int idEstabelecimento,String descricao, double preco, String nome, String foto) {
        this.idEstabelecimento = idEstabelecimento;
        this.descricao = descricao;
        this.preco = preco;
        this.nome = nome;
        this.foto = foto;
    }

   public Comida(String descricao, double nota, double preco, String nome, String foto) {
        this.descricao = descricao;
        this.nota = nota;
        this.preco = preco;
        this.nome = nome;
        this.foto = foto;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idComida;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.nota) ^ (Double.doubleToLongBits(this.nota) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.foto);
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
        final Comida other = (Comida) obj;
        if (this.idComida != other.idComida) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.idEstabelecimento != other.idEstabelecimento) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", descricao=" + descricao + ", nota=" + nota + ", preco=" 
                + preco + ", nome=" + nome + ", foto=" + foto + ", idEstabelecimento=" + idEstabelecimento + '}';
    }

}
