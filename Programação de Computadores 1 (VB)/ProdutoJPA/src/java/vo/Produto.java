@Entity
package vo;

/**
 *
 * @author 2info2021
 */
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo = 0;
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    private String formacao;
    private String nome;

    public Professor(Integer codigo) {
        this.codigo = codigo;
    }

    public Professor() {
    }

}
