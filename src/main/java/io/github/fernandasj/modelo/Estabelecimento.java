/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Cliente
 */
public class Estabelecimento {

    private int id;
    private int idUsuario;
    private String nome;
    private String telefone;
    private byte[] foto;
    private String cartegoria;
    private float nota;
    private String descricao;
    private String rua;
    private String estado;
    private String cidade;
    private String cep;
    private String dia;
    private Time horaAbre;
    private Time horaFecha;

    public Estabelecimento() {
    }

    public Estabelecimento(int id, int idUsuario, String nome, String telefone, byte[] foto, String cartegoria,
            float nota, String descricao, String rua, String estado, String cidade, String cep, String dia, Time horaAbre, Time horaFecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
        this.cartegoria = cartegoria;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.dia = dia;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
    }

    public Estabelecimento(int idUsuario, String nome, String telefone, byte[] foto, String cartegoria,
            float nota, String descricao, String rua, String estado, String cidade, String cep, String dia, Time horaAbre, Time horaFecha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
        this.cartegoria = cartegoria;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.dia = dia;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
    }

    public Estabelecimento(String nome, String telefone, byte[] foto, String cartegoria,
            float nota, String descricao, String rua, String estado, String cidade, String cep, String dia, Time horaAbre, Time horaFecha) {
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
        this.cartegoria = cartegoria;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.dia = dia;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int usuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCartegoria() {
        return cartegoria;
    }

    public void setCartegoria(String cartegoria) {
        this.cartegoria = cartegoria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHoraAbre() {
        return horaAbre;
    }

    public void setHoraAbre(Time horaAbre) {
        this.horaAbre = horaAbre;
    }

    public Time getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(Time horaFecha) {
        this.horaFecha = horaFecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.telefone);
        hash = 47 * hash + Arrays.hashCode(this.foto);
        hash = 47 * hash + Objects.hashCode(this.cartegoria);
        hash = 47 * hash + Float.floatToIntBits(this.nota);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.rua);
        hash = 47 * hash + Objects.hashCode(this.estado);
        hash = 47 * hash + Objects.hashCode(this.cidade);
        hash = 47 * hash + Objects.hashCode(this.cep);
        hash = 47 * hash + Objects.hashCode(this.dia);
        hash = 47 * hash + Objects.hashCode(this.horaAbre);
        hash = 47 * hash + Objects.hashCode(this.horaFecha);
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
        final Estabelecimento other = (Estabelecimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cartegoria, other.cartegoria)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Arrays.equals(this.foto, other.foto)) {
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
        return "Estabelecimento{" + "id=" + id + ", idUsuario=" + idUsuario + ", nome=" + nome + ", telefone=" + telefone
                + ", foto=" + foto + ", cartegoria=" + cartegoria + ", nota=" + nota + ", descricao=" + descricao
                + ", rua=" + rua + ", estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + ", "
                + "dia=" + dia + ", horaAbre=" + horaAbre + ", horaFecha=" + horaFecha + '}';
    }

}