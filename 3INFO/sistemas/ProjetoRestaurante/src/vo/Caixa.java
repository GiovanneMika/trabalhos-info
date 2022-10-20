/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 2info2021
 */
@Entity
public class Caixa implements Serializable {
    
    @Id
    private int id = 0;
    private int idCaixa = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
