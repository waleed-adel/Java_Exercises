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

public class MyClass extends Applet {
    
    int x = 0;
    int y = 100;
    int z = 0;
    int flagX = 0;
    int flagY = 1;
    
    @Override
    public void init(){
    
    //for string marquee    
    Thread stMarquee = new Thread (new Runnable() //creates an object from Thread class that implements Runnable
    { 
       @Override
       public void run(){                                 
                                                               
            while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Exception ya m3lm!!");
            }
            z += 10;                                                                           
          }
        }
    });//end of thread #1
            
     //for bouncing ball
     Thread b_ball = new Thread (
     new Runnable(){
        
         @Override
        public void run (){
         
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
     });//end of thread #2
   
    stMarquee.start();
    b_ball.start();
  }          
    @Override
    public void paint (Graphics g){
        
        //draw string marquee
        if (z >= getWidth()) {
            z = 0;
        }
        g.drawString("kalam bymshy", z, 120);
    
        //draw bouncing ball
        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.black);
    }
}
             