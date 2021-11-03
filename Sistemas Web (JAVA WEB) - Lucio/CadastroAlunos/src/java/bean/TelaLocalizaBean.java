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
import persistencia.ResponsavelDAO;
import vo.Responsavel;
import vo.Aluno;


@ManagedBean
@RequestScoped

/**
 *
 * @author 2info2021
 */
public class TelaLocalizaBean implements Serializable {

    private DataModel<Responsavel> lista;
    ResponsavelDAO rd = new ResponsavelDAO();
    private Responsavel professor = new Responsavel();
    
    private DataModel<Aluno> listaaluno;
    ResponsavelDAO rd = new ResponsavelDAO();
    private Responsavel professor = new Responsavel();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(rd.pesquisa());
        return "index";
    }

    public DataModel<Responsavel> getLista() {
        atualizaLista();
        return lista;
    }

    public Responsavel professorSelecionado() {
        Responsavel r = lista.getRowData();
        return r;
    }

    public String excluir() {
        Responsavel r = professorSelecionado();
        rd.exclui(r);
        return "index";
    }

    public String novo() {
        professor = new Responsavel();
        return "professor";
    }

    public String editar() {
        Responsavel r = professorSelecionado();
        professor = r;
        return "professor";
    }

    public String salva() {
        rd.salva(professor);
        return "index";
    }

    public String cancela() {
        return "index";
    }
}
