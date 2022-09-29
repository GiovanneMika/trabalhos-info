/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 2info2021
 */
@Entity
public class Maquina {

    @Id
    private int id = 0;
    private String nome;
    private String fabricadora;
    private String descricao;
    private String anofab;

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the anofab
     */
    public String getAnofab() {
        return anofab;
    }

    /**
     * @param anofab the anofab to set
     */
    public void setAnofab(String anofab) {
        this.anofab = anofab;
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

    /**
     * @return the fabricadora
     */
    public String getFabricadora() {
        return fabricadora;
    }

    /**
     * @param fabricadora the fabricadora to set
     */
    public void setFabricadora(String fabricadora) {
        this.fabricadora = fabricadora;
    }

}
