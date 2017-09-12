/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logico.Relogio;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Stephanie Fay
 */
public final class DrawAnalClock extends JPanel {

    private static DrawAnalClock instance = null;
    private BufferedImage background;

    final int CENTER = 225;
    final double HOUR_HAND_LENGTH = 130;
    final double MINUTE_HAND_LENGTH = 160;
    final double SECOND_HAND_LENGTH = 180;

    private int flag = 0;
    
    private Line2D.Double hourHand;
    private Line2D.Double minuteHand;
    private Line2D.Double secondHand;

    public static DrawAnalClock getInstance() {
        if (instance == null) {
            instance = new DrawAnalClock();
        }
        return instance;
    }

    public DrawAnalClock() {
        this.setLayout(null);
        try {
            background = ImageIO.read(new File("Imagens/analogico.jpg"));
        } catch (IOException ex) {
            System.out.println("Imagem não pode ser lida.");
            System.exit(1);
        }

        hourHand = new Line2D.Double(CENTER, CENTER, CENTER, CENTER - HOUR_HAND_LENGTH);
        minuteHand = new Line2D.Double(CENTER, CENTER, CENTER, CENTER - MINUTE_HAND_LENGTH);
        secondHand = new Line2D.Double(CENTER, CENTER, CENTER, CENTER - SECOND_HAND_LENGTH);


    }

    public void atualizaRelogio() {
        Relogio r = Relogio.getInstance();
        int hour = r.getHour();
        int minute = r.getMinute();
        int second = r.getSeconds();
        final int HOURS_ON_CLOCK = 12;
        final int MINUTES_IN_HOUR = 60;
        final int SECONDS_IN_MINUTE = 60;
        final double HOURS_TO_RADIANS = 2 * Math.PI / HOURS_ON_CLOCK;
        final double MINUTES_TO_RADIANS = 2 * Math.PI / MINUTES_IN_HOUR;
        final double SECONDS_TO_RADIANS = 2 * Math.PI / SECONDS_IN_MINUTE;

        hourHand.setLine(CENTER, CENTER, CENTER + HOUR_HAND_LENGTH * Math.sin((hour + minute / MINUTES_IN_HOUR) * HOURS_TO_RADIANS), CENTER - HOUR_HAND_LENGTH * Math.cos((hour + minute / MINUTES_IN_HOUR) * HOURS_TO_RADIANS));
        minuteHand.setLine(CENTER, CENTER, CENTER + MINUTE_HAND_LENGTH * Math.sin(minute * MINUTES_TO_RADIANS), CENTER - MINUTE_HAND_LENGTH * Math.cos(minute * MINUTES_TO_RADIANS));
        secondHand.setLine(CENTER, CENTER, CENTER + SECOND_HAND_LENGTH * Math.sin(second * SECONDS_TO_RADIANS), CENTER - SECOND_HAND_LENGTH * Math.cos(second * SECONDS_TO_RADIANS));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        atualizaRelogio();        
        g.drawImage(background, 0, 0, 450, 450, null);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g2.setColor(Color.red);
        g2.draw(hourHand);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.blue);
        g2.draw(minuteHand);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.yellow);
        g2.draw(secondHand);

    }

}
