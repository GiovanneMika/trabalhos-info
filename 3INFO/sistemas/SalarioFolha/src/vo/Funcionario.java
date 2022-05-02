/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
public class Funcionario {

    @Id
    @GeneratedValue
    private int id = 0;
    private String nome;
    private boolean vt;
    private int dep14;
    private int depir;
    private double salario;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the vt
     */
    public boolean isVt() {
        return vt;
    }

    /**
     * @param vt the vt to set
     */
    public void setVt(boolean vt) {
        this.vt = vt;
    }

    /**
     * @return the dep14
     */
    public int getDep14() {
        return dep14;
    }

    /**
     * @param dep14 the dep14 to set
     */
    public void setDep14(int dep14) {
        this.dep14 = dep14;
    }

    /**
     * @return the depir
     */
    public int getDepir() {
        return depir;
    }

    /**
     * @param depir the depir to set
     */
    public void setDepir(int depir) {
        this.depir = depir;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
