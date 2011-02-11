/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.enumeradores.DiasSemana;
import br.com.reliquias.SisLanch.interfaces.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author java1
 */
@Entity
@Table(name="PRATO")
public class Prato implements BaseEntity, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="NUMERO", length=3)
    private Integer numero;
    @Column(name="NOME", nullable=false, length=50)
    private String nome;
    @Column(name="DESCRICAO")
    private String descricao;
    @Column(name="VALOR_UNITARIO", scale=2)
    private BigDecimal valorUnitario;
    @Enumerated(EnumType.STRING)
    @Column(name="DIA_SEMANA_ENUM")
    private DiasSemana diaSemana;
    
    @ManyToOne
    private Restaurante restaurante;

    public Prato() {
    }

    public Prato(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    public DiasSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiasSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prato other = (Prato) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.numero != other.numero && (this.numero == null || !this.numero.equals(other.numero))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.valorUnitario != other.valorUnitario && (this.valorUnitario == null || !this.valorUnitario.equals(other.valorUnitario))) {
            return false;
        }
        if (this.diaSemana != other.diaSemana) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 59 * hash + (this.valorUnitario != null ? this.valorUnitario.hashCode() : 0);
        hash = 59 * hash + (this.diaSemana != null ? this.diaSemana.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public Integer getIdi() {
        return new Integer(id);
    }

}
