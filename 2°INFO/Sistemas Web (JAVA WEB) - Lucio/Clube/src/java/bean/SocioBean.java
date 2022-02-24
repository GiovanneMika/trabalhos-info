package bean;

import bd.BdSocio;
import bd.BdDependente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Socio;
import vo.Dependente;

@ManagedBean
@SessionScoped
public class SocioBean {

    private Dependente dependente;
    private final BdDependente bdd = new BdDependente();
    private DataModel<Dependente> listad;
    private Socio socio;
    private final BdSocio bds = new BdSocio();
    private DataModel<Socio> listas;
    private Integer SocioAtual = 0;

    public SocioBean() {
        atualizaListas();
    }

    public String salvas() {
        bds.salva(socio);
        atualizaListas();
        return "index";
    }

    public final void atualizaListas() {
        setListas((DataModel<Socio>) new ListDataModel(bds.pesquisa("")));
    }

    public String excluis() {
        socio = getListas().getRowData();
        bds.exclui(socio.getId());
        atualizaListas();
        return "";
    }

    public String novos() {
        socio = new Socio();
        return "socio";
    }

    public String editas() {
        socio = getListas().getRowData();
        return "socio";
    }

    public String salvad() {
        bdd.salva(dependente);
        refreshListad();
        return "indexs";
    }

    public String atualizaListad() {
        socio = listas.getRowData();
        setSocioAtual((Integer) socio.getId());
        listad = new ListDataModel(bdd.pesquisa(getSocioAtual()));
        return "indexs";
    }

    public final void refreshListad() {
        listad = new ListDataModel(bdd.pesquisa(getSocioAtual()));
    }

    public String excluid() {
        dependente = getListad().getRowData();
        bdd.exclui(dependente.getId());
        refreshListad();
        return "";
    }

    public String novod() {
        dependente = new Dependente();
        dependente.setIdSocio(SocioAtual);
        return "dependente";
    }

    public String editad() {
        dependente = getListad().getRowData();
        return "dependente";
    }

    /**
     * @return the socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * @return the lista
     */
    public DataModel<Socio> getLista() {
        return getListas();
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Socio> lista) {
        this.setListas(lista);
    }

    /**
     * @return the dependente
     */
    public Dependente getDependente() {
        return dependente;
    }

    /**
     * @param dependente the dependente to set
     */
    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    /**
     * @return the listad
     */
    public DataModel<Dependente> getListad() {
        return listad;
    }

    /**
     * @param listad the listad to set
     */
    public void setListad(DataModel<Dependente> listad) {
        this.listad = listad;
    }

    /**
     * @return the listas
     */
    public DataModel<Socio> getListas() {
        return listas;
    }

    /**
     * @param listas the listas to set
     */
    public void setListas(DataModel<Socio> listas) {
        this.listas = listas;
    }

    /**
     * @return the SocioAtual
     */
    public Integer getSocioAtual() {
        return SocioAtual;
    }

    /**
     * @param SocioAtual the SocioAtual to set
     */
    public void setSocioAtual(Integer SocioAtual) {
        this.SocioAtual = SocioAtual;
    }
}
