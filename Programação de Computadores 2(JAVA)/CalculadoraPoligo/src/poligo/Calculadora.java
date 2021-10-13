/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligo;

/**
 *
 * @author pcnov
 */
public class Calculadora {
    private double base;
    private double altura;
    private double resultado;
    public void aqua(){
        resultado=base*altura;
    }
    public void pqua(){
        resultado=(2*base)+(2*altura);
    }
    public void atri(){
        resultado=(base*altura)/2;
    }
    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
