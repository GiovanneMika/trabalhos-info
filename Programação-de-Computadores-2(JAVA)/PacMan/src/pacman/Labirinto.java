/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 2info2021
 */
public class Labirinto extends JPanel implements ActionListener {

    Ghost ghost[] = new Ghost[4];
    PacMan pacman;
    String msg = "";
    Timer t;
    int seq = 0, ponto = 0, comida = 0, tempovulneravela = 0, vida = 3, record;
    char labirinto[][];
    int altura, largura, passoX, passoY;

    public Labirinto(int largura, int altura) {
        setFocusable(true);
        setDoubleBuffered(true);

    }

}
