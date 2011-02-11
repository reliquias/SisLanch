/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.dao;

import br.com.reliquias.SisLanch.modelo.Funcionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Reliquias
 */

@Stateless
public class FuncionarioDAO extends FacadeAbstrata<Funcionario>{

    @PersistenceContext(unitName="SisLanchPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
}