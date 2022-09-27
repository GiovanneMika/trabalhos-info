/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 2info2021
 */
public class Emprestimo {
    @Id
    private int id=0;
    private int idAgronomo;
    private int idMaquina;
    private Date dataEmprestimo;
    private Date dataPrevista;
    private Date dataDevolucao;
    private boolean emprestado;
    

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
     * @return the idAgronomo
     */
    public int getIdAgronomo() {
        return idAgronomo;
    }

    /**
     * @param idAgronomo the idAgronomo to set
     */
    public void setIdAgronomo(int idAgronomo) {
        this.idAgronomo = idAgronomo;
    }

    /**
     * @return the idMaquina
     */
    public int getIdMaquina() {
        return idMaquina;
    }

    /**
     * @param idMaquina the idMaquina to set
     */
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    /**
     * @return the dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo the dataEmprestimo to set
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return the dataPrevista
     */
    public Date getDataPrevista() {
        return dataPrevista;
    }

    /**
     * @param dataPrevista the dataPrevista to set
     */
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the emprestado
     */
    public boolean isEmprestado() {
        return emprestado;
    }

    /**
     * @param emprestado the emprestado to set
     */
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
