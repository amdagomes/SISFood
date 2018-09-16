package io.github.fernandasj.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class Usuario implements Serializable {

    private int id;
    private String email;
    private String senha;
    private String nome;
    private String telefone;
    private String sexo;
    private String profissao;
    private LocalDate dataNascimento;
    private String descricao;
    private String rua;
    private String numeroCasa;
    private String estado;
    private String cidade;
    private String cep;
    private String foto;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String sexo, LocalDate dataNascimento, String rua, String numeroCasa, String estado, String cidade, String cep) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    } 
    
    public Usuario(int id, String foto) {
        this.id = id;
        this.foto = foto;
    }

    public Usuario(String email, String senha, String nome, String telefone, String sexo, String profissao, LocalDate dataNascimento, String CartegoriaEstabelecimento, String descricao, String rua, String numeroCasa, String estado, String cidade, String cep) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.descricao = descricao;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }
    
    public Usuario(int id, String email, String senha, String nome, String telefone, String sexo, String profissao, LocalDate dataNascimento, String descricao, String rua, String numeroCasa, String estado, String cidade, String cep, String foto) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.descricao = descricao;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.foto = foto;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.senha);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 89 * hash + Objects.hashCode(this.sexo);
        hash = 89 * hash + Objects.hashCode(this.profissao);
        hash = 89 * hash + Objects.hashCode(this.dataNascimento);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.rua);
        hash = 89 * hash + Objects.hashCode(this.numeroCasa);
        hash = 89 * hash + Objects.hashCode(this.estado);
        hash = 89 * hash + Objects.hashCode(this.cidade);
        hash = 89 * hash + Objects.hashCode(this.cep);
        hash = 89 * hash + Objects.hashCode(this.foto);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.profissao, other.profissao)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.numeroCasa, other.numeroCasa)) {
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
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", sexo=" + sexo + ", profissao=" + profissao + ", dataNascimento=" + dataNascimento + ", descricao=" + descricao + ", rua=" + rua + ", numeroCasa=" + numeroCasa + ", estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + ", foto=" + foto + '}';
    }
}
