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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallGame extends Applet implements Runnable{
    
    Button start;
    Button pause;
    int z, x = 0, y = 100;
    int flagX = 0, flagY = 1;
    volatile boolean selector = true;  //volatile because it's shared resources;  
    Thread stMarquee, b_ball;
    
    @Override
    public void init () {
        
        start = new Button ("Start");  //button is the source that fires the event
        pause =  new Button ("Pause");
        start.addActionListener(new MyStartButton());   
        pause.addActionListener(new MyPauseButton());
        add(start);
        add(pause);
        stMarquee = new Thread (this);  //creates an object that implements runnable
        b_ball = new Thread (this);
   }//end of init
    
    
    @Override
    public void run(){
    
           //for string marquee                                                                                    
            while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Exception ya m3lm!!");
            }
            z += 10;                                                                           
        
            //for bouncing ball
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
    
    class MyStartButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ev){
            
            if (selector == true)
            {    
             stMarquee.start();
             b_ball.start();
            } 
            else 
            {
             stMarquee.resume();
             b_ball.resume();
            }    
        }    
   }//end of inner class #1 
    
    class MyPauseButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ev){
            
           selector = false;
           stMarquee.suspend();
           b_ball.suspend();
       }
    }//end of inner class #2       
}    

