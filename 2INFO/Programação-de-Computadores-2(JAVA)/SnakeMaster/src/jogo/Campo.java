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

public class Campo extends JPanel implements ActionListener {

    Fruta fruta;
    int velocidade = 20;
    Cobra cobra;
    Cobra corpo[] = new Cobra[1000];
    Cenario cenario[] = new Cenario[40];
    int tamanhocenario = 4;
    int tamanho = 3;
    Timer t;
    Image fundo;
    int pontoJ = 0;
    int vida = 3;
    String msg = "";
    Image imagemCabecaCima;
    Image imagemCabecaBaixo;
    Image imagemCabecaDireita;
    Image imagemCabecaEsquerda;
    TocaAudio tocaAudio = new TocaAudio("/som/ciclo.mp3");

    public Campo(int largura, final int altura) {
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        fundo = new ImageIcon(this.getClass().getResource("/imagens/campo.png")).getImage().getScaledInstance(largura,
                altura, 1);
        inicializa();
        repaint();
        t = new Timer(100, this);
        t.start();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_UP) {
                    cobra.setDy(-velocidade);
                    cobra.setDx(0);
                    cobra.setImagem(imagemCabecaCima);
                }
                if (tecla == KeyEvent.VK_DOWN) {
                    cobra.setDy(velocidade);
                    cobra.setDx(0);
                    cobra.setImagem(imagemCabecaBaixo);
                }
                if (tecla == KeyEvent.VK_LEFT) {
                    cobra.setDx(-velocidade);
                    cobra.setDy(0);
                    cobra.setImagem(imagemCabecaEsquerda);
                }
                if (tecla == KeyEvent.VK_RIGHT) {
                    cobra.setDx(velocidade);
                    cobra.setDy(0);
                    cobra.setImagem(imagemCabecaDireita);
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
                if (tecla == KeyEvent.VK_SPACE && vida == 0) {
                    msg = "";
                    t.start();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tocaAudio.isAlive()) {
            tocaAudio.start();
        }
        for (int i = tamanho - 1; i > 0; i--) {
            corpo[i].setX(corpo[i - 1].getX());
            corpo[i].setY(corpo[i - 1].getY());
        }
        corpo[0].setX(cobra.getX());
        corpo[0].setY(cobra.getY());
        cobra.mexer();
        if (verificaColisaoFruta(fruta, cobra)) {
            corpo[tamanho] = new Cobra();
            corpo[tamanho++].setImagem(new ImageIcon(this.getClass().getResource("/imagens/corpo.png")).getImage().getScaledInstance(20, 20, 1));
            posicionaFruta();
        }
        if (verificaColisaoCorpo()) {
            t.stop();
            msg = "Game Over";
        }
        if (verificaColisaoCenario()) {
            t.stop();
            msg = "Game Over";
        }
        repaint();
    }

    private void posicionaFruta() {
        boolean ok = false;
        int x, y;
        while (!ok) {
            ok = true;
            x = new Random().nextInt(this.getWidth());
            y = new Random().nextInt(this.getHeight());
            fruta = new Fruta(x, y);
            if (verificaColisaoFruta(fruta, cobra)) {
                ok = false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (verificaColisaoFruta(fruta, corpo[i])) {
                    ok = false;
                }
            }
            for (int i = 0; i < tamanhocenario; i++) {
                if (verificaColisaoFruta(fruta, cenario[i])) {
                    ok = false;
                }
            }
        }
    }

    private void inicializa() {
        cobra = new Cobra(500, 400);
        cobra.setDx(-velocidade);
        corpo[0] = new Cobra(520, 400);
        corpo[0].setImagem(new ImageIcon(this.getClass().getResource("/imagens/corpo.png")).getImage().getScaledInstance(corpo[0].getLargura(), corpo[0].getAltura(), 1));
        corpo[1] = new Cobra(540, 400);
        corpo[1].setImagem(new ImageIcon(this.getClass().getResource("/imagens/corpo.png")).getImage().getScaledInstance(corpo[1].getLargura(), corpo[1].getAltura(), 1));
        corpo[2] = new Cobra(560, 400);
        corpo[2].setImagem(new ImageIcon(this.getClass().getResource("/imagens/corpo.png")).getImage().getScaledInstance(corpo[2].getLargura(), corpo[2].getAltura(), 1));
        msg = "";
        tamanho = 3;
        cenario1();
        posicionaFruta();
        imagemCabecaCima = new ImageIcon(getClass().getResource("/imagens/cobracima.png")).getImage().getScaledInstance(cobra.getLargura(), cobra.getAltura(), 1);
        imagemCabecaBaixo = new ImageIcon(getClass().getResource("/imagens/cobrabaixo.png")).getImage().getScaledInstance(cobra.getLargura(), cobra.getAltura(), 1);
        imagemCabecaDireita = new ImageIcon(getClass().getResource("/imagens/cobradir.png")).getImage().getScaledInstance(cobra.getLargura(), cobra.getAltura(), 1);
        imagemCabecaEsquerda = new ImageIcon(getClass().getResource("/imagens/cobraesq.png")).getImage().getScaledInstance(cobra.getLargura(), cobra.getAltura(), 1);
        cobra.setImagem(imagemCabecaEsquerda);
    }

