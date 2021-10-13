/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import poligo.Calculadora;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author 2info2021
 */
@ManagedBean
public class CalculadoraBean {
    private Calculadora calc=new Calculadora();
    public String aqua(){
        getCalc().aqua();
        return null;
    }
    public String pqua(){
        getCalc().pqua();
        return null;
    }
    public String atri(){
        getCalc().atri();
        return null;
    }

    /**
     * @return the calc
     */
    public Calculadora getCalc() {
        return calc;
    }

    /**
     * @param calc the calc to set
     */
    public void setCalc(Calculadora calc) {
        this.calc = calc;
    }
    
}
