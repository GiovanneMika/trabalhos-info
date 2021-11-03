package vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private String serie;
    private String turma;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datanasc;
    private String filiacao;
    private int idresponsavel;

    public Aluno() {
        this.codigo = 0;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
    }

    /**
     * @return the datanasc
     */
    public Date getDatanasc() {
        return datanasc;
    }

    /**
     * @param datanasc the datanasc to set
     */
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    /**
     * @return the filiacao
     */
    public String getFiliacao() {
        return filiacao;
    }

    /**
     * @param filiacao the filiacao to set
     */
    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    /**
     * @return the idresponsavel
     */
    public int getIdresponsavel() {
        return idresponsavel;
    }

    /**
     * @param idresponsavel the idresponsavel to set
     */
    public void setIdresponsavel(int idresponsavel) {
        this.idresponsavel = idresponsavel;
    }
}
