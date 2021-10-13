package bean;

import bd.BdAluno;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Aluno;

@ManagedBean
@SessionScoped
/**
 *
 * @author pcnov
 */
public class AlunoBean {

    private Aluno aluno; //ENCAPSULE aluno e lista ANTES DE PROSSEGUIR
    private BdAluno bda = new BdAluno();
    private DataModel<Aluno> lista; //ENCAPSULE aluno e lista ANTES DE PROSSEGUIR

    public AlunoBean() {
        atualizaLista();
    }

    public String salva() {
        getBda().salva(getAluno());
        atualizaLista();
        return "index";
    }

    public final void atualizaLista() {
        setLista((DataModel<Aluno>) new ListDataModel(getBda().pesquisa("")));
    }

    public String exclui() {
        setAluno(getLista().getRowData());
        getBda().exclui(getAluno().getCodigo());
        atualizaLista();
        return "";
    }

    public String novo() {
        setAluno(new Aluno());
        return "aluno";
    }

    public String edita() {
        setAluno(getLista().getRowData());
        return "aluno";
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

    /**
     * @return the bda
     */
    public BdAluno getBda() {
        return bda;
    }

    /**
     * @param bda the bda to set
     */
    public void setBda(BdAluno bda) {
        this.bda = bda;
    }

    /**
     * @return the lista
     */
    public DataModel<Aluno> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Aluno> lista) {
        this.lista = lista;
    }
}
