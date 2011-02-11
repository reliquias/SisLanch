/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.dao.PratoDAO;
import br.com.reliquias.SisLanch.enumeradores.DiasSemana;
import br.com.reliquias.SisLanch.modelo.Prato;
import br.com.reliquias.SisLanch.util.JsfUtil;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;


/**
 *
 * @author Reliquias
 */

@ManagedBean
@SessionScoped
public class PratoMB implements Serializable{

    private Prato prato = new Prato();
    private DataModel itens = null;
    @EJB
    private PratoDAO pratoDAO;
    private List<Prato> pratos = new ArrayList<Prato>();


   @ManagedProperty(value="#{restauranteMB}")
   private RestauranteMB restauranteMB;

   @ManagedProperty(value="#{pedidoMB}")
   private PedidoMB pedidoMB;

   private List<Prato> pratosRestaurantes;


    public PratoMB() {
    }

    public void Cadastrar(ActionEvent actionEvent){
        try {
            pratoDAO.criar(prato);
            prato = new Prato();
            } catch (Exception e) {
            }
    }

    public void AdicionaOuAtualiza(ActionEvent actionEvent){
        if(prato.getId() == null){
            if(prato.getRestaurante() == null){
                prato.setRestaurante(restauranteMB.getRestaurante());
            }
             pratoDAO.criar(prato);
//             prato = new Prato();
        }else {
            prato.getId();
            if(prato.getRestaurante() == null){
                prato.setRestaurante(restauranteMB.getRestaurante());
            }
            pratoDAO.editar(prato);
        }
    }

    public void Editar(ActionEvent actionEvent){
        prato.getId();
        try {
             pratoDAO.editar(prato);
            } catch (Exception e) {
            }
    }

    public void Remover(ActionEvent actionEvent){
        pratoDAO.remover(prato);
//        return "ListFuncionario";
    }

    public void preparaCadastrar(ActionEvent actionEvent) {
        prato = new Prato();
    }

    public void preparaEditar(ActionEvent actionEvent) {
//        return "CadastrarFuncionario";
    }

    public List<Prato> getListarTodos() {
        return pratoDAO.encontrarTodos();
    }

    public List<Prato> getPratosRestaurantes() throws ParseException{
       pratos = pratoDAO.encontrarTodos();
       pratosRestaurantes = new ArrayList<Prato>();
        for (Prato pratoRest : pratos) {
            if (pratoRest.getRestaurante().equals(restauranteMB.getRestaurante())){
                pratosRestaurantes.add(pratoRest);
            }
        }
        return pratosRestaurantes;
    }

    public List<Prato> getPratosPedido() throws ParseException{
       pratos = pratoDAO.encontrarTodos();
       pratosRestaurantes = new ArrayList<Prato>();
        for (Prato pratoRest : pratos) {
            if (pratoRest.getRestaurante().equals(pedidoMB.getPedido().getRestaurante())){
                pratosRestaurantes.add(pratoRest);
            }
        }
        return pratosRestaurantes;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato (Prato prato) {
        this.prato = prato;
    }

    public PratoDAO getPratoDAO() {
        return pratoDAO;
    }

    public void setPratoDAO(PratoDAO pratoDAO) {
        this.pratoDAO = pratoDAO;
    }

    public DataModel getItens() {
        return itens;
    }

    public void setItens(DataModel itens) {
        this.itens = itens;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public DiasSemana[] getDiasSemanas() {
        return DiasSemana.values();
    }

    public RestauranteMB getRestauranteMB() {
        return restauranteMB;
    }

    public void setRestauranteMB(RestauranteMB restauranteMB) {
        this.restauranteMB = restauranteMB;
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(pratoDAO.encontrarTodos(), true);
    }

    public PedidoMB getPedidoMB() {
        return pedidoMB;
    }

    public void setPedidoMB(PedidoMB pedidoMB) {
        this.pedidoMB = pedidoMB;
    }

    
}