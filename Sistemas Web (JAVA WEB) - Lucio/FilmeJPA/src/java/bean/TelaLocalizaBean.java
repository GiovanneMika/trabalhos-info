/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import persistencia.FilmeDAO;
import vo.Filme;

@ManagedBean
@SessionScoped
/**
 *
 * @author pcnov
 */
public class TelaLocalizaBean implements Serializable {
    
    private DataModel<Filme> lista;
    FilmeDAO fd = new FilmeDAO();
    private Filme filme = new Filme();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(fd.pesquisa());
        return "index";
    }

    public DataModel<Filme> getLista() {
        atualizaLista();
        return lista;
    }

    public Filme filmeSelecionado() {
        Filme f = lista.getRowData();
        return f;
    }

    public String excluir() {
        Filme f = filmeSelecionado();
        fd.exclui(f);
        return "index";
    }

    public String novo() {
        setFilme(new Filme());
        return "filme";
    }

    public String editar() {
        Filme f = filmeSelecionado();
        setFilme(f);
        return "filme";
    }

    public String salva() {
        fd.salva(getFilme());
        return "index";
    }

    public String cancela() {
        return "index";
    }

    /**
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
