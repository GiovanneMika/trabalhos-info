/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

public class Desenho3D {

    double xwmax, xwmin, ywmax, ywmin, zwmax, zwmin, xvmax, xvmin, yvmax, yvmin, zvmax, zvmin;
    double xmax, ymax, xcoord, ycoord, zcoord;
    private double centrox;
    private double centroy;
    double xd, yd;
    Vector desenho = new Vector();

    public void setMundo(double x1, double y1, double z1, double x2, double y2, double z2) {
        xwmax = x2;
        ywmax = y2;
        zwmax = z2;
        xwmin = x1;
        ywmin = y1;
        zwmin = z1;
        centrox = (x1 + x2) / 2;
        centroy = (y1 + y2) / 2;

    }

    public void setViewPort(double x1, double y1, double x2, double y2) {
        xvmax = x2;
        yvmax = y2;
        xvmin = x1;
        yvmin = y1;
    }

    public void setDimension(Dimension dim) {
        xmax = dim.width;
        ymax = dim.height;
    }

    private void mapCoord(double x, double y, double z) {
        double zv;
        if (z < 0) {
            zv = 1 / (1 + Math.abs(z) / (zwmax - zwmin));
        } else {
            zv = (1 + Math.abs(z) / (zwmax - zwmin));
        }
        x = x / zv;
        y = y / zv;
        double xv = (((x - xwmin) * ((xvmax - xvmin) / (xwmax - xwmin))) + xvmin);
        double yv = (((y - ywmin) * ((yvmax - yvmin) / (ywmax - ywmin))) + yvmin);
        xd = xv * xmax;
        yd = yv * ymax;
    }

    private void linhaAte(Graphics g, double x, double y, double z) {
        double xi, yi;
        mapCoord(xcoord, ycoord, zcoord);
        xi = xd;
        yi = yd;
        mapCoord(x, y, z);
        g.drawLine((int) xi, (int) yi, (int) xd, (int) yd);
        xcoord = x;
        ycoord = y;
        zcoord = z;
    }

    private void movaPara(Graphics g, double x, double y, double z, boolean pu) {
        if (pu) {
            xcoord = x;
            ycoord = y;
            zcoord = z;
        } else {
            linhaAte(g, x, y, z);
        }
    }

