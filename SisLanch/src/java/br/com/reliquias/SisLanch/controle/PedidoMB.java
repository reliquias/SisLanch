/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.dao.PedidoDAO;
import br.com.reliquias.SisLanch.modelo.Pedido;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author Windows Vista
 */
@ManagedBean
@SessionScoped
public class PedidoMB implements Serializable{

    /** Creates a new instance of PedidoMB */
    private Pedido pedido = new Pedido();
    private DataModel items = null;
    @EJB
    private PedidoDAO pedidoDAO;

//   @ManagedProperty(value="#{funcionarioPedidoMB}")
//   private FuncionarioPedidoMB funcionarioPedidoMB;
//   
    public PedidoMB() {
    }


    public String Listar(){
        return "ListPedido";
    }

    public void adicionaOuAtualiza(ActionEvent actionEvent) {
        if (pedido.getId() == null) {
            try {
                pedidoDAO.criar(pedido);
                pedido = new Pedido();
            } catch (Exception e) {
            }
        } else {
            try {
                pedidoDAO.editar(pedido);
            } catch (Exception e) {
            }
        }
    }

    public String adicionarOuAtualizar() {
        if (pedido.getId() == null) {
            try {
                pedidoDAO.criar(pedido);
                pedido = new Pedido();
            } catch (Exception e) {
            }
        } else {
            try {
                pedidoDAO.editar(pedido);
            } catch (Exception e) {
            }
        }
        return "ListPedido";
    }

    public void Cadastrar(ActionEvent actionEvent) {
            try {
                pedidoDAO.criar(pedido);
                pedido = new Pedido();
            } catch (Exception e) {

            }
        }

    public void Editar(ActionEvent actonEvent){
        try {
                pedidoDAO.editar(pedido);
            } catch (Exception e) {
            }
        }

    public void remover() {
        pedidoDAO.remover(pedido);
    }

//    public void preparaCadastrar(ActionEvent actionEvent) {
//        restaurante = new Restaurante();
//    }

    public String preparaCadastrar() {
        pedido = new Pedido();
        return "CadastrarPedido";
    }

    public String listarPratos(){
        return "/funcionarioPedido/CadastrarFuncionarioPedido";
    }

    public String preparaEditar() {
        return "CadastrarPedido";
    }

    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public List<Pedido> getListarTodos() {
        return pedidoDAO.encontrarTodos();
    }

//    public FuncionarioPedidoMB getFuncionarioPedidoMB() {
//        return funcionarioPedidoMB;
//    }
//
//    public void setFuncionarioPedidoMB(FuncionarioPedidoMB funcionarioPedidoMB) {
//        this.funcionarioPedidoMB = funcionarioPedidoMB;
//    }
    
}
