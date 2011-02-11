/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.dao;

import br.com.reliquias.SisLanch.modelo.FuncionarioPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows Vista
 */
@Stateless
public class FuncionarioPedidoDAO extends FacadeAbstrata<FuncionarioPedido>{
    @PersistenceContext(unitName="SisLanchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioPedidoDAO() {
        super(FuncionarioPedido.class);
    }
}