    public void desenha(Graphics g) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            movaPara(g, p.getX(), p.getY(), p.getZ(), p.isPu());
        }
    }

    public void cubo() {
        desenho.addElement(new Ponto(11, 10, 1, true));
        desenho.addElement(new Ponto(11, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 1, false));
        desenho.addElement(new Ponto(12, 10, 1, false));
        desenho.addElement(new Ponto(11, 10, 1, false));
        desenho.addElement(new Ponto(11, 10, 2, false));
        desenho.addElement(new Ponto(11, 11, 2, false));
        desenho.addElement(new Ponto(12, 11, 2, false));
        desenho.addElement(new Ponto(12, 10, 2, false));
        desenho.addElement(new Ponto(11, 10, 2, false));
        desenho.addElement(new Ponto(11, 11, 2, false));
        desenho.addElement(new Ponto(11, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 2, false));
        desenho.addElement(new Ponto(12, 10, 2, false));
        desenho.addElement(new Ponto(12, 10, 1, false));
    }

    public void trabuco() {
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(12, 8, 1, false));
        desenho.addElement(new Ponto(14, 10, 1, false));
        desenho.addElement(new Ponto(10, 10, 1, false));
        desenho.addElement(new Ponto(12, 10, 3, false));
        desenho.addElement(new Ponto(14, 10, 1, false));
        desenho.addElement(new Ponto(12, 8, 1, true));
        desenho.addElement(new Ponto(12, 10, 3, false));
    }

    public void piramindeBaseTriangulular() {
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(12, 10, 3, false));
        desenho.addElement(new Ponto(14, 10, 1, false));
        desenho.addElement(new Ponto(10, 10, 1, false));
        desenho.addElement(new Ponto(12, 8, 2, false));
        desenho.addElement(new Ponto(14, 10, 1, false));
        desenho.addElement(new Ponto(12, 8, 2, true));
        desenho.addElement(new Ponto(12, 10, 3, false));
    }

    public void parede() {
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(10, 13, 1, false));
        desenho.addElement(new Ponto(11, 10, 1, true));
        desenho.addElement(new Ponto(11, 13, 1, false));
    }

    public void elementos3() {
        //Triângulo fora
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(10, 10, 1, false));
        desenho.addElement(new Ponto(14, 10, 1, false));
        desenho.addElement(new Ponto(12, 6, 1, false));
        desenho.addElement(new Ponto(10, 10, 1, false));

        //Triângulo fora de trás
        desenho.addElement(new Ponto(10, 10, 2, true));
        desenho.addElement(new Ponto(10, 10, 2, false));
        desenho.addElement(new Ponto(14, 10, 2, false));
        desenho.addElement(new Ponto(12, 6, 2, false));
        desenho.addElement(new Ponto(10, 10, 2, false));

        //Triangulo fora ligação
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(10, 10, 2, false));
        desenho.addElement(new Ponto(14, 10, 1, true));
        desenho.addElement(new Ponto(14, 10, 2, false));
        desenho.addElement(new Ponto(12, 6, 1, true));
        desenho.addElement(new Ponto(12, 6, 2, false));
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(10, 10, 2, false));

        //Triângulo dentro
        desenho.addElement(new Ponto(11, 9.5, 1, true));
        desenho.addElement(new Ponto(11, 9.5, 1, false));
        desenho.addElement(new Ponto(13, 9.5, 1, false));
        desenho.addElement(new Ponto(12, 7.2, 1, false));
        desenho.addElement(new Ponto(11, 9.5, 1, false));

        //Triângulo dentro de trás
        desenho.addElement(new Ponto(11, 9.5, 2, true));
        desenho.addElement(new Ponto(11, 9.5, 2, false));
        desenho.addElement(new Ponto(13, 9.5, 2, false));
        desenho.addElement(new Ponto(12, 7.2, 2, false));
        desenho.addElement(new Ponto(11, 9.5, 2, false));

        //Triângulo dentro ligação
        desenho.addElement(new Ponto(11, 9.5, 1, true));
        desenho.addElement(new Ponto(11, 9.5, 2, false));
        desenho.addElement(new Ponto(13, 9.5, 1, true));
        desenho.addElement(new Ponto(13, 9.5, 2, false));
        desenho.addElement(new Ponto(12, 7.2, 1, true));
        desenho.addElement(new Ponto(12, 7.2, 2, false));
        desenho.addElement(new Ponto(11, 9.5, 1, true));
        desenho.addElement(new Ponto(11, 9.5, 2, false));

        //Quadrado
        desenho.addElement(new Ponto(14.5, 10, 1, true));
        desenho.addElement(new Ponto(14.5, 10, 1, false));
        desenho.addElement(new Ponto(18.5, 10, 1, false));
        desenho.addElement(new Ponto(18.5, 6, 1, false));
        desenho.addElement(new Ponto(14.5, 6, 1, false));
        desenho.addElement(new Ponto(14.5, 10, 1, false));

        //Quadrado de trás
        desenho.addElement(new Ponto(14.5, 10, 2, true));
        desenho.addElement(new Ponto(14.5, 10, 2, false));
        desenho.addElement(new Ponto(18.5, 10, 2, false));
        desenho.addElement(new Ponto(18.5, 6, 2, false));
        desenho.addElement(new Ponto(14.5, 6, 2, false));
        desenho.addElement(new Ponto(14.5, 10, 2, false));

        //Quadrado ligação
        desenho.addElement(new Ponto(14.5, 10, 1, true));
        desenho.addElement(new Ponto(14.5, 10, 2, false));
        desenho.addElement(new Ponto(18.5, 10, 1, true));
        desenho.addElement(new Ponto(18.5, 10, 2, false));
        desenho.addElement(new Ponto(18.5, 6, 1, true));
        desenho.addElement(new Ponto(18.5, 6, 2, false));
        desenho.addElement(new Ponto(14.5, 6, 1, true));
        desenho.addElement(new Ponto(14.5, 6, 2, false));
        desenho.addElement(new Ponto(14.5, 10, 1, true));
        desenho.addElement(new Ponto(14.5, 10, 2, false));

        //Quadrado dentro
        desenho.addElement(new Ponto(15.2, 9.5, 1, true));
        desenho.addElement(new Ponto(15.2, 9.5, 1, false));
        desenho.addElement(new Ponto(17.8, 9.5, 1, false));
        desenho.addElement(new Ponto(17.8, 6.5, 1, false));
        desenho.addElement(new Ponto(15.2, 6.5, 1, false));
        desenho.addElement(new Ponto(15.2, 9.5, 1, false));

        //Quadrado dentro atrás
        desenho.addElement(new Ponto(15.2, 9.5, 2, true));
        desenho.addElement(new Ponto(15.2, 9.5, 2, false));
        desenho.addElement(new Ponto(17.8, 9.5, 2, false));
        desenho.addElement(new Ponto(17.8, 6.5, 2, false));
        desenho.addElement(new Ponto(15.2, 6.5, 2, false));
        desenho.addElement(new Ponto(15.2, 9.5, 2, false));

        //Quadrado dentro ligação
        desenho.addElement(new Ponto(15.2, 9.5, 1, true));
        desenho.addElement(new Ponto(15.2, 9.5, 2, false));
        desenho.addElement(new Ponto(17.8, 9.5, 1, true));
        desenho.addElement(new Ponto(17.8, 9.5, 2, false));
        desenho.addElement(new Ponto(17.8, 6.5, 1, true));
        desenho.addElement(new Ponto(17.8, 6.5, 2, false));
        desenho.addElement(new Ponto(15.2, 6.5, 1, true));
        desenho.addElement(new Ponto(15.2, 6.5, 2, false));
        desenho.addElement(new Ponto(15.2, 9.5, 1, true));
        desenho.addElement(new Ponto(15.2, 9.5, 2, false));

        //X
        desenho.addElement(new Ponto(19, 10, 1, true));
        desenho.addElement(new Ponto(20, 10, 1, false));
        desenho.addElement(new Ponto(20.5, 8.5, 1, false));
        desenho.addElement(new Ponto(21, 10, 1, false));
        desenho.addElement(new Ponto(22, 10, 1, false));
        desenho.addElement(new Ponto(21.5, 8, 1, false));
        desenho.addElement(new Ponto(22, 6, 1, false));
        desenho.addElement(new Ponto(21, 6, 1, false));
        desenho.addElement(new Ponto(20.5, 7.5, 1, false));
        desenho.addElement(new Ponto(20, 6, 1, false));
        desenho.addElement(new Ponto(19, 6, 1, false));
        desenho.addElement(new Ponto(19.5, 8, 1, false));
        desenho.addElement(new Ponto(19, 10, 1, false));

        //X de trás
        desenho.addElement(new Ponto(19, 10, 2, true));
        desenho.addElement(new Ponto(20, 10, 2, false));
        desenho.addElement(new Ponto(20.5, 8.5, 2, false));
        desenho.addElement(new Ponto(21, 10, 2, false));
        desenho.addElement(new Ponto(22, 10, 2, false));
        desenho.addElement(new Ponto(21.5, 8, 2, false));
        desenho.addElement(new Ponto(22, 6, 2, false));
        desenho.addElement(new Ponto(21, 6, 2, false));
        desenho.addElement(new Ponto(20.5, 7.5, 2, false));
        desenho.addElement(new Ponto(20, 6, 2, false));
        desenho.addElement(new Ponto(19, 6, 2, false));
        desenho.addElement(new Ponto(19.5, 8, 2, false));
        desenho.addElement(new Ponto(19, 10, 2, false));

        //X de ligação
        desenho.addElement(new Ponto(19, 10, 1, true));
        desenho.addElement(new Ponto(19, 10, 2, false));

        desenho.addElement(new Ponto(20, 10, 1, true));
        desenho.addElement(new Ponto(20, 10, 2, false));

        desenho.addElement(new Ponto(20.5, 8.5, 1, true));
        desenho.addElement(new Ponto(20.5, 8.5, 2, false));

        desenho.addElement(new Ponto(21, 10, 1, true));
        desenho.addElement(new Ponto(21, 10, 2, false));

        desenho.addElement(new Ponto(22, 10, 1, true));
        desenho.addElement(new Ponto(22, 10, 2, false));

        desenho.addElement(new Ponto(21.5, 8, 1, true));
        desenho.addElement(new Ponto(21.5, 8, 2, false));

        desenho.addElement(new Ponto(22, 6, 1, true));
        desenho.addElement(new Ponto(22, 6, 2, false));

        desenho.addElement(new Ponto(21, 6, 1, true));
        desenho.addElement(new Ponto(21, 6, 2, false));

        desenho.addElement(new Ponto(20.5, 7.5, 1, true));
        desenho.addElement(new Ponto(20.5, 7.5, 2, false));

        desenho.addElement(new Ponto(20, 6, 1, true));
        desenho.addElement(new Ponto(20, 6, 2, false));

        desenho.addElement(new Ponto(19, 6, 1, true));
        desenho.addElement(new Ponto(19, 6, 2, false));

        desenho.addElement(new Ponto(19.5, 8, 1, true));
        desenho.addElement(new Ponto(19.5, 8, 2, false));

        desenho.addElement(new Ponto(19, 10, 1, true));
        desenho.addElement(new Ponto(19, 10, 2, false));
    }

    public void miniCidade() {
        desenho.addElement(new Ponto(10, 10, 1, true));
        desenho.addElement(new Ponto(15, 10, 1, false));
        desenho.addElement(new Ponto(15, 8, 1, false));
        desenho.addElement(new Ponto(10, 8, 1, false));
        desenho.addElement(new Ponto(10, 10, 1, false));
        desenho.addElement(new Ponto(10, 10, 5, false));
        desenho.addElement(new Ponto(15, 10, 5, false));
        desenho.addElement(new Ponto(15, 10, 1, false));
        desenho.addElement(new Ponto(15, 10, 5, false));
        desenho.addElement(new Ponto(15, 8, 5, false));
        desenho.addElement(new Ponto(10, 8, 5, false));
        desenho.addElement(new Ponto(10, 10, 5, false));
        desenho.addElement(new Ponto(10, 8, 5, false));
        desenho.addElement(new Ponto(10, 8, 1, false));
        desenho.addElement(new Ponto(15, 8, 1, true));
        desenho.addElement(new Ponto(15, 8, 5, false));

        //rua
        desenho.addElement(new Ponto(10, 8, 2, true));
        desenho.addElement(new Ponto(15, 8, 2, false));
        desenho.addElement(new Ponto(15, 8, 3, false));
        desenho.addElement(new Ponto(10, 8, 3, false));

        //1° listra da rua
        desenho.addElement(new Ponto(10.2, 8, 2.4, true));
        desenho.addElement(new Ponto(10.2, 8, 2.6, false));
        desenho.addElement(new Ponto(11.2, 8, 2.6, false));
        desenho.addElement(new Ponto(11.2, 8, 2.4, false));
        desenho.addElement(new Ponto(10.2, 8, 2.4, false));

        //2° listra da rua
        desenho.addElement(new Ponto(11.4, 8, 2.4, true));
        desenho.addElement(new Ponto(11.4, 8, 2.6, false));
        desenho.addElement(new Ponto(12.4, 8, 2.6, false));
        desenho.addElement(new Ponto(12.4, 8, 2.4, false));
        desenho.addElement(new Ponto(11.4, 8, 2.4, false));

        //3° listra da rua
        desenho.addElement(new Ponto(12.6, 8, 2.4, true));
        desenho.addElement(new Ponto(12.6, 8, 2.6, false));
        desenho.addElement(new Ponto(13.6, 8, 2.6, false));
        desenho.addElement(new Ponto(13.6, 8, 2.4, false));
        desenho.addElement(new Ponto(12.6, 8, 2.4, false));

        //4° listra da rua
        desenho.addElement(new Ponto(13.8, 8, 2.4, true));
        desenho.addElement(new Ponto(13.8, 8, 2.6, false));
        desenho.addElement(new Ponto(14.8, 8, 2.6, false));
        desenho.addElement(new Ponto(14.8, 8, 2.4, false));
        desenho.addElement(new Ponto(13.8, 8, 2.4, false));

        //1° prédio
        desenho.addElement(new Ponto(10, 8, 5, true));
        desenho.addElement(new Ponto(10, 3, 5, false));
        desenho.addElement(new Ponto(12, 3, 5, false));
        desenho.addElement(new Ponto(10, 3, 5, false));
        desenho.addElement(new Ponto(10, 3, 3, false));
        desenho.addElement(new Ponto(10, 8, 3, false));
        desenho.addElement(new Ponto(12, 8, 3, false));
        desenho.addElement(new Ponto(12, 3, 3, false));
        desenho.addElement(new Ponto(10, 3, 3, false));
        desenho.addElement(new Ponto(12, 3, 3, true));
        desenho.addElement(new Ponto(12, 3, 5, false));
        desenho.addElement(new Ponto(12, 8, 5, false));

        //porta do prédio 1
        desenho.addElement(new Ponto(10.5, 8, 3, true));
        desenho.addElement(new Ponto(10.5, 7, 3, false));
        desenho.addElement(new Ponto(11.5, 7, 3, false));
        desenho.addElement(new Ponto(11.5, 8, 3, false));
        desenho.addElement(new Ponto(11, 7, 3, true));
        desenho.addElement(new Ponto(11, 8, 3, false));

        //1° janela do prédio 1
        desenho.addElement(new Ponto(10.25, 6.75, 3, true));
        desenho.addElement(new Ponto(11.75, 6.75, 3, false));
        desenho.addElement(new Ponto(11.75, 6.25, 3, false));
        desenho.addElement(new Ponto(10.25, 6.25, 3, false));
        desenho.addElement(new Ponto(10.25, 6.75, 3, false));
        desenho.addElement(new Ponto(11, 6.75, 3, false));
        desenho.addElement(new Ponto(11, 6.25, 3, false));

        //2° janela do prédio 1
        desenho.addElement(new Ponto(10.25, 6, 3, true));
        desenho.addElement(new Ponto(11.75, 6, 3, false));
        desenho.addElement(new Ponto(11.75, 5.5, 3, false));
        desenho.addElement(new Ponto(10.25, 5.5, 3, false));
        desenho.addElement(new Ponto(10.25, 6, 3, false));
        desenho.addElement(new Ponto(11, 6, 3, false));
        desenho.addElement(new Ponto(11, 5.5, 3, false));

        //3° janela do prédio 1
        desenho.addElement(new Ponto(10.25, 5.25, 3, true));
        desenho.addElement(new Ponto(11.75, 5.25, 3, false));
        desenho.addElement(new Ponto(11.75, 4.75, 3, false));
        desenho.addElement(new Ponto(10.25, 4.75, 3, false));
        desenho.addElement(new Ponto(10.25, 5.25, 3, false));
        desenho.addElement(new Ponto(11, 5.25, 3, false));
        desenho.addElement(new Ponto(11, 4.75, 3, false));

        //4° janela do prédio 1
        desenho.addElement(new Ponto(10.25, 4.5, 3, true));
        desenho.addElement(new Ponto(11.75, 4.5, 3, false));
        desenho.addElement(new Ponto(11.75, 4, 3, false));
        desenho.addElement(new Ponto(10.25, 4, 3, false));
        desenho.addElement(new Ponto(10.25, 4.5, 3, false));
        desenho.addElement(new Ponto(11, 4.5, 3, false));
        desenho.addElement(new Ponto(11, 4, 3, false));

        //5° janela do prédio 1
        desenho.addElement(new Ponto(10.25, 3.75, 3, true));
        desenho.addElement(new Ponto(11.75, 3.75, 3, false));
        desenho.addElement(new Ponto(11.75, 3.25, 3, false));
        desenho.addElement(new Ponto(10.25, 3.25, 3, false));
        desenho.addElement(new Ponto(10.25, 3.75, 3, false));
        desenho.addElement(new Ponto(11, 3.75, 3, false));
        desenho.addElement(new Ponto(11, 3.25, 3, false));

        //2° prédio
        desenho.addElement(new Ponto(12, 5, 3, true));
        desenho.addElement(new Ponto(12, 5, 3, false));
        desenho.addElement(new Ponto(15, 5, 3, false));
        desenho.addElement(new Ponto(15, 8, 3, false));
        desenho.addElement(new Ponto(15, 8, 5, false));
        desenho.addElement(new Ponto(15, 5, 5, false));
        desenho.addElement(new Ponto(15, 5, 3, false));
        desenho.addElement(new Ponto(15, 5, 5, false));
        desenho.addElement(new Ponto(15, 5, 5, false));
        desenho.addElement(new Ponto(12, 5, 5, false));
        desenho.addElement(new Ponto(12, 5, 3, false));

        //porta do 2° prédio
        desenho.addElement(new Ponto(13, 8, 3, true));
        desenho.addElement(new Ponto(13, 8, 3, false));
        desenho.addElement(new Ponto(13, 7, 3, false));
        desenho.addElement(new Ponto(14, 7, 3, false));
        desenho.addElement(new Ponto(14, 8, 3, false));

        //janela da esquerda do predio 2
        desenho.addElement(new Ponto(12.15, 7.75, 3, true));
        desenho.addElement(new Ponto(12.15, 7.75, 3, false));
        desenho.addElement(new Ponto(12.85, 7.75, 3, false));
        desenho.addElement(new Ponto(12.85, 7.15, 3, false));
        desenho.addElement(new Ponto(12.15, 7.15, 3, false));
        desenho.addElement(new Ponto(12.15, 7.75, 3, false));

        //janela da direita do predio 2
        desenho.addElement(new Ponto(14.15, 7.75, 3, true));
        desenho.addElement(new Ponto(14.15, 7.75, 3, false));
        desenho.addElement(new Ponto(14.85, 7.75, 3, false));
        desenho.addElement(new Ponto(14.85, 7.15, 3, false));
        desenho.addElement(new Ponto(14.15, 7.15, 3, false));
        desenho.addElement(new Ponto(14.15, 7.75, 3, false));

        //janela do segundo andar do prédio 2
        desenho.addElement(new Ponto(12.15, 6.75, 3, true));
        desenho.addElement(new Ponto(12.15, 6.75, 3, false));
        desenho.addElement(new Ponto(14.85, 6.75, 3, false));
        desenho.addElement(new Ponto(14.85, 6, 3, false));
        desenho.addElement(new Ponto(12.15, 6, 3, false));
        desenho.addElement(new Ponto(12.15, 6.75, 3, false));
        desenho.addElement(new Ponto(13.05, 6.75, 3, false));
        desenho.addElement(new Ponto(13.05, 6, 3, false));
        desenho.addElement(new Ponto(13.95, 6, 3, false));
        desenho.addElement(new Ponto(13.95, 6.75, 3, false));

        //janela do terceiro andar do prédio 2
        desenho.addElement(new Ponto(12.15, 5.9, 3, true));
        desenho.addElement(new Ponto(12.15, 5.1, 3, false));
        desenho.addElement(new Ponto(14.85, 5.1, 3, false));
        desenho.addElement(new Ponto(14.85, 5.9, 3, false));
        desenho.addElement(new Ponto(12.15, 5.9, 3, false));
        desenho.addElement(new Ponto(12.825, 5.9, 3, false));
        desenho.addElement(new Ponto(12.825, 5.1, 3, false));
        desenho.addElement(new Ponto(13.5, 5.1, 3, false));
        desenho.addElement(new Ponto(13.5, 5.9, 3, false));
        desenho.addElement(new Ponto(14.175, 5.9, 3, false));
        desenho.addElement(new Ponto(14.175, 5.1, 3, false));
        desenho.addElement(new Ponto(14.85, 5.1, 3, false));
        desenho.addElement(new Ponto(14.85, 5.5, 3, false));
        desenho.addElement(new Ponto(12.15, 5.5, 3, false));
        
    }

    public void translada(double dx, double dy, double dz) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
            p.setZ(p.getZ() + dz);
            desenho.set(i, p);
        }

    }

    public void rotaciona(double h, double q, double b) {
        double m[][] = new double[4][4];
        double ch = Math.cos(h);
        double cp = Math.cos(q);
        double cb = Math.cos(b);
        double sh = Math.sin(h);
        double sp = Math.sin(q);
        double sb = Math.sin(b);
        m[1][1] = ch * cb - sh * sp * sb;
        m[1][2] = sb * ch + cb * sp * sh;
        m[1][3] = -cp * sh;
        m[2][1] = -sb * cp;
        m[2][2] = cb * cp;
        m[2][3] = sp;
        m[3][1] = cb * sh + sb * sp * ch;
        m[3][2] = sb * sh - cb * sp * ch;
        m[3][3] = ch * cp;
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            double x = p.getX();
            double y = p.getY();
            double z = p.getZ();
            double xx = (x * m[1][1] + y * m[1][2] + z * m[1][3]);
            double yy = (x * m[2][1] + y * m[2][2] + z * m[2][3]);
            double zz = (x * m[3][1] + y * m[3][2] + z * m[3][3]);
            p.setX(xx);
            p.setY(yy);
            p.setZ(zz);
            desenho.set(i, p);
        }

    }

    public void deforma(boolean maior) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            if (maior) {
                p = (Ponto) desenho.get(i);
                p.setX(((p.getX() - getCentrox()) * 0.1) + p.getX());
                p.setY(((p.getY() - getCentroy()) * 0.1) + p.getY());
                p.setZ((p.getZ() * 0.1) + p.getZ());
                desenho.set(i, p);
            } else {
                p = (Ponto) desenho.get(i);
                p.setX(p.getX() - ((p.getX() - getCentrox()) * 0.1));
                p.setY(p.getY() - ((p.getY() - getCentroy()) * 0.1));
                p.setZ(p.getZ() - (p.getZ() * 0.1));
                desenho.set(i, p);
            }
        }
    }

    public double getCentroy() {
        return centroy;
    }

    public void setCentroy(double centroy) {
        this.centroy = centroy;
    }

    public double getCentrox() {
        return centrox;
    }

    public void setCentrox(double centrox) {
        this.centrox = centrox;
    }
}
