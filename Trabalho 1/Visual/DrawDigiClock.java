/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logico.Relogio;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Stephanie Fay
 */
public final class DrawDigiClock extends JPanel {

    public JLabel hour = new JLabel();

    private static DrawDigiClock instance = null;

    public static DrawDigiClock getInstance() {
        if (instance == null) {
            instance = new DrawDigiClock();
        }
        return instance;
    }

    public DrawDigiClock() {
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Relogio r = Relogio.getInstance();
        Graphics2D g2 = (Graphics2D) g;
        String str = r.getHour() + " : " + r.getMinute();
        g2.setFont(new Font("Verdana", Font.PLAIN, 90));
        g2.setColor(Color.black);
        g2.drawString(str, 5, 105);
    }

}
