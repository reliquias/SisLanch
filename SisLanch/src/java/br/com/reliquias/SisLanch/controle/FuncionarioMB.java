/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.dao.FuncionarioDAO;
import br.com.reliquias.SisLanch.modelo.Funcionario;
import br.com.reliquias.SisLanch.util.JsfUtil;
import br.com.reliquias.SisLanch.util.RelatorioUtil;
import br.com.reliquias.SisLanch.util.UtilException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.StreamedContent;


/**
 *
 * @author Reliquias
 */

@ManagedBean
@SessionScoped
public class FuncionarioMB implements Serializable{

    private Funcionario funcionario = new Funcionario();
    private DataModel itens = null;
    @EJB
    private FuncionarioDAO funcionarioDAO;
    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;

    public FuncionarioMB() {
    }

    public void Cadastrar(ActionEvent actionEvent){
        try {
            funcionarioDAO.criar(funcionario);
            funcionario = new Funcionario();
            } catch (Exception e) {
            }
    }

    public void AdicionaOuAtualiza(ActionEvent actionEvent){
        if(funcionario.getId() == null){
             funcionarioDAO.criar(funcionario);
        }else {
            funcionario.getId();
            funcionarioDAO.editar(funcionario);
        }
    }

    public void Editar(ActionEvent actionEvent){
        funcionario.getId();
        try {
             funcionarioDAO.editar(funcionario);
            } catch (Exception e) {
            }
    }

    public void Remover(ActionEvent actionEvent){
        funcionarioDAO.remover(funcionario);
//        return "ListFuncionario";
    }

    public void preparaCadastrar(ActionEvent actionEvent) {
        funcionario = new Funcionario();
    }

    public void preparaEditar(ActionEvent actionEvent) {
//        return "CadastrarFuncionario";
    }

    public List<Funcionario> getListarTodos() {
        return funcionarioDAO.encontrarTodos();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public DataModel getItens() {
        return itens;
    }

    public void setItens(DataModel itens) {
        this.itens = itens;
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(funcionarioDAO.encontrarTodos(), true);
    }

    public StreamedContent getArquivoRetorno() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();

        String nomeRelatorioJasper = "RelCidades";
        String nomeRelatorioSaida = nomeRelatorioJasper;
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        HashMap paramentrosRelatorio = new HashMap();
        String nada = "123";
        paramentrosRelatorio.put("p_nada", nada);

        try {
            this.arquivoRetorno = relatorioUtil.geraRelatorio(paramentrosRelatorio, nomeRelatorioJasper, nomeRelatorioSaida, this.tipoRelatorio);
        } catch (UtilException e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
        return this.arquivoRetorno;
    }

    public void setArquivoRetorno(StreamedContent arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }

    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
}