    private boolean verificaColisaoFruta(Fruta b, Cobra r) {
        if (r.getLimites().intersects(b.getLimites())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaColisaoFruta(Fruta b, Cenario r) {
        if (r.getLimites().intersects(b.getLimites())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaColisaoCorpo() {
        for (int i = 0; i < tamanho; i++) {
            if (cobra.getLimites().intersects(corpo[i].getLimites())) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaColisaoCenario() {
        for (int i = 0; i < tamanhocenario; i++) {
            if (cobra.getLimites().intersects(cenario[i].getLimites())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fundo, 0, 0, null);
        g.setColor(Color.WHITE);
        g.drawImage(cobra.getImagem(), (int) cobra.getX(), (int) cobra.getY(), this);
        for (int i = 0; i < tamanho; i++) {
            g.drawImage(corpo[i].getImagem(), (int) corpo[i].getX(), (int) corpo[i].getY(), this);
        }
        for (int i = 0; i < tamanhocenario; i++) {
            g.drawImage(cenario[i].getImagem(), (int) cenario[i].getX(), (int) cenario[i].getY(), this);
        }
        g.drawImage(fruta.getImagem(), (int) fruta.getX(), (int) fruta.getY(), this);
        Font f = new Font("Arial", Font.BOLD, 20);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Rectangle2D rect = fm.getStringBounds(msg, g);
        int textWidth = (int) (rect.getWidth());
        int panelWidth = this.getWidth();
        int x = (panelWidth - textWidth) / 2;
        g.drawString(msg, x, 3 * (this.getHeight() / 4));
    }

    private void cenario1() {
        cenario[0] = new Cenario(0, 0, 25, 150); //cerca esquerda primeira vertical
        cenario[0].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[0].getLargura(), cenario[0].getAltura(), 1));
        cenario[1] = new Cenario(0, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[1].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[2] = new Cenario(0, 650, 150, 50);
        cenario[2].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[3] = new Cenario(970, 0, 25, 150); //cerca da direita primeira
        cenario[3].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[4] = new Cenario(43453, 100, 25, 500);
        cenario[5] = new Cenario(77534530, 100, 25, 500);
        cenario[6] = new Cenario(100, 123, 96, 96);
        cenario[7] = new Cenario(500, 150, 96, 96);
        cenario[8] = new Cenario(750, 120, 96, 96);
        cenario[9] = new Cenario(0, 150, 25, 150);//cerca esquerda segunda vertical
        cenario[9].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[9].getLargura(), cenario[9].getAltura(), 1));
        cenario[10] = new Cenario(0, 300, 25, 150);//cerca esquerda terceira vertical
        cenario[10].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[9].getLargura(), cenario[9].getAltura(), 1));
        cenario[11] = new Cenario(0, 450, 25, 150);//cerca esquerda quarta vertical
        cenario[11].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[9].getLargura(), cenario[9].getAltura(), 1));
        cenario[12] = new Cenario(0, 600, 25, 150);//cerca esquerda quinta vertical
        cenario[12].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[9].getLargura(), cenario[9].getAltura(), 1));
        cenario[13] = new Cenario(125, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[13].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[14] = new Cenario(250, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[14].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[15] = new Cenario(375, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[15].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[16] = new Cenario(500, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[16].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[17] = new Cenario(625, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[17].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[18] = new Cenario(750, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[18].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[19] = new Cenario(875, 0, 150, 42); // cerca de cima primeira horizontal
        cenario[19].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[1].getLargura(), cenario[1].getAltura(), 1));
        cenario[20] = new Cenario(125, 650, 150, 50);
        cenario[20].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[21] = new Cenario(250, 650, 150, 50);
        cenario[21].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[22] = new Cenario(375, 650, 150, 50);
        cenario[22].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[23] = new Cenario(500, 650, 150, 50);
        cenario[23].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[24] = new Cenario(625, 650, 150, 50);
        cenario[24].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[25] = new Cenario(750, 650, 150, 50);
        cenario[25].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[26] = new Cenario(875, 650, 150, 50);
        cenario[26].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca2.png")).getImage().getScaledInstance(cenario[2].getLargura(), cenario[2].getAltura(), 1));
        cenario[27] = new Cenario(970, 105, 25, 150); //cerca da direita primeira
        cenario[27].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[28] = new Cenario(970, 210, 25, 150); //cerca da direita primeira
        cenario[28].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[29] = new Cenario(970, 315, 25, 150); //cerca da direita primeira
        cenario[29].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[30] = new Cenario(970, 420, 25, 150); //cerca da direita primeira
        cenario[30].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[31] = new Cenario(970, 525, 25, 200); //cerca da direita primeira
        cenario[31].setImagem(new ImageIcon(this.getClass().getResource("/imagens/cerca1.png")).getImage().getScaledInstance(cenario[3].getLargura(), cenario[3].getAltura(), 1));
        cenario[32] = new Cenario(750, 500, 96, 96);
        cenario[33] = new Cenario(500, 470, 96, 96);
        cenario[34] = new Cenario(300, 470, 96, 96);
        cenario[35] = new Cenario(250, 300, 96, 96);
        cenario[36] = new Cenario(400, 500, 96, 96);
        tamanhocenario = 37;
    }
}
