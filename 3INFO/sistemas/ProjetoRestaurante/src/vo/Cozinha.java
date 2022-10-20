/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;

/**
 *
 * @author 2info2021
 */
@Entity
public class Cozinha implements Serializable {

    @Id
    private int id = 0;
    private int idCozinha = 2;
}
