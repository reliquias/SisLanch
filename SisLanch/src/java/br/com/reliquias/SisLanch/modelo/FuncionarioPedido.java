/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.interfaces.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Windows Vista
 */
@Entity
@Table(name="FUNCIONARIO_PEDIDO", uniqueConstraints={@UniqueConstraint(columnNames={"PEDIDO_ID, FUNCIONARIO_ID"})})
public class FuncionarioPedido implements BaseEntity, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="DINHEIRO", scale=2)
    private BigDecimal dinheiro;
    @Column(name="VALOR", scale=2)
    private BigDecimal valor;
    @Column(name="TROCO", scale=2)
    private BigDecimal troco;
    @Column(name="QUANTIDADE", scale=2)
    private BigDecimal quantidade;
    @JoinColumn(name = "PRATO_ID", referencedColumnName = "ID", nullable=true)
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
    private Prato prato;
    @JoinColumn(name="PEDIDO_ID", referencedColumnName="ID")
    @ManyToOne(fetch=FetchType.LAZY)
    private Pedido pedido;
    @JoinColumn(name="FUNCIONARIO_ID", referencedColumnName="ID_FUNCIONARIO")
    @ManyToOne(fetch=FetchType.LAZY)
    private Funcionario funcionario;

    public FuncionarioPedido(Pedido pedido, Funcionario funcionario, Prato prato) {
        this.pedido = pedido;
        this.funcionario = funcionario;
        this.prato = prato;
    }

    public FuncionarioPedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(BigDecimal dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Funcionario getFuncionario() {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Prato getPrato() {
        if (this.prato == null) {
            this.prato = new Prato();
        }
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        valor = BigDecimal.ZERO;
            if (prato.getValorUnitario().intValue() != 0) {
                valor = prato.getValorUnitario().multiply(quantidade);
            }
        this.valor = valor;
    }

    //Se o preço do prato for diferente de 0 o
    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        troco = BigDecimal.ZERO;
            if (prato.getValorUnitario().intValue() != 0) {
                troco = dinheiro.subtract(valor);
            } else {
                this.troco = dinheiro;
            }
        this.troco = troco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FuncionarioPedido other = (FuncionarioPedido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.dinheiro != other.dinheiro && (this.dinheiro == null || !this.dinheiro.equals(other.dinheiro))) {
            return false;
        }
        if (this.valor != other.valor && (this.valor == null || !this.valor.equals(other.valor))) {
            return false;
        }
        if (this.troco != other.troco && (this.troco == null || !this.troco.equals(other.troco))) {
            return false;
        }
        if (this.quantidade != other.quantidade && (this.quantidade == null || !this.quantidade.equals(other.quantidade))) {
            return false;
        }
        if (this.prato != other.prato && (this.prato == null || !this.prato.equals(other.prato))) {
            return false;
        }
        if (this.funcionario != other.funcionario && (this.funcionario == null || !this.funcionario.equals(other.funcionario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.dinheiro != null ? this.dinheiro.hashCode() : 0);
        hash = 79 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 79 * hash + (this.troco != null ? this.troco.hashCode() : 0);
        hash = 79 * hash + (this.quantidade != null ? this.quantidade.hashCode() : 0);
        hash = 79 * hash + (this.prato != null ? this.prato.hashCode() : 0);
        hash = 79 * hash + (this.funcionario != null ? this.funcionario.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FuncionarioPedido{" + "id=" + id + "prato=" + prato + "pedido=" + pedido + "funcionario=" + funcionario + '}';
    }

    @Override
    public Integer getIdi() {
        return new Integer(id);
    }

}
