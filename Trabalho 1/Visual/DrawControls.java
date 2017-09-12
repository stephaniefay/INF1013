/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logico.ObserverRelogio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Stephanie Fay
 */
public class DrawControls extends JPanel {

    public JButton buttonA = new JButton("A");
    public JButton buttonB = new JButton("B");

    private static DrawControls instance = null;

    public static DrawControls getInstance() {
        if (instance == null) {
            instance = new DrawControls();
        }
        return instance;
    }

    public DrawControls() {
        this.setLayout(null);

        buttonA.setFont(new Font("Verdana", Font.PLAIN, 110));
        Dimension size = buttonA.getPreferredSize();
        buttonA.setBounds(50, 10, size.width, size.height);
        buttonA.setBackground(Color.white);
        buttonA.setVisible(true);
        buttonA.addMouseListener(new MouseListener () {
            @Override
            public void mouseClicked(MouseEvent e) {
                ObserverRelogio.getInstance().changeState("Botão A");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        });
        add(buttonA);

        buttonB.setFont(new Font("Verdana", Font.PLAIN, 110));
        size = buttonB.getPreferredSize();
        buttonB.setBounds(200, 10, size.width, size.height);
        buttonB.setBackground(Color.white);
        buttonB.setVisible(true);
        buttonB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ObserverRelogio.getInstance().changeState("Botão B");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        add(buttonB);

    }

}
