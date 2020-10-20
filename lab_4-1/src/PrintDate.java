/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
import java.applet.Applet;
import java.awt.*;
import java.util.Date;
        
public class PrintDate extends Applet implements Runnable {
    
    Thread th;
    @Override
    public void init (){
       
      th = new Thread (this);
      th.start();
      
    }

    @Override
    public void paint (Graphics g){
        
        Date d = new Date();
        g.drawString(d.toString(),100,100);
    }
    
    @Override
    public void run (){
        
       while (true)
       {
         repaint();
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               System.out.println("Exception ya m3lm!!");
           }
    }
           
    }
    
}   