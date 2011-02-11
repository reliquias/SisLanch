/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.modelo;

import br.com.reliquias.SisLanch.enumeradores.DiasSemana;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author java1
 */
//@Entity
//@Table(name="PRATO_DIA")
public class PratoDia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="DIA_SEMANA_ENUM")
    private DiasSemana diaSemana;
    @OneToMany(mappedBy = "pratoDia", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Collection<Prato> pratos;

    public DiasSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiasSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(Collection<Prato> pratos) {
        this.pratos = pratos;
    }
}