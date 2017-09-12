/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import Frames.Analogico;
import Frames.Controles;
import Frames.Digital;
import StatePattern.Context;
import StatePattern.NotPressed;
import StatePattern.StartButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Stephanie Fay
 */
public class ObserverRelogio implements ActionListener {
    private static ObserverRelogio instance = null;
    private Timer timer;
    private int contador;
    private final Relogio r = Relogio.getInstance();
    private Analogico a = null;
    private Digital d = null;
    private Context state = new Context();
    
    public static ObserverRelogio getInstance() {
        if (instance == null) {
            instance = new ObserverRelogio();
        }
        return instance;
    }
    
    public ObserverRelogio () { 
        a = new Analogico();
        new Controles();
        d = new Digital();
        NotPressed n = new NotPressed();
        n.doAction(state);
        timer = new Timer(90, this);
        timer.start(); 

        
    }
    
    public void changeState (String id) {
        if (id.equals("Botão A")) {
            String estado = state.getState().toString();
            if (estado.equals("NotPressed")) {
                timer.stop();
                StartButton n = new StartButton();
                n.doAction(state);
            }
            else if (estado.equals("Pressed")) {
                timer.start();
                NotPressed n = new NotPressed();
                n.doAction(state);
            }
            
            
        }
        else if (id.equals("Botão B")) {
            String estado = state.getState().toString();
            if (estado.equals("Pressed")) {
                r.incMinute();
                a.atualiza();
                d.atualiza();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        contador++;
        if (contador == 10) {
            
            int second = r.getSeconds();
            int minute = r.getMinute();
            int hour = r.getHour();
            
            second++;
            if (second == 60) {
                minute++;
                if (minute == 60) {
                    hour++;
                    if (hour > 24) {
                        hour = 1;
                    }
                }
            }
            
            r.setTime(hour, minute, second);
            a.atualiza();
            d.atualiza();
            contador = 0;
        }
        
    }
}
