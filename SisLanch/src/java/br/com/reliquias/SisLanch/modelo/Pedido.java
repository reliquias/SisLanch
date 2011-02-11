/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.interfaces.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Reliquias
 */
@Entity
@Table(name="PEDIDO")
public class Pedido implements BaseEntity, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    private Restaurante restaurante;
    @Temporal(TemporalType.DATE)
    @Column(name="DATA_PEDIDO")
    private Date dataPedido;
    @Column(name="QUANTIDADE_TOTAL", scale=2)
    private BigDecimal quantidadeTotal;
    @Column(name="VALOR_TOTAL", scale=2)
    private BigDecimal valorTotal;
    @Column(name="VALOR_SALDO", scale=2)
    private BigDecimal valorSaldo;
    @Column(name="VALOR_TROCO", scale=2)
    private BigDecimal valorTroco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
    private Collection<FuncionarioPedido> funcionarioPedidoCollection = new ArrayList<FuncionarioPedido>();

    public Pedido() {
    }

    public Pedido(Collection<FuncionarioPedido> funcionarioPedidos) {
        this.funcionarioPedidoCollection = funcionarioPedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) throws ParseException {
        this.dataPedido = dataPedido;
    }

    public Collection<FuncionarioPedido> getFuncionarioPedidoCollection() {
        return funcionarioPedidoCollection;
    }

    public void setFuncionarioPedidoCollection(Collection<FuncionarioPedido> funcionarioPedidoCollection) {
        this.funcionarioPedidoCollection = funcionarioPedidoCollection;
    }

    public BigDecimal getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(BigDecimal valorSaldo) {
        if (funcionarioPedidoCollection.size() > 0) {
            valorSaldo = BigDecimal.ZERO;
            for (FuncionarioPedido funcionarioPedido : funcionarioPedidoCollection) {
                if (funcionarioPedido.getPedido().getId() == this.getId()) {
                    valorSaldo = valorSaldo.add(funcionarioPedido.getDinheiro());
                }
            }
        }
        this.valorSaldo = valorSaldo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        if (funcionarioPedidoCollection.size() > 0) {
            valorTotal = BigDecimal.ZERO;
            for (FuncionarioPedido funcionarioPedido : funcionarioPedidoCollection) {
                if (funcionarioPedido.getPedido().getId() == this.getId()) {
                    valorTotal = valorTotal.add(funcionarioPedido.getValor());
                    System.out.print(valorTotal);
                }
            }
        }
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(BigDecimal valorTroco) {
        if (funcionarioPedidoCollection.size() > 0) {
            valorTroco = BigDecimal.ZERO;
            valorTroco = valorSaldo.subtract(valorTotal);
        }
        this.valorTroco = valorTroco;
    }

    public BigDecimal getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(BigDecimal quantidadeTotal) {
        if (funcionarioPedidoCollection.size() > 0) {
            quantidadeTotal = BigDecimal.ZERO;
            for (FuncionarioPedido funcionarioPedido : funcionarioPedidoCollection) {
                if (funcionarioPedido.getPedido().getId() == this.getId()) {
                    quantidadeTotal = quantidadeTotal.add(funcionarioPedido.getQuantidade());
                    System.out.print(quantidadeTotal);
                }
            }
        }
        this.quantidadeTotal = quantidadeTotal;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.restaurante != other.restaurante && (this.restaurante == null || !this.restaurante.equals(other.restaurante))) {
            return false;
        }
        if (this.dataPedido != other.dataPedido && (this.dataPedido == null || !this.dataPedido.equals(other.dataPedido))) {
            return false;
        }
        if (this.valorTotal != other.valorTotal && (this.valorTotal == null || !this.valorTotal.equals(other.valorTotal))) {
            return false;
        }
        if (this.valorSaldo != other.valorSaldo && (this.valorSaldo == null || !this.valorSaldo.equals(other.valorSaldo))) {
            return false;
        }
        if (this.valorTroco != other.valorTroco && (this.valorTroco == null || !this.valorTroco.equals(other.valorTroco))) {
            return false;
        }
        if (this.funcionarioPedidoCollection != other.funcionarioPedidoCollection && (this.funcionarioPedidoCollection == null || !this.funcionarioPedidoCollection.equals(other.funcionarioPedidoCollection))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.restaurante != null ? this.restaurante.hashCode() : 0);
        hash = 29 * hash + (this.dataPedido != null ? this.dataPedido.hashCode() : 0);
        hash = 29 * hash + (this.valorTotal != null ? this.valorTotal.hashCode() : 0);
        hash = 29 * hash + (this.valorSaldo != null ? this.valorSaldo.hashCode() : 0);
        hash = 29 * hash + (this.valorTroco != null ? this.valorTroco.hashCode() : 0);
        hash = 29 * hash + (this.funcionarioPedidoCollection != null ? this.funcionarioPedidoCollection.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + "dataPedido=" + dataPedido + '}';
    }

     @Override
    public Integer getIdi() {
        return new Integer(id);
    }

}
