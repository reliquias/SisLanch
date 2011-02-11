/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reliquias.SisLanch.controle;

import br.com.reliquias.SisLanch.enumeradores.Estado;
import br.com.reliquias.SisLanch.dao.CidadeDAO;
import br.com.reliquias.SisLanch.util.JsfUtil;
import br.com.reliquias.SisLanch.modelo.Cidade;
import br.com.reliquias.SisLanch.util.RelatorioUtil;
import br.com.reliquias.SisLanch.util.UtilException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Windows Vista
 */
@ManagedBean
@SessionScoped
public class CidadeMB implements Serializable{

    private Cidade cidade =  new Cidade();
    private DataModel items = null;
    @EJB
    private CidadeDAO cidadeDAO;
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;
   
    
    public CidadeMB() {
    }

   public void adicionaOuAtualiza(ActionEvent actionEvent) {
        if (cidade.getId() == null) {
            try {
                cidadeDAO.criar(cidade);
                cidade = new Cidade();
            } catch (Exception e) {
            }
        } else {
            try {
                cidadeDAO.editar(cidade);
            } catch (Exception e) {
            }
        }
    }

    public void remover(ActionEvent actionEvent) {
        cidadeDAO.remover(cidade);
    }

    public void preparaCadastrar(ActionEvent actionEvent) {
        cidade = new Cidade();
    }

    public void preparaEditar(ActionEvent actionEvent) {
    }

    public List<Cidade> getListarTodas() {
        return cidadeDAO.encontrarTodos();
    }

    public Estado[] getEstados() {
        return Estado.values();
    }

    public Cidade getCidade() {
        return cidade;
    }

   public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(cidadeDAO.encontrarTodos(), true);
    }

    public CidadeDAO getCidadeDAO() {
        return cidadeDAO;
    }

    public void setCidadeDAO(CidadeDAO cidadeDAO) {
        this.cidadeDAO = cidadeDAO;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public StreamedContent getArquivoRetorno() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();

        String nomeRelatorioJasper = "RelCidades";
        String nomeRelatorioSaida = nomeRelatorioJasper;
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        HashMap paramentrosRelatorio = new HashMap();

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
