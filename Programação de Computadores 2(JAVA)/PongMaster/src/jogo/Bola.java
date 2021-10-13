/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author 2info2021
 */
public class Bola {

    private int altura = 20;
    private int largura = 20;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/bola.gif")).getImage().getScaledInstance(getLargura(),
            getAltura(), 1);
    private double x;
    private double y;
    private double dx = 5;
    private double dy = new Random().nextDouble() * 5 - 2.5;

    public Bola(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getLimites() {
        return new Rectangle((int) x, (int) y, largura, altura);
    }

    public void mexer() {
        x += dx;
        y += dy;
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

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
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
}
