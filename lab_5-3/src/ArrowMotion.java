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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class ArrowMotion extends Applet implements KeyListener{
   
    int key, x = 150, y = 150;
    Thread date;
    
    @Override
    public void init (){
       
       date = new Thread (new Runnable(){

          @Override
          public void run() {
              
            while(true) 
            {    
               repaint();
               try {
                   date.sleep(1000);
               } catch (InterruptedException ex) {
                   System.out.println("Exception ya m3lm!!");
               }
            }   
          }
      }); 
       date.start();
       addKeyListener(this);
    }

    @Override
    public void paint(Graphics g){
        
        Date d = new Date (); 
        g.drawString(d.toString(),x ,y );
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        key = e.getKeyCode();  //getKeyCode is method of object KeyEvent
        switch(key){
            
            case KeyEvent.VK_UP :  //VK_UP,DOWN,etc.. are static Final integers with predefined values 
                                   //(called with name of class because it's static) 
            y-=5;
            break;    
                    
            case KeyEvent.VK_DOWN :
            y+=5;     
            break;     
            
            case KeyEvent.VK_LEFT :      
            x-=5;
            break;
                
            case KeyEvent.VK_RIGHT :
            x+=5;    
            break;    
        }
      repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
