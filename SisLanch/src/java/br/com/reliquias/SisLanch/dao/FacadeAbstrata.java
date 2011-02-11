/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Windows Vista
 */
public abstract class FacadeAbstrata<T> {

    private Class<T> entityClass;

    public FacadeAbstrata(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void criar(T entity){
        getEntityManager().persist(entity);
    }

    public void editar(T entity){
        getEntityManager().merge(entity);
    }

    public void remover(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T procurar(Object id){
        return getEntityManager().find(entityClass, id);
    }

    public List<T> encontrarTodos(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> encontrarTodos(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
}
