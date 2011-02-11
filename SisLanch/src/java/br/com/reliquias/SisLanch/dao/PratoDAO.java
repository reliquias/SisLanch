/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.dao;

import br.com.reliquias.SisLanch.modelo.Prato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Reliquias
 */

@Stateless
public class PratoDAO extends FacadeAbstrata<Prato>{

    @PersistenceContext(unitName="SisLanchPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PratoDAO() {
        super(Prato.class);
    }
}