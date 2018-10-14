package io.github.fernandasj.modelo;

import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class SeguirPagina {
    
    private int id;
    private int seguidor;
    private int pagina;
    private String situacao;

    public SeguirPagina() {
    }

    public SeguirPagina(int id, int seguidor, int pagina, String situacao) {
        this.id = id;
        this.seguidor = seguidor;
        this.pagina = pagina;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(int seguidor) {
        this.seguidor = seguidor;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.seguidor;
        hash = 29 * hash + this.pagina;
        hash = 29 * hash + Objects.hashCode(this.situacao);
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
        final SeguirPagina other = (SeguirPagina) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.seguidor != other.seguidor) {
            return false;
        }
        if (this.pagina != other.pagina) {
            return false;
        }
        if (!Objects.equals(this.situacao, other.situacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SeguirPagina{" + "id=" + id + ", seguidor=" + seguidor + ", pagina=" + pagina + ", situacao=" + situacao + '}';
    }
    
}
