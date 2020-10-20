/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
import java.awt.*;
import java.applet.Applet;

public class BouncingBall extends Applet implements Runnable{
    
    Thread th;
    int x = 0;
    int y = 80;
    int flagX = 0;
    int flagY = 1;
    
    @Override   //init,start,paint,repaint,stop & destroy are methods of class Applet
    public void init() { 

        th = new Thread(this);  //this points to class BouncingBall that extends applet and implements Runnable        
        th.start();             //start,Run,sleep suspend, resume & stop are methods of class Thread
    }

    @Override
    public void paint(Graphics g) {
        
        g.fillOval(x, y, 20, 20);
    }

    @Override //run is a method of interface runnable and Thread class
    public void run() {

        while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Exception ya m3lm!!");
            }
           if (flagX == 0)
           {
            x += 10;
           }
           else   x -= 10;
           
           if (flagY == 0)
           {
            y += 10;
           }
           else   y -= 10;
           
           if (x <= 0)
           {
            x = 0;
           // x += 10;
           // y -= 10;
            flagX = 0;
           }
           else if ( y <= 0)
           {
            y = 0;
            //y += 10;
            //x += 10;
            flagY = 0;
           }
           else if ( x >= getWidth()-20)
           {
            x = getWidth()-20;
            //x -= 10;
            //y += 10;  
            flagX = 1;
           }  
           else if (y >= getHeight()-20)
           {
             y = getHeight()-20;
             //y -= 10;
             //x -= 10;
             flagY = 1;
           }
        }  
    } 
}    