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
public class Garcom implements Serializable {

    @Id
    private int id = 0;
    private int idGarcom = 2;

}
