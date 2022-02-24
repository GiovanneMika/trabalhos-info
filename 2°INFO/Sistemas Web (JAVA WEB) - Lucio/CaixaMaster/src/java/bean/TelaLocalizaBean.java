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
import persistencia.MovimentoDAO;
import vo.Movimento;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Movimento> lista;
    MovimentoDAO pm = new MovimentoDAO();
    private Movimento movimento = new Movimento();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(pm.pesquisa());
        return "index";
    }

    public DataModel<Movimento> getLista() {
        atualizaLista();
        return lista;
    }

    public Movimento movimentoSelecionado() {
        Movimento m = lista.getRowData();
        return m;
    }

    public String novo() {
        movimento = new Movimento();
        return "movimento";
    }

    public String salva() {
        pm.salva(movimento);
        return "index";
    }

    public String cancela() {
        return "index";
    }
}
