/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 2info2021
 */
public class Raquete {

    private int altura = 150;
    private int largura = 100;
    private Image[] imagem = new Image[11];
    private double x;
    private double y;
    private double dy = 0;

    public Rectangle getLimites() {
        return new Rectangle((int) x, (int) y, largura, altura);
    }

    public Raquete(double x, double y) {
        this.x = x;
        this.y = y;
        imagem[0] = new ImageIcon(getClass().getResource("/imagens/balrug.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[1] = new ImageIcon(getClass().getResource("/imagens/balrug4.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[2] = new ImageIcon(getClass().getResource("/imagens/balrug3.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[3] = new ImageIcon(getClass().getResource("/imagens/balrug5.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[4] = new ImageIcon(getClass().getResource("/imagens/balrugcom.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[5] = new ImageIcon(getClass().getResource("/imagens/balrugcom2.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[6] = new ImageIcon(getClass().getResource("/imagens/balrugwin.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[7] = new ImageIcon(getClass().getResource("/imagens/balrugwin2.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[8] = new ImageIcon(getClass().getResource("/imagens/balruglose.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[9] = new ImageIcon(getClass().getResource("/imagens/balruglose2.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
        imagem[10] = new ImageIcon(getClass().getResource("/imagens/balrugsocoesq.gif")).getImage().getScaledInstance(getLargura(),getAltura(), 1);
    }
    

    public void mexer() {
        setY(getY() + getDy());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the imagem
     */
    public Image[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(Image[] imagem) {
        this.imagem = imagem;
    }
}
