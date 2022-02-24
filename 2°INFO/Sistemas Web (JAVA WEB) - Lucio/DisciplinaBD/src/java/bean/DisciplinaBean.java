package bean;

import bd.BdDisciplina;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Disciplina;

@ManagedBean
@SessionScoped
public class DisciplinaBean {

    private Disciplina disciplina;
    private BdDisciplina bdd = new BdDisciplina();
    private DataModel<Disciplina> lista;

    public DisciplinaBean() {
        atualizaLista();
    }
    public String salva() {
        getBdd().salva(disciplina);
        atualizaLista();
        return "index";
    }

    public final void atualizaLista() {
        setLista((DataModel<Disciplina>) new ListDataModel(getBdd().pesquisa("")));
    }

    public String exclui() {
        setDisciplina(getLista().getRowData());
        getBdd().exclui(getDisciplina().getCodigo());
        atualizaLista();
        return "";
    }

    public String novo() {
        setDisciplina(new Disciplina());
        return "disciplina";
    }

    public String edita() {
        setDisciplina(getLista().getRowData());
        return "disciplina";
    }
    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the lista
     */
    public DataModel<Disciplina> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Disciplina> lista) {
        this.lista = lista;
    }

    /**
     * @return the bdd
     */
    public BdDisciplina getBdd() {
        return bdd;
    }

    /**
     * @param bdd the bdd to set
     */
    public void setBdd(BdDisciplina bdd) {
        this.bdd = bdd;
    }
}
