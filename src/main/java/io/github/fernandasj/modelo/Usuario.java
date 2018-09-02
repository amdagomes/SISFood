package io.github.fernandasj.modelo;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class Usuario implements Serializable {

    private int id;
    private String tipoUsuario;
    private String email;
    private String senha;
    private String nome;
    private byte[] fotoPerfil;
    private InputStream foto;
    private String telefone;
    private String sexo;
    private String profissao;
    private LocalDate dataNascimento;
    private String CartegoriaEstabelecimento;
    private float nota;
    private String descricao;
    private String rua;
    private String numeroCasa;
    private String estado;
    private String cidade;
    private String cep;

    public Usuario(String tipoUsuario,String email, String senha, String nome, byte[] fotoPerfil, String telefone, String sexo, String profissao,
            LocalDate dataNascimento, String CartegoriaEstabelecimento, float nota, String descricao, String rua,String numeroCasa,
            String estado, String cidade, String cep) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.CartegoriaEstabelecimento = CartegoriaEstabelecimento;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.numeroCasa=numeroCasa;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Usuario() {
       
    }

    public Usuario(int id, String tipoUsuario, String email, String senha, String nome, byte[] fotoPerfil, InputStream foto, String telefone, String sexo, String profissao, LocalDate dataNascimento, String CartegoriaEstabelecimento, float nota, String descricao, String rua,String numeroCasa, String estado, String cidade, String cep) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
        this.foto = foto;
        this.telefone = telefone;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.CartegoriaEstabelecimento = CartegoriaEstabelecimento;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }
     public Usuario( String tipoUsuario, String email, String senha, String nome, String telefone, String sexo, String profissao, LocalDate dataNascimento, String CartegoriaEstabelecimento, float nota, String descricao, String rua, String estado, String cidade, String cep) {
        
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
        this.foto = foto;
        this.telefone = telefone;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.CartegoriaEstabelecimento = CartegoriaEstabelecimento;
        this.nota = nota;
        this.descricao = descricao;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    

    public Usuario(String nome, String email, String senha, String sexo, LocalDate dataNascimento, String rua, String numeroCasa, String cidade, String cep, String estado, byte[] fotoPerfil) {
       this.nome= nome;
       this.email=email;
       this.senha=senha;
       this.sexo = sexo;
       this.dataNascimento= dataNascimento;
       this.rua= rua;
       this.numeroCasa= numeroCasa;
       this.cidade=cidade;
       this.cep=cep;
       this.estado= estado;
       this.fotoPerfil = fotoPerfil;
    }

    public Usuario(String email,String senha){
        this.email=email;
        this.senha=senha;
    }
    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public InputStream getFoto() {
        return foto;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
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

    public String getCartegoriaEstabelecimento() {
        return CartegoriaEstabelecimento;
    }

    public void setCartegoriaEstabelecimento(String CartegoriaEstabelecimento) {
        this.CartegoriaEstabelecimento = CartegoriaEstabelecimento;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.tipoUsuario);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Arrays.hashCode(this.fotoPerfil);
        hash = 29 * hash + Objects.hashCode(this.foto);
        hash = 29 * hash + Objects.hashCode(this.telefone);
        hash = 29 * hash + Objects.hashCode(this.sexo);
        hash = 29 * hash + Objects.hashCode(this.profissao);
        hash = 29 * hash + Objects.hashCode(this.dataNascimento);
        hash = 29 * hash + Objects.hashCode(this.CartegoriaEstabelecimento);
        hash = 29 * hash + Float.floatToIntBits(this.nota);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.rua);
        hash = 29 * hash + Objects.hashCode(this.numeroCasa);
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.cidade);
        hash = 29 * hash + Objects.hashCode(this.cep);
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
        if (Float.floatToIntBits(this.nota) != Float.floatToIntBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.tipoUsuario, other.tipoUsuario)) {
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
        if (!Objects.equals(this.CartegoriaEstabelecimento, other.CartegoriaEstabelecimento)) {
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
        if (!Arrays.equals(this.fotoPerfil, other.fotoPerfil)) {
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
        return "Usuario{" + "id=" + id + ", tipoUsuario=" + tipoUsuario + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", fotoPerfil=" + fotoPerfil + ", foto=" + foto + ", telefone=" + telefone + ", sexo=" + sexo + ", profissao=" + profissao + ", dataNascimento=" + dataNascimento + ", CartegoriaEstabelecimento=" + CartegoriaEstabelecimento + ", nota=" + nota + ", descricao=" + descricao + ", rua=" + rua + ", numeroCasa=" + numeroCasa + ", estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + '}';
    }   
}
