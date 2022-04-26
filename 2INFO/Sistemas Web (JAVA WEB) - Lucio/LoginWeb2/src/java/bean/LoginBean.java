package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import vo.Login;

/**
 *
 * @author Tiago
 */

@ManagedBean
@SessionScoped
public class LoginBean {
    private Login login=new Login();
    private boolean loginok=false;
    public String loga(){
        if(getLogin().getUsuario().equals("Giovanne")&&getLogin().getSenha().equals("Stalingrado")){
            return "inicio";
        }else{
            return "erro";
        }
}
    public String desloga(){
        login= new Login();
        return "index";
    }
    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return the loginok
     */
    public boolean isLoginok() {
        return loginok;
    }

    /**
     * @param loginok the loginok to set
     */
    public void setLoginok(boolean loginok) {
        this.loginok = loginok;
    }

}
