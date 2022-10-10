/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 2info2021
 *
 */
@Entity
public class Emprestimo {

    @Id
    private int id = 0;
    private int idAgricultor;
    private int idMaquina;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataEmprestimo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPrevista;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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

    /**
     * @return the idAgricultor
     */
    public int getIdAgricultor() {
        return idAgricultor;
    }

    /**
     * @param idAgricultor the idAgricultor to set
     */
    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }
}
