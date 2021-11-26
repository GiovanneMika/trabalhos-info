/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

import javax.faces.model.ListDataModel;
import persistencia.AfazeresDAO;
import vo.Afazeres;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Afazeres> lista;
    AfazeresDAO pd = new AfazeresDAO();
    private Afazeres afazeres = new Afazeres();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(pd.pesquisa());
        return "index";
    }

    public DataModel<Afazeres> getLista() {
        atualizaLista();
        return lista;
    }

    public Afazeres afazeresSelecionado() {
        Afazeres a = lista.getRowData();
        return a;
    }

    public String excluir() {
        Afazeres a = afazeresSelecionado();
        pd.exclui(a);
        return "index";
    }

    public String novo() {
        setAfazeres(new Afazeres());
        return "afazeres";
    }

    public String editar() {
        Afazeres a = afazeresSelecionado();
        setAfazeres(a);
        return "afazeres";
    }

    public String salva() {
        pd.salva(getAfazeres());
        return "index";
    }

    public String cancela() {
        return "index";
    }

    /**
     * @return the afazeres
     */
    public Afazeres getAfazeres() {
        return afazeres;
    }

    /**
     * @param afazeres the afazeres to set
     */
    public void setAfazeres(Afazeres afazeres) {
        this.afazeres = afazeres;
    }
}
