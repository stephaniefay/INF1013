package Frames;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Visual.DrawAnalClock;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Stephanie Fay
 */
@SuppressWarnings("serial")
public class Analogico extends JFrame{
	public final int WIDTH = 465;
	public final int HEIGHT = 490;
	
	
	public Analogico () {
		ImageIcon img = new ImageIcon("Imagens/clock-icon.png");
		this.setSize(WIDTH, HEIGHT);
                
                setTitle("Relógio Analógico");
		this.setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                this.setLocation(250, 250);
                
		DrawAnalClock m = DrawAnalClock.getInstance();
		getContentPane().add(m);	
		this.setVisible(true);
	}
	
        public void atualiza () {
            repaint();
        }
}