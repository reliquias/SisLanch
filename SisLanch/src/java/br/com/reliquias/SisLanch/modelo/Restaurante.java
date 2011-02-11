/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.interfaces.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Reliquias
 */
@Entity
@Table(name="RESTAURANTE")
public class Restaurante implements BaseEntity, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="NOME", nullable=false, length=50, unique=true)
    private String nome;
    @Column(name="TELEFONE")
    private String fone;
    @Column(name="ENDERECO")
    private String endereco;
    @Column(name="NUMERO", length=10)
    private Integer numero;
    @Column(name="BAIRRO", length=50)
    private String bairro;
    @ManyToOne(fetch=FetchType.LAZY)
    private Cidade cidade;
    
    @OneToMany(mappedBy = "restaurante")
    private List<Prato> pratos;

    public Restaurante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Restaurante other = (Restaurante) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.fone == null) ? (other.fone != null) : !this.fone.equals(other.fone)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if (this.numero != other.numero && (this.numero == null || !this.numero.equals(other.numero))) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if (this.cidade != other.cidade && (this.cidade == null || !this.cidade.equals(other.cidade))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.fone != null ? this.fone.hashCode() : 0);
        hash = 41 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 41 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 41 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 41 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return nome;
    }

    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

     @Override
    public Integer getIdi() {
        return new Integer(id);
    }

}
