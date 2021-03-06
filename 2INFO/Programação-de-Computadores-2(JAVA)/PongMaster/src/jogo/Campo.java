/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 2info2021
 */
public class Campo extends JPanel implements ActionListener {

    Bola bola;
    Raquete raquetePc;
    Raquete raqueteJ;
    Timer t;
    Image fundo;
    int pontoJ = 0, pontoPc = 0;
    String msg = "";
    int velocidade = 5;
    int imagemJ = 2;
    int imagemPc = 0;

    public Campo(int largura, final int altura) {
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        fundo = new ImageIcon(this.getClass().getResource("/imagens/bilete.gif")).getImage().getScaledInstance(largura, altura, 1);
        inicializa();
        t = new Timer(10, this);
        t.start();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_UP) {
                    raqueteJ.setDy(-5);
                    imagemJ = 3;
                    System.out.println(bola.getDx());
                }
                if (tecla == KeyEvent.VK_DOWN) {
                    raqueteJ.setDy(5);
                    imagemJ = 3;
                    System.out.println(bola.getDx());
                }
                if (tecla == KeyEvent.VK_SPACE) {
                    raqueteJ.setLargura(500);
                    raqueteJ.setAltura(109);
                    imagemJ = 10;
                } else {
                    raqueteJ.setLargura(100);
                    raqueteJ.setAltura(150);
                }
                if (tecla == 'P' || tecla == 'p') {
                    if (t.isRunning()) {
                        msg = "Pausa";
                        repaint();
                        t.stop();
                    } else {
                        t.restart();
                        msg = "";
                    }
                }
                if (tecla == 'r' || tecla == 'R') {
                    inicializa();
                    t.start();
                }
                if (tecla == KeyEvent.VK_SPACE && pontoJ < 5 && pontoPc < 5) {
                    msg = "";
                    t.start();
                }
            }

            public void keyReleased(KeyEvent e) {
                raqueteJ.setDy(0);
                imagemJ = 2;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bola.mexer();
        raquetePc.mexer();
        raqueteJ.mexer();
        if (raqueteJ.getY() > this.getHeight() - raqueteJ.getAltura()) {
            raqueteJ.setY(this.getHeight() - raqueteJ.getAltura());
        }
        if (raqueteJ.getY() < 0) {
            raqueteJ.setY(0);
        }
        if (verificaColisao(bola, raqueteJ)) {
            if (bola.getDx() > 0) {
                bola.setDx(-velocidade);
                bola.setImagem(new ImageIcon(getClass().getResource("/imagens/bola3.gif")).getImage().getScaledInstance(bola.getLargura(), bola.getAltura(), 1));
                bola.setDy(new Random().nextDouble() * Math.signum(bola.getDy()) * 10);
                if (velocidade <= 25) {
                    velocidade += 2;
                }
            }
        }
        if (verificaColisao(bola, raquetePc)) {
            if (bola.getDx() < 0) {
                bola.setDx(velocidade);
                bola.setImagem(new ImageIcon(getClass().getResource("/imagens/bola.gif")).getImage().getScaledInstance(bola.getLargura(), bola.getAltura(), 1));
                bola.setDy(new Random().nextDouble() * Math.signum(bola.getDy()) * 5);
                if (velocidade <= 25) {
                    velocidade += 2;
                }
            }
        }
        if (bola.getY() < 10 || bola.getY() > this.getHeight() - bola.getAltura()) {
            bola.setDy(-bola.getDy());
        }
        mexerPc();
        verificaPonto();
        repaint();
        msg = "";
        msg = "Velocidade: " + bola.getDx();
    }

    private void inicializa() {
        raquetePc = new Raquete(10, this.getHeight() / 2);
        raqueteJ = new Raquete(this.getWidth() - 160, this.getHeight() / 2);
        bola = new Bola(raquetePc.getLargura() + 10, this.getHeight() / 2);
        pontoJ = 0;
        pontoPc = 0;
        msg = "";
    }

    private void verificaPonto() {
        if (bola.getX() < 0) {
            bola.setX(raqueteJ.getX() - raqueteJ.getLargura());
            bola.setY(raqueteJ.getY());
            velocidade = 5;
            bola.setDy(new Random().nextDouble() * Math.signum(bola.getDy()) * 5);
            bola.setDx(-velocidade);
            pontoJ++;
            t.stop();
            imagemJ = 5;
            imagemPc = 4;
            msg = "Ponto para Jogador - Espa??o para continuar";
        }
        if (bola.getX() > this.getWidth()) {
            bola.setX(raquetePc.getX() + raquetePc.getLargura());
            bola.setY(raquetePc.getY());
            bola.setDy(new Random().nextDouble() * Math.signum(bola.getDy()) * 5);
            bola.setDx(5);
            pontoPc++;
            velocidade = 5;
            t.stop();
            imagemJ = 5;
            imagemPc = 4;
            msg = "Ponto para PC - Espa??o para continuar";
        }
        if (pontoJ > 4) {
            msg = "Jogador Ganhou! 'R' - Reinicia o Jogo";
            t.stop();
            imagemJ = 7;
            imagemPc = 8;
            repaint();
        }
        if (pontoPc > 4) {
            msg = "Pc Ganhou! 'R' - Reinicia o Jogo";
            t.stop();
            imagemJ = 9;
            imagemPc = 6;
            repaint();
        }
    }

    private void mexerPc() {
        if (bola.getX() < this.getWidth() / 2 && bola.getDx() < 0) {
            raquetePc.setDy((3 * Math.signum((int) (bola.getY() - raquetePc.getY()))));
            imagemPc = 1;
        } else {
            raquetePc.setDy(0);
            imagemPc = 0;
        }
    }

    private boolean verificaColisao(Bola b, Raquete r) {
        if (r.getLimites().intersects(b.getLimites())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fundo, 0, 0, null);
        g.setColor(Color.WHITE);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        g.drawImage(bola.getImagem(), (int) bola.getX(), (int) bola.getY(), this);
        g.drawImage(raquetePc.getImagem()[imagemPc], (int) raquetePc.getX(), (int) raquetePc.getY(), this);
        g.drawImage(raqueteJ.getImagem()[imagemJ], (int) raqueteJ.getX(), (int) raqueteJ.getY(), this);
        g.setFont(new Font("Arial", 0, 18));
        g.drawString(pontoPc + " ", this.getWidth() / 4, 50);
        g.drawString(pontoJ + " ", 3 * (this.getWidth() / 4), 50);
        Font f = new Font("Arial", Font.BOLD, 20);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Rectangle2D rect = fm.getStringBounds(msg, g);
        int textWidth = (int) (rect.getWidth());
        int panelWidth = this.getWidth();
        int x = (panelWidth - textWidth) / 2;
        g.drawString(msg, x, 3 * (this.getHeight() / 4));
    }

}
