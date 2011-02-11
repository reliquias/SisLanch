/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.enumeradores.Estado;
import br.com.reliquias.SisLanch.interfaces.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Reliquias
 */
@Entity
@Table(name = "CIDADE")
public class Cidade implements BaseEntity, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CIDADE", nullable=false)
    private Integer id;
    @Column(name="NOME", nullable=false, unique=true, length=50)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name="ESTADO_ENUM")
    private Estado estado;
    @OneToMany
    private Collection<Restaurante> restaurantes = new ArrayList<Restaurante>();

    public Cidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cidade() {
    }

    @Override
    public Integer getIdi() {
        return new Integer(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Collection<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.restaurantes != other.restaurantes && (this.restaurantes == null || !this.restaurantes.equals(other.restaurantes))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 29 * hash + (this.restaurantes != null ? this.restaurantes.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nome;
    }
}
