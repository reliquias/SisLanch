/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.dao.FuncionarioPedidoDAO;
import br.com.reliquias.SisLanch.modelo.FuncionarioPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;


/**
 *
 * @author Reliquias
 */

@ManagedBean
@RequestScoped
public class FuncionarioPedidoMB implements Serializable{

    private FuncionarioPedido funcionarioPedido = new FuncionarioPedido();
    private DataModel itens = null;
    @EJB
    private FuncionarioPedidoDAO funcionarioPedidoDAO;
    private List<FuncionarioPedido> funcionarioCollection = new ArrayList<FuncionarioPedido>();
    private List<FuncionarioPedido> funcionariosPedido;


   @ManagedProperty(value="#{pedidoMB}")
   private PedidoMB pedidoMB;

    public FuncionarioPedidoMB() {
    }

    public void Cadastrar(ActionEvent actionEvent){
        try {
            funcionarioPedidoDAO.criar(funcionarioPedido);
            funcionarioPedido = new FuncionarioPedido();
            } catch (Exception e) {
            }
    }

    public void AdicionaOuAtualiza(ActionEvent actionEvent){
        if(funcionarioPedido.getId() == null){
            if(funcionarioPedido.getPedido() == null){
                funcionarioPedido.setPedido(pedidoMB.getPedido());
            }
             funcionarioPedidoDAO.criar(funcionarioPedido);
        }else {
            funcionarioPedido.getId();
            if(funcionarioPedido.getPedido() == null){
                funcionarioPedido.setPedido(pedidoMB.getPedido());
            }
            funcionarioPedidoDAO.editar(funcionarioPedido);
        }
    }

    public String AdicionaOuAtualizar(){
        if(funcionarioPedido.getId() == null){
            if(funcionarioPedido.getPedido() == null){
                funcionarioPedido.setPedido(pedidoMB.getPedido());
            }
             funcionarioPedidoDAO.criar(funcionarioPedido);
        }else {
            funcionarioPedido.getId();
            if(funcionarioPedido.getPedido() == null){
                funcionarioPedido.setPedido(pedidoMB.getPedido());
            }
            funcionarioPedidoDAO.editar(funcionarioPedido);
        }
        return "/pedido/CadastrarPedido";
    }

    public void Editar(ActionEvent actionEvent){
        funcionarioPedido.getId();
        try {
             funcionarioPedidoDAO.editar(funcionarioPedido);
            } catch (Exception e) {
            }
    }

    public void Remover(){
        funcionarioPedidoDAO.remover(funcionarioPedido);
//        return "ListFuncionario";
    }

    public String preparaCadastrar() {
        funcionarioPedido = new FuncionarioPedido();
//        pedidoMB.adicionarOuAtualizar();
        return "/funcionarioPedido/CadastrarFuncionarioPedido";
    }

    public String preparaEditar() {
        return "/funcionarioPedido/CadastrarFuncionarioPedido";
    }

    public List<FuncionarioPedido> getFuncionariosPedido(){
       funcionarioCollection = funcionarioPedidoDAO.encontrarTodos();
       funcionariosPedido = new ArrayList<FuncionarioPedido>();
        for (FuncionarioPedido funcsPedido : funcionarioCollection) {
            if (funcsPedido.getPedido().getId() == pedidoMB.getPedido().getId()){
                funcionariosPedido.add(funcsPedido);
            }
        }
        return funcionariosPedido;
    }

    public DataModel getItens() {
        return itens;
    }

    public void setItens(DataModel itens) {
        this.itens = itens;
    }

    public FuncionarioPedido getFuncionarioPedido() {
        return funcionarioPedido;
    }

    public void setFuncionarioPedido(FuncionarioPedido funcionarioPedido) {
        this.funcionarioPedido = funcionarioPedido;
    }

    public FuncionarioPedidoDAO getFuncionarioPedidoDAO() {
        return funcionarioPedidoDAO;
    }

    public void setFuncionarioPedidoDAO(FuncionarioPedidoDAO funcionarioPedidoDAO) {
        this.funcionarioPedidoDAO = funcionarioPedidoDAO;
    }

    public PedidoMB getPedidoMB() {
        return pedidoMB;
    }

    public void setPedidoMB(PedidoMB pedidoMB) {
        this.pedidoMB = pedidoMB;
    }

    public List<FuncionarioPedido> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(List<FuncionarioPedido> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }
}