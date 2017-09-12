/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Visual.DrawDigiClock;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Stephanie Fay
 */
public class Digital extends JFrame {
    public final int WIDTH = 400;
    public final int HEIGHT = 200;
    
    
    public Digital () {
        ImageIcon img = new ImageIcon("Imagens/clock-icon.png");
		this.setSize(WIDTH, HEIGHT);

		setTitle("Relógio Digital");
		this.setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                this.setLocation(500, 40);
        	DrawDigiClock m = DrawDigiClock.getInstance();
		getContentPane().add(m);
		this.setVisible(true);
    }

    public void atualiza () {
            repaint();
        }
}
