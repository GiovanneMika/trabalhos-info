/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import calculadora.Calculadora;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pcnov
 */
@ManagedBean
public class CalculadoraBean {
    private Calculadora calc=new Calculadora();
    public String soma(){
        getCalc().soma();
        return null;
    }
    public String subtrai(){
        getCalc().subtrai();
        return null;
    }
    public String multiplica(){
        getCalc().multiplica();
        return null;
    }
    public String divide(){
        getCalc().divide();
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
