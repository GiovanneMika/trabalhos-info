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
import persistencia.ResponsavelDAO;
import vo.Responsavel;
import vo.Aluno;
import persistencia.AlunoDAO;

@ManagedBean
@SessionScoped

/**
 *
 * @author 2info2021
 */
public class TelaLocalizaBean implements Serializable {

    private DataModel<Responsavel> lista;
    ResponsavelDAO rd = new ResponsavelDAO();
    private Responsavel responsavel = new Responsavel();

    private DataModel<Aluno> listaaluno;
    AlunoDAO ad = new AlunoDAO();
    private Aluno aluno = new Aluno();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(rd.pesquisa());
        return "index";
    }

    public String atualizaListaAluno() {
        listaaluno = new ListDataModel(ad.pesquisa());
        return "indexaluno";
    }

    public DataModel<Responsavel> getLista() {
        atualizaLista();
        return lista;
    }

    public DataModel<Aluno> getListaAluno() {
        atualizaListaAluno();
        return listaaluno;
    }

    public Responsavel responsavelSelecionado() {
        Responsavel r = lista.getRowData();
        return r;
    }

    public Aluno alunoSelecionado() {
        Aluno a = listaaluno.getRowData();
        return a;
    }

    public String excluir() {
        Responsavel r = responsavelSelecionado();
        if (ad.pesquisaAluno(r.getId()).size() <= 0) {
            rd.exclui(r);
        }
        return "index";
    }

    public String excluirAluno() {
        Aluno a = alunoSelecionado();
        ad.exclui(a);
        return "indexaluno";
    }

    public String novo() {
        setResponsavel(new Responsavel());
        return "responsavel";
    }

    public String novoAluno() {
        setAluno(new Aluno());
        Responsavel r = responsavelSelecionado();
        aluno.setIdresponsavel(r.getId());
        return "aluno";
    }

    public String editar() {
        Responsavel r = responsavelSelecionado();
        setResponsavel(r);
        return "responsavel";
    }

    public String editarAluno() {
        Aluno a = alunoSelecionado();
        setAluno(a);
        return "aluno";
    }

    public String salva() {
        rd.salva(getResponsavel());
        return "index";
    }

    public String salvaAluno() {
        ad.salva(getAluno());
        return "indexaluno";
    }

    public String cancela() {
        return "index";
    }

    public String cancelaAluno() {
        return "indexaluno";
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
