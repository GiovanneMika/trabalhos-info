/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import poligo.Calculadora;

/**
 *
 * @author pcnov
 */
public class Console {
    public static void main(String[] args) {
        Calculadora calc=new Calculadora();
        calc.setBase(10);
        calc.setAltura(90.5);
        calc.aqua();
        System.out.println("A área do quadrado é "+calc.getResultado());
        calc.atri();
        System.out.println("A área do triângulo é "+calc.getResultado());
        calc.pqua();
        System.out.println("O perímetro do quadrado é "+calc.getResultado());
    }
    
}
