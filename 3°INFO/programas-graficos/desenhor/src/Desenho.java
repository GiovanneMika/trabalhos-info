
/**
 *
 * @author 2info2021
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

public class Desenho {

    private double xwmax, xwmin, ywmax, ywmin, xvmax, xvmin, yvmax, yvmin;
    private double xmax, ymax, xcoord, ycoord, xd, yd, mx, my;
    Vector desenho = new Vector();

    public void setMundo(double x1, double y1, double x2, double y2) {
        xwmax = x2;
        ywmax = y2;
        xwmin = x1;
        ywmin = y1;
    }

    public void setDimension(Dimension d) {
        xmax = d.width;
        ymax = d.height;
    }

    public double getMouseX() {
        return mx;
    }

    public double getMouseY() {
        return my;
    }

    public void setMouse(int x, int y) {
        mx = (((x - xvmin) / ((xvmax - xvmin) / (xwmax - xwmin))) + xwmin) / xmax;
        my = (((y - yvmin) / ((yvmax - yvmin) / (ywmax - ywmin))) + ywmin) / ymax;
    }

    public void setViewPort(double x1, double y1, double x2, double y2) {
        xvmax = x2;
        yvmax = y2;
        xvmin = x1;
        yvmin = y1;
    }

    private void mapCoord(double x, double y) {
        double xv = (((x - xwmin) * ((xvmax - xvmin) / (xwmax - xwmin))) + xvmin);
        double yv = (((y - ywmin) * ((yvmax - yvmin) / (ywmax - ywmin))) + yvmin);
        xd = xv * xmax;
        yd = yv * ymax;

    }

    private void linhaAte(Graphics g, double x, double y) {
        double xi, yi;
        mapCoord(xcoord, ycoord);
        xi = xd;
        yi = yd;
        mapCoord(x, y);
        g.drawLine((int) xi, (int) yi, (int) xd, (int) yd);
        xcoord = x;
        ycoord = y;
    }

    private void movaPara(Graphics g, double x, double y, boolean pu) {
        if (pu) {
            xcoord = x;
            ycoord = y;
        } else {
            linhaAte(g, x, y);
        }
    }

    public void arco(double centroX, double centroY, double raio, double inicio, double fim) {
        desenho.add(new Ponto(centroX + raio * Math.cos(inicio), centroY + raio * Math.sin(inicio), true));
        for (double z = inicio; z <= fim; z += .1) {
            desenho.add(new Ponto(centroX + raio * Math.cos(z), centroY + raio * Math.sin(z), false));
        }
    }

    public void desenha(Graphics g) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            movaPara(g, p.getX(), p.getY(), p.isPu());
        }
    }

    public void triangulo() {
        desenho.addElement(new Ponto(10d, 9d, true));
        desenho.addElement(new Ponto(9d, 11d, false));
        desenho.addElement(new Ponto(11d, 11d, false));
        desenho.addElement(new Ponto(10d, 9d, false));
    }

    public void quadrado() {
        desenho.addElement(new Ponto(11, 9, true));;
        desenho.addElement(new Ponto(9, 9, false));
        desenho.addElement(new Ponto(9, 11, false));
        desenho.addElement(new Ponto(11, 11, false));
        desenho.addElement(new Ponto(11, 9, false));
    }

    public void ge() {
        desenho.addElement(new Ponto(11, 11, true));;
        desenho.addElement(new Ponto(11, 11, false));
        desenho.addElement(new Ponto(11, 4, false));
        desenho.addElement(new Ponto(15, 4, false));
        desenho.addElement(new Ponto(15, 5, false));
        desenho.addElement(new Ponto(11.8, 5, false));
        desenho.addElement(new Ponto(11.8, 10, false));
        desenho.addElement(new Ponto(14.2, 10, false));
        desenho.addElement(new Ponto(14.2, 8, false));
        desenho.addElement(new Ponto(13, 8, false));
        desenho.addElement(new Ponto(13, 7.2, false));
        desenho.addElement(new Ponto(15, 7.2, false));
        desenho.addElement(new Ponto(15, 11, false));
        desenho.addElement(new Ponto(11, 11, false));

    }

    public void giovanne() {
        //G:14
        desenho.addElement(new Ponto(11, 11, true));;
        desenho.addElement(new Ponto(11, 11, false));
        desenho.addElement(new Ponto(11, 4, false));
        desenho.addElement(new Ponto(15, 4, false));
        desenho.addElement(new Ponto(15, 5, false));
        desenho.addElement(new Ponto(11.8, 5, false));
        desenho.addElement(new Ponto(11.8, 10, false));
        desenho.addElement(new Ponto(14.2, 10, false));
        desenho.addElement(new Ponto(14.2, 8, false));
        desenho.addElement(new Ponto(13, 8, false));
        desenho.addElement(new Ponto(13, 7.2, false));
        desenho.addElement(new Ponto(15, 7.2, false));
        desenho.addElement(new Ponto(15, 11, false));
        desenho.addElement(new Ponto(11, 11, false));
        //I:6
        desenho.addElement(new Ponto(16, 11, true));
        desenho.addElement(new Ponto(16, 11, false));
        desenho.addElement(new Ponto(16, 4, false));
        desenho.addElement(new Ponto(17, 4, false));
        desenho.addElement(new Ponto(17, 11, false));
        desenho.addElement(new Ponto(16, 11, false));
        //O:6
        desenho.addElement(new Ponto(18, 11, true));
        desenho.addElement(new Ponto(18, 11, false));
        desenho.addElement(new Ponto(18, 4, false));
        desenho.addElement(new Ponto(21, 4, false));
        desenho.addElement(new Ponto(21, 11, false));
        desenho.addElement(new Ponto(18, 11, false));
        //PARTE DE DENTRO DO O :6
        desenho.addElement(new Ponto(18.5, 10, true));
        desenho.addElement(new Ponto(18.5, 10, false));
        desenho.addElement(new Ponto(18.5, 5, false));
        desenho.addElement(new Ponto(20.5, 5, false));
        desenho.addElement(new Ponto(20.5, 10, false));
        desenho.addElement(new Ponto(18.5, 10, false));
        //V:8
        desenho.addElement(new Ponto(22, 11, true));
        desenho.addElement(new Ponto(23, 11, false));
        desenho.addElement(new Ponto(23.5, 4, false));
        desenho.addElement(new Ponto(23, 4, false));
        desenho.addElement(new Ponto(22.5, 10, false));
        desenho.addElement(new Ponto(22, 4, false));
        desenho.addElement(new Ponto(21.5, 4, false));
        desenho.addElement(new Ponto(22, 11, false));
        //A:11
        desenho.addElement(new Ponto(24, 11, true));
        desenho.addElement(new Ponto(24, 11, false));
        desenho.addElement(new Ponto(25, 4, false));
        desenho.addElement(new Ponto(26, 4, false));
        desenho.addElement(new Ponto(27, 11, false));
        desenho.addElement(new Ponto(26.5, 11, false));
        desenho.addElement(new Ponto(26, 8, false)); //546
        desenho.addElement(new Ponto(25, 8, false));
        desenho.addElement(new Ponto(24.5, 11, false));
        desenho.addElement(new Ponto(24, 11, false));
        desenho.addElement(new Ponto(24, 11, false));
        //triângulo no meio do A:5
        desenho.addElement(new Ponto(26, 7, true));
        desenho.addElement(new Ponto(26, 7, false));
        desenho.addElement(new Ponto(25, 7, false));
        desenho.addElement(new Ponto(25.5, 5, false));
        desenho.addElement(new Ponto(26, 7, false));
        //N:13
        desenho.addElement(new Ponto(28, 11, true));
        desenho.addElement(new Ponto(28, 11, false));
        desenho.addElement(new Ponto(28, 4, false));
        desenho.addElement(new Ponto(29, 4, false));
        desenho.addElement(new Ponto(30, 9, false));
        desenho.addElement(new Ponto(30, 4, false));
        desenho.addElement(new Ponto(31, 4, false));
        desenho.addElement(new Ponto(31, 11, false));
        desenho.addElement(new Ponto(30, 11, false));
        desenho.addElement(new Ponto(29, 6, false));
        desenho.addElement(new Ponto(29, 11, false));
        desenho.addElement(new Ponto(29, 11, false));
        desenho.addElement(new Ponto(28, 11, false));
        //N2:13
        desenho.addElement(new Ponto(32, 11, true));
        desenho.addElement(new Ponto(32, 11, false));
        desenho.addElement(new Ponto(32, 4, false));
        desenho.addElement(new Ponto(33, 4, false));
        desenho.addElement(new Ponto(34, 9, false));
        desenho.addElement(new Ponto(34, 4, false));
        desenho.addElement(new Ponto(35, 4, false));
        desenho.addElement(new Ponto(35, 11, false));
        desenho.addElement(new Ponto(34, 11, false));
        desenho.addElement(new Ponto(33, 6, false));
        desenho.addElement(new Ponto(33, 11, false));
        desenho.addElement(new Ponto(33, 11, false));
        desenho.addElement(new Ponto(32, 11, false));
        //E:15
        desenho.addElement(new Ponto(36, 11, true));
        desenho.addElement(new Ponto(36, 11, false));
        desenho.addElement(new Ponto(36, 11, false));
        desenho.addElement(new Ponto(36, 4, false));
        desenho.addElement(new Ponto(39, 4, false));
        desenho.addElement(new Ponto(39, 5.4, false));
        desenho.addElement(new Ponto(37, 5.4, false));
        desenho.addElement(new Ponto(37, 6.8, false));
        desenho.addElement(new Ponto(39, 6.8, false));
        desenho.addElement(new Ponto(39, 8.2, false));
        desenho.addElement(new Ponto(37, 8.2, false));
        desenho.addElement(new Ponto(37, 9.6, false));
        desenho.addElement(new Ponto(39, 9.6, false));
        desenho.addElement(new Ponto(39, 11, false));
        desenho.addElement(new Ponto(36, 11, false));
    }

    public void raposa() {
        //Circulo
        arco(8, 8, 2.1, 0, 6.3);
        arco(8, 8, 1.3, 0, 6.3);
        //Triângulo
        desenho.addElement(new Ponto(10, 10, true));;
        desenho.addElement(new Ponto(10, 10, false));
        desenho.addElement(new Ponto(14, 10, false));
        desenho.addElement(new Ponto(12, 6, false));
        desenho.addElement(new Ponto(10, 10, false));
        //Triângulo dentro
        desenho.addElement(new Ponto(11, 9.5, true));;
        desenho.addElement(new Ponto(11, 9.5, false));
        desenho.addElement(new Ponto(13, 9.5, false));
        desenho.addElement(new Ponto(12, 7.2, false));
        desenho.addElement(new Ponto(11, 9.5, false));
        //Quadrado
        desenho.addElement(new Ponto(14.5, 10, true));
        desenho.addElement(new Ponto(14.5, 10, false));
        desenho.addElement(new Ponto(18.5, 10, false));
        desenho.addElement(new Ponto(18.5, 6, false));
        desenho.addElement(new Ponto(14.5, 6, false));
        desenho.addElement(new Ponto(14.5, 10, false));
        //Quadrado dentro
        desenho.addElement(new Ponto(15.2, 9.5, true));
        desenho.addElement(new Ponto(15.2, 9.5, false));
        desenho.addElement(new Ponto(17.8, 9.5, false));
        desenho.addElement(new Ponto(17.8, 6.5, false));
        desenho.addElement(new Ponto(15.2, 6.5, false));
        desenho.addElement(new Ponto(15.2, 9.5, false));
        //X
        desenho.addElement(new Ponto(19, 10, true));
        desenho.addElement(new Ponto(20, 10, false));
        desenho.addElement(new Ponto(20.5, 8.5, false));
        desenho.addElement(new Ponto(21, 10, false));
        desenho.addElement(new Ponto(22, 10, false));
        desenho.addElement(new Ponto(21.5, 8, false));
        desenho.addElement(new Ponto(22, 6, false));
        desenho.addElement(new Ponto(21, 6, false));
        desenho.addElement(new Ponto(20.5, 7.5, false));
        desenho.addElement(new Ponto(20, 6, false));
        desenho.addElement(new Ponto(19, 6, false));
        desenho.addElement(new Ponto(19.5, 8, false));
        desenho.addElement(new Ponto(19, 10, false));
    }

    public void cenario() {
        desenho.addElement(new Ponto(10, 10, true));;
        desenho.addElement(new Ponto(10, 11, false));;
        
        
    }

    

    public void translada(double dx, double dy) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
            desenho.set(i, p);
        }
    }

    public void rotaciona(double ang) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {

            p = (Ponto) desenho.get(i);
            double xx = p.getX();
            double yy = p.getY();
            p.setX(xx * Math.cos(ang) + yy * (-Math.sin(ang)));
            p.setY(xx * Math.sin(ang) + yy * Math.cos(ang));
            desenho.set(i, p);
        }
    }

    public void deforma(boolean maior) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            if (maior) {
                p = (Ponto) desenho.get(i);
                p.setX(((p.getX() - mx) * 0.1) + p.getX());
                p.setY(((p.getY() - my) * 0.1) + p.getY());
                desenho.set(i, p);
            } else {
                p = (Ponto) desenho.get(i);
                p.setX(p.getX() - ((p.getX() - mx) * 0.1));
                p.setY(p.getY() - ((p.getY() - my) * 0.1));
                desenho.set(i, p);
            }
        }
    }

}
