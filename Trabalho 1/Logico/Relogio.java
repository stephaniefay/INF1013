/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import java.util.Calendar;

/**
 *
 * @author Stephanie Fay
 */
public class Relogio {

    private static int hour;
    private static int minute;
    private static int seconds;

    private static Relogio instance = null;

    public Relogio() {
        Calendar calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);
    }

    public static Relogio getInstance() {
        if (instance == null) {
            instance = new Relogio();
        }
        return instance;
    }
    
    public void incMinute () {
        this.minute++;
        if (this.minute == 60) {
            this.minute = 0;
            this.hour++;
        }
    }

    public void setTime(int hour, int minute, int second) {
        if (second == 60)
            this.seconds = 0;
        else
            this.seconds = second;
        if (minute == 60)
            this.minute = 0;
        else
            this.minute = minute;
        if (hour == 24)
            this.hour = 0;
        else
            this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }

}
