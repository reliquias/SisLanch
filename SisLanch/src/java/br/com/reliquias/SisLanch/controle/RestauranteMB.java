/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.dao.RestauranteDAO;
import br.com.reliquias.SisLanch.modelo.Restaurante;
import br.com.reliquias.SisLanch.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Windows Vista
 */
@ManagedBean
@SessionScoped
public class RestauranteMB implements Serializable{

    private Restaurante restaurante = new Restaurante();
    private DataModel items = null;
    @EJB
    private RestauranteDAO restauranteDAO;
    
    public RestauranteMB() {
    }

    public void adicionaOuAtualiza(ActionEvent actionEvent) {
        if (restaurante.getId() == null) {
            try {
                restauranteDAO.criar(restaurante);
                restaurante = new Restaurante();
            } catch (Exception e) {
            }
        } else {
            try {
                restauranteDAO.editar(restaurante);
            } catch (Exception e) {
            }
        }
    }

    public String adicionarOuAtualizar() {
        if (restaurante.getId() == null) {
            try {
                restauranteDAO.criar(restaurante);
                restaurante = new Restaurante();
            } catch (Exception e) {
            }
        } else {
            try {
                restauranteDAO.editar(restaurante);
            } catch (Exception e) {
            }
        }
        return "ListRestaurante";
    }

    public void Cadastrar(ActionEvent actionEvent) {
            try {
                restauranteDAO.criar(restaurante);
                restaurante = new Restaurante();
            } catch (Exception e) {
                
            }
        }

    public void Editar(ActionEvent actonEvent){
        try {
                restauranteDAO.editar(restaurante);
            } catch (Exception e) {
            }
        }

    public void remover() {
        restauranteDAO.remover(restaurante);
    }

//    public void preparaCadastrar(ActionEvent actionEvent) {
//        restaurante = new Restaurante();
//    }

    public String preparaCadastrar() {
        restaurante = new Restaurante();
        return "CadastrarRestaurante";
    }

    public String listarPratos(){
        return "/prato/ListPrato";
    }

    public String preparaEditar() {
        return "CadastrarRestaurante";
    }

    public List<Restaurante> getListarTodas() {
        return restauranteDAO.encontrarTodos();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante (Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(restauranteDAO.encontrarTodos(), true);
    }

}
