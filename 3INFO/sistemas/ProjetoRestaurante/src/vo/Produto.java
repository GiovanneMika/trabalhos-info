/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 *
 * @author 2info2021
 */
public class Produto implements Serializable {

    @Id
    private int id = 0;
    private String categoria;
    private String nome;
    private String descricao;
    private Double preco;
    
}
