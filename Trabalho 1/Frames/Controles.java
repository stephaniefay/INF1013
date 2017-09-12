/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Visual.DrawControls;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Stephanie Fay
 */
public class Controles extends JFrame {
    public final int WIDTH = 400;
    public final int HEIGHT = 200;
    
    
    public Controles () {
        ImageIcon img = new ImageIcon("Imagens/clock-icon.png");
		this.setSize(WIDTH, HEIGHT);

		setTitle("Controles");
		this.setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                	
                this.setLocation(20, 40);
                
                DrawControls m = DrawControls.getInstance();
                getContentPane().add(m);
		this.setVisible(true);
    }
}
