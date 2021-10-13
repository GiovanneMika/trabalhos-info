package bean;

import javax.faces.bean.ManagedBean;
import vo.Cadastro;

@ManagedBean
public class CadastroBean {
    private Cadastro cadastro = new Cadastro();

    /**
     * @return the cadastro
     */
    public Cadastro getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
}
