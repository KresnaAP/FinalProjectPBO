package com.kresnaap.snakegame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeCounter implements ActionListener {

    private Timer clock;
    private int hours = 0;
    private int min = 0;
    private int sec = 0;

    public TimeCounter(int hours, int min, int sec) {
        this.hours = hours;
        this.min = min;
        this.sec = sec;

        clock = new Timer(1000, this);
        clock.start();
    }

    public String result()
    {
    	if(hours < 10 && min < 10 && sec < 10)
    	{
    		return "0" + hours + ":" + "0" + min + ":" + "0" + sec;
    	}
    	else if(hours < 10 && min < 10 && sec >= 10)
    	{
    		return "0" + hours + ":" + "0" + min + ":" + sec;
    	}
    	else if(hours < 10 && min >= 10 && sec < 10)
    	{
    		return "0" + hours + ":" + min + ":" + "0" + sec;
    	}
    	else if(hours >= 10 && min < 10 && sec < 10)
    	{
    		return hours + ":" + "0" + min + ":" + "0" + sec;
    	}
    	else if(hours >= 10 && min >= 10 && sec < 10)
    	{
    		return hours + ":" + min + ":" + "0" + sec;
    	}
    	else if(hours >= 10 && min < 10 && sec >= 10)
    	{
    		return hours + ":" + "0" + min + ":" + sec;
    	}
    	else if(hours < 10 && min >= 10 && sec >= 10)
    	{
    		return "0" + hours + ":" + min + ":" + sec;
    	}
    	else
    	{
    		return hours + ":" + min + ":" + sec;
    	}        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        {
            if(e.getSource() == clock) {
                sec++;
            }
            if(sec == 60)
            {
                min++;
                sec = 0;
            }
            if(min == 60)
            {
                hours++;
                min = 0;
            }
        }
    }

    public void actionPerformed() {

    }
}
